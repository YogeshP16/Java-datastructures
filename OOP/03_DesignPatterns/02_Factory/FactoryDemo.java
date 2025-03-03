/*
Factory Design Pattern, instead of creating objects of multiple classes directly, 
you create a single factory class that handles the object creation for all the classes that implement a common interface. 
This simplifies the client code and centralizes object creation logic.

Key Points:
Multiple Classes (Concrete Products): You have multiple classes that implement the same interface, 
each providing its own specific behavior.

Factory Class: A single factory class is responsible for creating instances 
of the different classes based on the input or condition.

Client Code: The client uses the factory to get the object and interact with it, 
without worrying about how the object is created or which specific class is being used.
*/


interface Notification {
    void notifyUser();

}

class EmailNotify  implements Notification{
    public void notifyUser(){
            System.out.println("Sending email notification");
        }
}

class SMSNotify  implements Notification{
    public void notifyUser(){
        System.out.println("Sending sms notification");
    }
}

class OTPNotify  implements Notification{
    public void notifyUser(){
        System.out.println("Sending otp notification");
    }
}
    
    
    // factory design pattern
    // handles the object creation logic. Based on the input type, it returns the appropriate Notification object.
/**
 * Factory class to create instances of different types of notifications.
 */
class NotificationFactory{
    public static Notification getNotification(String type){
        return switch (type.toUpperCase()) {
            case "EMAIL" -> new EmailNotify();
            case "SMS" -> new SMSNotify();
            case "OTP" -> new OTPNotify();
            default -> null;

        };
    }
}
    
    
public class FactoryDemo {
    public static void main(String[] args) {
        Notification obj = NotificationFactory.getNotification("EMAIL");  //Sending email notification
        obj.notifyUser();
    
}

}
