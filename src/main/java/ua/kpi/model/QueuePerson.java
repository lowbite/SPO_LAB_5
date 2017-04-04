package ua.kpi.model;

import java.util.Comparator;

/**
 * Created by Bohdan on 28.03.2017.
 */
public class QueuePerson {
    private String firstName;
    private String lastName;
    private String middleName;
    private AddressValue address;
    private int priority;

    public QueuePerson(){}

    public QueuePerson(String firstName, String secondName,
                       String middleName, AddressValue address, int priority){
        this.firstName = firstName;
        this.lastName = secondName;
        this.middleName = middleName;
        this.address = address;
        this.priority = priority;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public void setAddress(AddressValue address){
        this.address = address;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public String getFirstName(){

        return firstName;
    }

    public String getLastName(){

        return lastName;
    }

    public String getMiddleName(){

        return middleName;
    }

    public int getPriority(){

        return priority;
    }

    public AddressValue getAddress(){
        return address;
    }

    public static Comparator<QueuePerson> PriorityComparator = new Comparator<QueuePerson>() {
        public int compare(QueuePerson o1, QueuePerson o2) {
            return (o1.getPriority() - o2.getPriority());
        }
    };
}
