package service;

public class ShippingService {
    public static void shipPaperBook(String address, String title, int quantity) {
        System.out.println("Shipping " + quantity + " copies of " + title + " to " + address);
    }
}