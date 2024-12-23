public class Mainfunction {
    public static void main(String[] args) {
        SmartLight obj = new SmartLight();
        obj.PowerON();
        obj.ConnectToWifi("Home wifi");
        obj.restart();
        obj.PowerOFF();
        
    }

}

/* output
Light ON
ConnectTo Home wifi
wifi restarting
light OFF
Light ON    -----> this output related to Device interface
light OFF   -----> related to device interface
 */