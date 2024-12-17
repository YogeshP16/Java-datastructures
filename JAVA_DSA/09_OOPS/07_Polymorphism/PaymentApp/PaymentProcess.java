package PaymentApp;


public class PaymentProcess {

    // Define the process method here, outside of the main method
    public void process(Payment payment) {
        payment.processPayment();  // This will call the overridden method based on the actual object type
    }

    public static void main(String[] args) {
        PaymentProcess processor = new PaymentProcess();
        Payment payment1 = new CreditCard();  // upcasting --> method override
        Payment payment2 = new PayPal();

        processor.process(payment1);  // Output: Processing credit card payment
        processor.process(payment2);  // Output: Processing PayPal payment
    }
}