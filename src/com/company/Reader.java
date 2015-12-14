package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Paula on 12.12.2015.
 */
public class Reader {
    void readTask(ArrayList<Category> categories) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe taska: ");
        String nm = br.readLine();
        int prty = 0;
        System.out.println("Podaj priorytet taska (priorytet moze byc dowolna liczba): ");

        while(true) {
            try {
                prty = Integer.parseInt(br.readLine());
                break;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Priorytet powinien byc liczba!\nSprobuj jeszcze raz: ");
                continue;
            }
        }

        System.out.println("Do ktorej kategorii chcesz dodac taska?");

        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + 1 + ". " + categories.get(i).name);
        }

        System.out.println("Wpisz nazwe wybranej kategorii: ");
        String catNm = br.readLine();
        int cnt = 0;

        for (Category category : categories){
            if (category.name.equals(catNm)){
                category.addTaskToCategory(new Task(nm, prty));
                System.out.println("Task zostal dodany do kategorii o nazwie: " + catNm);
                cnt += 1;
            }
        }

        if (cnt == 0){
            System.out.println("Wpisanej kategorii nie ma na liscie,\nczy chcesz dodac taka kategorie i do niej dodac task? y/n");
            char choice = br.readLine().charAt(0);
            if (choice == 'y'){
                categories.add(new Category(catNm));
                categories.get(categories.size()-1).addTaskToCategory(new Task(nm, prty));
                System.out.println("Task zostal dodany do nowej kategorii o nazwie: " + catNm);
            }
        }
    }

    void deleteChosenTask(ArrayList<Category> categories) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int catID = watchCategory(categories);
        System.out.println("Ktory task chcesz usunac?");
        int taskID = (Integer.parseInt(br.readLine()))-1;
        categories.get(catID).removeTaskFromCategory(taskID);
        System.out.println("Task zostal usuniety");
    }

    int watchCategory(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("W ktorej kategorii chcesz przegladac taski?");

        for (int i = 0; i < categories.size(); i++){
            System.out.println(i+1 + ". " + categories.get(i).name);
        }

        System.out.println("Podaj odpowiedni numer: ");
        int catNm = (Integer.parseInt(br.readLine()))-1;
        categories.get(catNm).printTasks();
        return catNm;
    }

    void watchSorted(ArrayList<Category> categories, int catID) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Czy chcesz przesortowac zadania po priorytetach? y/n");
        char choice = br.readLine().charAt(0);
        if (choice == 'y'){
            //categories.get(catID).tasks.sort();
        }

    }

    void addCategory(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe kategorii, ktora chcesz dodac: ");
        String nm = br.readLine();
        categories.add(new Category(nm));
    }

    void asDone(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int catID = watchCategory(categories);
        System.out.println("Ktory task chcesz oznaczyc jako zrobiony?");
        int taskID = (Integer.parseInt(br.readLine()))-1;
        categories.get(catID).tasks.get(taskID).markedAsDone();
        System.out.println("Task o nazwie: " + categories.get(catID).tasks.get(taskID).name + " zostal oznaczony jako zrobiony");
    }
}

