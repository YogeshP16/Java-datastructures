

public class CreditCard extends Payment{
    @Override
    void processPayment() {
        System.out.println("Processing credit payment");
    }

}
