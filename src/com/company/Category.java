package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Paula on 08.12.2015.
 */
public class Category {

    public String name;
    ArrayList<Task> tasks;

    public Category(String nm){
        this.name = nm;
        this.tasks = new ArrayList<Task>();
    }

    void printTasks(){
        System.out.println("  |Is done?\t\t" + "|Priority\t\t" + "|Name");
        for (int i = 0; i < this.tasks.size(); i++){
            tasks.get(i).printTask(i+1);
        }
    }

    void addTaskToCategory(Task newTask){
        this.tasks.add(newTask);
    }

    void removeTaskFromCategory(Task newTask) {
        this.tasks.remove(newTask);
    }

    void printIncompleteTasks(){
        int k = 0;
        System.out.println("  |Is done?\t\t" + "|Priority\t\t" + "|Name");
        for (int i = 0; i < this.tasks.size(); i++){
            if (this.tasks.get(i).isDone == false)
                k++;
                this.tasks.get(i).printTask(k);
        }
    }

}
