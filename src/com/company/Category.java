package com.company;

import java.util.ArrayList;

/**
 * Created by Paula on 08.12.2015.
 */
public class Category {

    public String name;
    ArrayList<Task> tasks;

    public Category(String nm){
        this.name = nm;
        this.tasks = new ArrayList<>();
    }

    // wypisanie taskow z danej kategorii
    void printTasks(){
        System.out.println("  |Is done?\t\t" + "|Priority\t\t" + "|Name");
        for (int i = 0; i < this.tasks.size(); i++){
            tasks.get(i).printTask(i+1);
        }
    }

    // dodanie taska do kategorii
    void addTaskToCategory(Task newTask){
        this.tasks.add(newTask);
    }

    // usuniecie taska z kategorii
    void removeTaskFromCategory(int taskID) {
        this.tasks.remove(taskID);
    }

    // wypisanie z kategorii niedokonczonych taskow
    void printIncompleteTasks(){
        int k = 0;
        System.out.println("  |Is done?\t\t" + "|Priority\t\t" + "|Name");
        for (int i = 0; i < this.tasks.size(); i++){
            if (!this.tasks.get(i).isDone)
                k++;
                this.tasks.get(i).printTask(k);
        }
    }

}
