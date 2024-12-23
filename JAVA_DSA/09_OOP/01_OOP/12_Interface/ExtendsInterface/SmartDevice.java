// child interface extending parent 
// here interface(smartdevice) extends interface(device)
// only interface to interface can extends 
public interface SmartDevice extends Device {  

    void ConnectToWifi(String network); // abstract method

    default void restart(){  // default method
        System.out.println("wifi restarting");
        PowerOFF();
        PowerON();
    }

}
