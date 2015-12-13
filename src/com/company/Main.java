package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{

        ArrayList<Category> categoryList = new ArrayList();
        categoryList.add(new Category("Learning"));
        categoryList.add(new Category("Shopping"));
        categoryList.add(new Category("Meeting"));
        categoryList.add(new Category("Cleaning"));

        categoryList.get(0).addTaskToCategory(new Task("lalala", 6));
        categoryList.get(0).addTaskToCategory(new Task("Sieci", 3));
        categoryList.get(0).addTaskToCategory(new Task("JP", 1));
        categoryList.get(0).addTaskToCategory(new Task("Powiesic pranie, lol", 6));

        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reader r = new Reader();

        while (choice != 7){
            System.out.print("1. Dodaj zadanie\n2. Usun zadanie\n3. Przegladaj zadania w wybranej kategorii\n" +
                    "4. Pokaz wszystkie niedokonczone zadania\n5. Oznacz wybrane zadanie jako zrobione\n6. Przegladaj kategorie\n7. Zakoncz\n");
            System.out.println("Co chcesz zrobic? Wpisz odpowiedni numer: ");

            choice = Integer.parseInt(br.readLine());

            switch(choice){
                case 1:
                    r.readTask(categoryList);
                    break;
                case 2:
                    break;
                case 3:
                    r.watchCategory(categoryList);
                    break;
                case 4:
                    for (int i = 0; i < categoryList.size(); i++){
                        System.out.println("Kategoria " + categoryList.get(i).name + ": ");
                        categoryList.get(i).printIncompleteTasks();
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    }
}
