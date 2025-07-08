package Book;

public class DemoBook extends Book {
    public DemoBook(String ISBN, String title, int publishYear, double price) {
        super(ISBN, title, publishYear, price);
    }

    @Override
    public double buy(String ISBN, int quantity, String email, String address) {
        throw new UnsupportedOperationException("Demo books are not for sale");
    }
}
