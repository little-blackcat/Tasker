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

        categoryList.get(0).addTaskToCategory(new Task("JP", 6));
        categoryList.get(0).addTaskToCategory(new Task("TS", 3));
        categoryList.get(0).addTaskToCategory(new Task("GK", 1));
        categoryList.get(0).addTaskToCategory(new Task("PEA", 6));

        categoryList.get(1).addTaskToCategory(new Task("Prezenty", 6));

        categoryList.get(2).addTaskToCategory(new Task("Kino - 18", 6));

        categoryList.get(3).addTaskToCategory(new Task("Wszystko", 6));

        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reader r = new Reader();

        while (choice != 8){
            System.out.println("Co chcesz zrobic? ");
            System.out.print("1. Dodaj zadanie\n2. Usun zadanie\n3. Przegladaj zadania w wybranej kategorii\n" +
                    "4. Pokaz wszystkie niedokonczone zadania\n5. Oznacz wybrane zadanie jako zrobione\n6. Dodaj kategorie\n7. Przegladaj kategorie\n8. Zakoncz\n");
            System.out.println("Wpisz odpowiedni numer: ");

            try{
                choice = Integer.parseInt(br.readLine());
            }catch (java.lang.NumberFormatException e){
                System.out.println("Numer taska powinien byc liczba widoczna przed taskiem!\nSprobuj jeszcze raz: ");
            }

            switch(choice){
                case 1:
                    r.readTask(categoryList);
                    break;
                case 2:
                    r.deleteChosenTask(categoryList);
                    break;
                case 3:
                    r.watchSorted(categoryList, r.watchCategory(categoryList));
                    break;
                case 4:
                    for (int i = 0; i < categoryList.size(); i++){
                        System.out.println("Kategoria " + categoryList.get(i).name + ": ");
                        categoryList.get(i).printIncompleteTasks();
                    }
                    break;
                case 5:
                   r.asDone(categoryList);
                    break;
                case 6:
                    r.addCategory(categoryList);
                    break;
                case 7:
                    System.out.println("Dostepne sa nastepujace kategorie: ");
                    for (int i = 0; i < categoryList.size(); i++){
                        System.out.println(i+1 + ". " + categoryList.get(i).name);
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
