// PaymentMethod interface
interface PaymentMethod {
    void processPayment();
}

// CreditCard class implementing PaymentMethod
class CreditCard implements PaymentMethod {
    public void processPayment() {
        System.out.println("Payment credited - CreditCard");
    }
}

// PayPal class implementing PaymentMethod
class PayPal implements PaymentMethod {
    public void processPayment() {
        System.out.println("Payment credited - PayPal");
    }
}

// New payment method - BankTransfer
class BankTransfer implements PaymentMethod {
    public void processPayment() {
        System.out.println("Payment credited - BankTransfer");
    }
}

// Payment class that uses polymorphism
public class Payment {
    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.processPayment();
    }
    public static void main(String[] args) {
        Payment obj = new Payment();
        
        // Using different payment methods without modifying the Payment class
        obj.processPayment(new CreditCard());
        obj.processPayment(new PayPal());
        obj.processPayment(new BankTransfer());
    }
}
/*
Payment credited - CreditCard
Payment credited - PayPal
Payment credited - BankTransfer
 */