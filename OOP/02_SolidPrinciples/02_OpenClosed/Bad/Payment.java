public class Payment {
    public void processPayment(String paymentType) {
        if(paymentType == "CreditCard"){
            System.out.println("Payment credited - CreditCard");
        } else if (paymentType == "PayPal"){
            System.out.println("Payment credited - PayPal");
        }
    }

    public static void main(String[] args) {
        Payment obj = new Payment();
        obj.processPayment("CreditCard");
    }
}


// openClosed - open for extension but closed for modification
// it requires modifying the Payment class every time a new payment method is added
// In good example we refactor
