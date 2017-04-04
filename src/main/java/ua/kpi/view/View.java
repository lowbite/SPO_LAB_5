package ua.kpi.view;

/**
 * Created by Bohdan on 29.03.2017.
 */
public class View {
    public static final String[] MENU = {
            "1. Add person;",
            "2. Show all persons in queue;",
            "3. Change priority;",
            "4. Sort list;",
            "5. Exit;"
    };

    public static final String[] INPUT_FIELDS = {
            "Enter first name: ",
            "Last name: ",
            "Middle name: ",
            "City: ",
            "Street: ",
            "Home number: ",
            "Appartment number(if there is no appartment enter 0): ",
            "Prioririty: "
    };

    public static final String[] OUTPUT_FIELDS = {
            "Full name ",
            "Address: ",
            "Prioririty: "
    };

    public static final String[] CHANGE_FIELDS = {
            "Enter number of person which priority you want to change: ",
            "Enter new priority for this person: "

    };

    public void printInputField(int index){
        System.out.println(INPUT_FIELDS[index]);
    }

    public void printOutputField(int index){ System.out.println(OUTPUT_FIELDS[index]); }

    public void printChangeFields(int index){ System.out.println(CHANGE_FIELDS[index]);}

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMenu(){
        for(String str : MENU){
            System.out.println(str);
        }
    }
}
