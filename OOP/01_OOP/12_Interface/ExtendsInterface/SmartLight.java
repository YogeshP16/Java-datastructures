public class SmartLight implements SmartDevice {


    // device interface --> abstract method implementation
    public void PowerON(){
        System.out.println("Light ON");
    }

    public void PowerOFF(){
        System.out.println("light OFF");
    }

    // smartdevide interface -->abstract method implementation details
    @Override
    public void ConnectToWifi(String network) {
       
        System.out.println("ConnectTo " + network);
    }

}
