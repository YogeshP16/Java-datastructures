package paymentapp;

public class PayPal extends Payment {
    @Override
    void processPayment() {
        System.out.println("Processing paypal payment");
    }

}
