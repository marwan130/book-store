package book;

public class DemoBook extends Book {
    public DemoBook(String ISBN, String title, int publishYear) {
        super(ISBN, title, publishYear, 0.0);
    }

    @Override
    public double buy(String ISBN, int quantity, String email, String address) {
        throw new UnsupportedOperationException("Demo books are not for sale");
    }
}
