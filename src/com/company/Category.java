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

    void printTasks(){
        System.out.println("  |Is done?\t\t" + "|Priority\t\t" + "|Name");
        for (int i = 0; i < this.tasks.size(); i++){
            tasks.get(i).printTask(i+1);
        }
    }

    void addTaskToCategory(Task newTask){
        this.tasks.add(newTask);
    }

    void removeTaskFromCategory(int taskID) {
        this.tasks.remove(taskID);
    }

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
