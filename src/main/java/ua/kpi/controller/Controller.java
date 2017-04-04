package ua.kpi.controller;

import ua.kpi.model.AddressValue;
import ua.kpi.model.Model;
import ua.kpi.model.QueuePerson;
import ua.kpi.model.Validator;
import ua.kpi.view.View;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bohdan on 29.03.2017.
 */
public class Controller {
    final int ADD_MENU_ITEM = 1;
    final int SHOW_MENU_ITEM = 2;
    final int CHANGE_MENU_ITEM = 3;
    final int SORT_MENU_ITEM = 4;
    final int EXIT_MENU_ITEM = 5;

    String MENU_REGEXP =
            "1|2|3|4|5";
    String NAMES_REGEXP =
            "[A-ZА-Я-][a-zа-я-]*";
    String HOME_APPARTMENT_NUMBER_REGEXP =
            "(\\d+-\\w+)|(\\d+)";
    String PRIORITY_REGEXP =
            "\\d+";

    private Model model;
    private View view;
    private Validator validator;
    private Pattern pattern;
    private Scanner scanner = new Scanner(System.in);

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        this.validator = Validator.getInstance();
    }

    public void processUser(){
        while (true) {
            view.printMenu();
            switch (getMenuItem()) {
                case ADD_MENU_ITEM:
                    addQueuePerson();
                    break;
                case SHOW_MENU_ITEM:
                    showList();
                    break;
                case CHANGE_MENU_ITEM:
                    changePriorityQueuePerson();
                    break;
                case SORT_MENU_ITEM:
                    sortList();
                    break;
                case EXIT_MENU_ITEM:
                    System.exit(0);
            }
        }
    }

    private int getMenuItem() {
        Pattern MENU_PATTERN = Pattern.compile(MENU_REGEXP);
        while (!scanner.hasNext(MENU_PATTERN)) {

            view.printMenu();
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    private void addQueuePerson(){
        QueuePerson queuePerson = new QueuePerson();
        int indexInputField = 0;
        pattern = Pattern.compile(NAMES_REGEXP);
        queuePerson.setFirstName(validateInputString(indexInputField++));
        queuePerson.setLastName(validateInputString(indexInputField++));
        queuePerson.setMiddleName(validateInputString(indexInputField++));
        AddressValue address;
        String city = validateInputString(indexInputField++);
        String street = validateInputString(indexInputField++);
        pattern = Pattern.compile(HOME_APPARTMENT_NUMBER_REGEXP);
        String buildingNumber = validateInputString(indexInputField++);
        String flatNumber = validateInputString(indexInputField++);
        address = new AddressValue(city, street, buildingNumber, Integer.parseInt(flatNumber));
        queuePerson.setAddress(address);
        pattern = Pattern.compile(PRIORITY_REGEXP);
        String priority = validateInputString(indexInputField++);
        queuePerson.setPriority(Integer.parseInt(priority));
        model.addQueuePerson(queuePerson);
    }

    private String validateInputString(int indexInputField) {
        view.printInputField(indexInputField);
        String resultString = scanner.next();
        Matcher matcher = pattern.matcher(resultString);
        while ((!resultString.equals("q")) &&   // 'q' - quit from loop;
                (!validator.isValid(matcher.reset(resultString)))) {
            view.printInputField(indexInputField);
            resultString = scanner.next();
        }
        if (resultString.equals("q")) {
            System.exit(0);
        }
        return resultString.trim();
    }

    private void showList(){
        int indexOutputField = 0;
        List<QueuePerson> list = model.getList();
        int listIndex = 0;
        QueuePerson queuePerson;
        AddressValue address;
        while(listIndex < list.size()){
            queuePerson = list.get(listIndex);
            view.printOutputField(indexOutputField++);
            view.printMessage(queuePerson.getFirstName() + " " + queuePerson.getMiddleName() + " " +
                               queuePerson.getLastName());
            view.printOutputField(indexOutputField++);
            address = queuePerson.getAddress();
            view.printMessage(address.getCityName() + " " + address.getStreetName() + " " +
                                address.getHomeNumber() + " " + address.getAppartmentNumber());
            view.printOutputField(indexOutputField++);
            view.printMessage(Integer.toString(queuePerson.getPriority()));
            indexOutputField = 0;
            listIndex++;
        }
    }

    private void changePriorityQueuePerson(){
        int indexChangeField = 0;
        int index;
        List<QueuePerson> list = model.getList();
        while(true) {
            view.printChangeFields(indexChangeField++);
            index = scanner.nextInt();
            if (index < list.size()) {
                QueuePerson queuePerson = list.get(index);
                view.printChangeFields(indexChangeField++);
                queuePerson.setPriority(scanner.nextInt());
                list.remove(index);
                list.add(queuePerson);
                return;
            }
        }
    }

    private void sortList(){
        model.sortList();
    }
}
