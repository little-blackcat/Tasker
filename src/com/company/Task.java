package com.company;

/**
 * Created by Paula on 08.12.2015.
 */
public class Task {
    int identificationNumber = 0;
    String name;
    int priority;
    boolean isDone;

    public Task(String nm, int prty){
        this.name = nm;
        this.priority = prty;
        this.isDone = false;
    }

    void printTask(int n){
        System.out.println("|" + n + "|" + this.isDone + "\t\t|" + this.priority + "\t\t\t\t" + "|" + this.name );
    }

    void markedAsDone(){
        this.isDone = true;
    }
}
