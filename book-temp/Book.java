package book;

public class Book {
    private String ISBN;
    private String title;
    private int publishYear;
    private double price;

    public Book(String ISBN, String title, int publishYear, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double buy(String ISBN, int quantity, String email, String address) {
        throw new UnsupportedOperationException("Buying is not supported for this book type");
    }
}