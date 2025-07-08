package main;

import book.*;
import store.BookStore;

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        PaperBook paperBook = new PaperBook("111", "Java paper book", 2020, 30.0, 5);
        Ebook ebook = new Ebook("222", "Java ebook", 2021, 15.0);
        DemoBook demoBook = new DemoBook("333", "Java demo", 2023);
        PaperBook paperBook2 = new PaperBook("444", "Java paper book 2", 2015, 35.0, 6);

        store.addBook(paperBook);
        store.addBook(ebook);
        store.addBook(demoBook);
        store.addBook(paperBook2);

        System.out.println(" Inventory after adding books");
        store.listInventory();

        System.out.println("\n Removing old books");
        store.removeOutdatedBooks(8);
        store.listInventory();

        System.out.println("\n Buying paper book");
        try {
            double paid = store.buyBook("111", 2, "marwan@gmail.com", "Alex");
            System.out.println("Paid: " + paid);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n Buying ebook");
        try {
            double paid = store.buyBook("222", 1, "marwan@gmail.com", "");
            System.out.println("Paid: " + paid);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n Trying to buy a demo book");
        try {
            store.buyBook("333", 1, "marwan@gmail.com", "");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n Trying to buy more books than in stock");
        try {
            store.buyBook("111", 10, "marwan@gmail.com", "Alex");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n Trying to buy unavailable books");
        try {
            store.buyBook("777", 10, "marwan@gmail.com", "Alex");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n Updated Inventory");
        store.listInventory();
    }
} 