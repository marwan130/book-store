package service;

public class MailService {
    public static void sendEbook(String email, String title, int quantity) {
        System.out.println("Sending " + quantity + " copies of " + title + " to " + email);
    }
}