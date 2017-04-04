package ua.kpi.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bohdan on 28.03.2017.
 */
public class Model {
    List<QueuePerson> list;
    HashSet<String> fullNames;

    public Model(){
        list  = new LinkedList<QueuePerson>();
        fullNames = new HashSet<String>();
    }

    public void addQueuePerson(QueuePerson queuePerson){
        if(fullNames.add(queuePerson.getFirstName() + queuePerson.getLastName() + queuePerson.getMiddleName())){
            list.add(queuePerson);
        }

    }

    public void sortList() {
        Collections.sort(list, QueuePerson.PriorityComparator);
    }

    public List<QueuePerson> getList(){
        return list;
    }


}
