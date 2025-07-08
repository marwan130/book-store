package book;

import service.ShippingService;

public class PaperBook extends Book {
    private int stock;
    public PaperBook(String ISBN, String title, int publishYear, double price, int stock) {
        super(ISBN, title, publishYear, price);
        this.stock = stock;
    }

    @Override
    public double buy(String ISBN, int quantity, String email, String address) {
        if(quantity > stock) {
            throw new IllegalArgumentException("Out of stock");
        }
        stock -= quantity;
        ShippingService.shipPaperBook(address, getTitle(), quantity);
        return getPrice() * quantity;
    }
}
