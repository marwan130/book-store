package book;

import service.MailService;

public class Ebook extends Book {
    public Ebook(String ISBN, String title, int publishYear, double price) {
        super(ISBN, title, publishYear, price);
    }

    @Override
    public double buy(String ISBN, int quantity, String email, String address) {
        MailService.sendEbook(email, getTitle(), quantity);
        return getPrice() * quantity;
    }
}
