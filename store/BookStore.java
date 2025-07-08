package store;

import book.Book;
import java.util.*;
import java.time.Year;

public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
    }

    public List<Book> removeOutdatedBooks(int numberOfYears) {
        List<Book> removed = new ArrayList<Book>();
        List<String> toRemove = new ArrayList<String>();
        int thresholdYear = Year.now().getValue() - numberOfYears;

        for(Map.Entry<String, Book> entry : inventory.entrySet()) {
            if(entry.getValue().getPublishYear() < thresholdYear) {
                removed.add(entry.getValue());
                toRemove.add(entry.getKey());
            }
        }

        for(String ISBN : toRemove) {
            inventory.remove(ISBN);
        }
        return removed;

    }

    public double buyBook(String ISBN, int quantity, String email, String address) {
        Book book = inventory.get(ISBN);
        if(book == null) {
            throw new IllegalArgumentException("Book not available");
        }
        return book.buy(ISBN, quantity, email, address);
    }

    public void listInventory() {
        for (Book book : inventory.values()) {
            String title = book.getTitle();
            if (book instanceof book.PaperBook) {
                try {
                    java.lang.reflect.Field stockField = book.getClass().getDeclaredField("stock");
                    stockField.setAccessible(true);
                    int stock = stockField.getInt(book);
                    System.out.println(title + ", Stock: " + stock);
                } 
                catch (Exception e) {
                    System.out.println("Error");
                }
            } 
            else {
                System.out.println(title);
            }
        }
    }
}
