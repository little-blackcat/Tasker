package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Paula on 12.12.2015.
 */
public class Reader {

    // metoda odpowiadajaca za pobranie od uzytkownika nazwy oraz priorytetu
    // nowego taska i utworzenie go
    void readTask(ArrayList<Category> categories) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe taska: ");
        String nm = br.readLine();
        int prty;
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

        printCategories(categories);

        System.out.println("Do ktorej kategorii chcesz dodac taska?\nWpisz nazwe wybranej kategorii: ");

        String catNm = br.readLine();

        int cnt = 0;

        // sprawdzenie, czy istnieje podana przez uzytkownika kategoria
        for (Category category : categories){
            if (category.name.equals(catNm)){
                category.addTaskToCategory(new Task(nm, prty));
                System.out.println("Task zostal dodany do kategorii o nazwie: " + catNm);
                cnt += 1;
                System.out.println();
            }
        }

        // jezeli nie - stworzenie podanej kategorii i zapisanie do niej taska
        if (cnt == 0){
            System.out.println("Wpisanej kategorii nie ma na liscie,\nczy chcesz dodac taka kategorie i do niej dodac task? y/n");
            char choice = br.readLine().charAt(0);
            if (choice == 'y'){
                categories.add(new Category(catNm));
                categories.get(categories.size()-1).addTaskToCategory(new Task(nm, prty));
                System.out.println("Task zostal dodany do nowej kategorii o nazwie: " + catNm);
                System.out.println();
            }
        }
    }


    // metoda odpowiadajaca za pobranie od uzytkownika indeksu taska, ktory chce usunac
    // i usuniecie go
    void deleteChosenTask(ArrayList<Category> categories) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int catID = watchCategory(categories);

        System.out.println("Ktory task chcesz usunac?");
        int taskID;

        while(true) {
            try {
                taskID = (Integer.parseInt(br.readLine()))-1;
                categories.get(catID).removeTaskFromCategory(taskID);
                break;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Numer taska powinien byc liczba widoczna przed taskiem!\nSprobuj jeszcze raz: ");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma taska o takim numerze!\nSprobuj jeszcze raz: ");
                continue;
            }
        }

        System.out.println("Task zostal usuniety");
        System.out.println();
    }

    //metoda odpowiedzialna za przegladanie taskow w wybranej kategorii
    int watchCategory(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        printCategories(categories);

        System.out.println("W ktorej kategorii chcesz przegladac taski?");
        int catNm;
        System.out.println("Podaj odpowiedni numer: ");

        while(true)
        {
            try {
                catNm = (Integer.parseInt(br.readLine())) - 1;
                categories.get(catNm).printTasks();
                break;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Numer kategorii powinien byc liczba widoczna przed kategoria!\nSprobuj jeszcze raz: ");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma kategorii o takim numerze!\nSprobuj jeszcze raz: ");
                continue;
            }
        }
        System.out.println();

        return catNm;
    }

    //metoda odpowiedzialna za wypisanie dostepnych kategorii
    void printCategories(ArrayList<Category> categories){
        System.out.println("Dostepne sa nastepujace kategorie: ");
        for (int i = 0; i < categories.size(); i++){
            System.out.println(i+1 + ". " + categories.get(i).name);
        }
        System.out.println();
    }

    //metoda odpowiedzialna za dodawanie kategorii
    void addCategory(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe kategorii, ktora chcesz dodac: ");
        String nm = br.readLine();
        categories.add(new Category(nm));
        System.out.println("Kategoria " + nm + " zostala dodana");
        System.out.println();
    }

    //metoda odpowiedzialna za oznaczanie wybranego taska jako zrobiony
    void asDone(ArrayList<Category> categories) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int catID = watchCategory(categories);
        System.out.println("Ktory task chcesz oznaczyc jako zrobiony?");
        int taskID;

        while(true) {
            try {
                taskID = (Integer.parseInt(br.readLine())) - 1;
                categories.get(catID).tasks.get(taskID).markedAsDone();
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma taska o takim numerze!\nSprobuj jeszcze raz: ");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Numer taska powinien byc liczba widoczna przed taskiem!\nSprobuj jeszcze raz: ");
                continue;
            }
        }

        System.out.println("Task o nazwie: " + categories.get(catID).tasks.get(taskID).name + " zostal oznaczony jako zrobiony");
        System.out.println();
    }

    //wypisuje niedokonczone taski ze wszystkich kategorii
    void printAllInclompleted(ArrayList<Category> categories) throws IOException{
        for (int i = 0; i < categories.size(); i++)
        {
            System.out.println("Kategoria " + categories.get(i).name + ": ");
            categories.get(i).printIncompleteTasks();
        }
        System.out.println();
    }
}

