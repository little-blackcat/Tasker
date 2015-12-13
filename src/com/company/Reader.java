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
        System.out.println("Podaj priorytet taska (1-5): ");
        int prty = Integer.parseInt(br.readLine());
        System.out.println("Do ktorej kategorii chcesz dodac taska?");

        for (int i = 0; i < categories.size(); i++){
            System.out.println(i+1 + ". " + categories.get(i).name);
        }

        System.out.println("Podaj odpowiedni numer: ");
        int catNm = (Integer.parseInt(br.readLine()))-1;
        categories.get(catNm).addTaskToCategory(new Task(nm, prty));
    }

    void watchCategory(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("W ktorej kategorii chcesz przegladac taski?");

        for (int i = 0; i < categories.size(); i++){
            System.out.println(i+1 + ". " + categories.get(i).name);
        }

        System.out.println("Podaj odpowiedni numer: ");
        int catNm = (Integer.parseInt(br.readLine()))-1;
        categories.get(catNm).printTasks();
    }

    void addCategory(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe kategorii, ktora chcesz dodac: ");
        String nm = br.readLine();
        categories.add(new Category(nm));
    }
}

