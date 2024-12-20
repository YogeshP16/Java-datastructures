public class MainFunn {

    public static void main(String[] args) {
        SmartPhone smartphone = new SmartPhone();

        // Download and install both updates
        smartphone.downloadUpdate("15.0");  // Downloading Android update version 15.0
        smartphone.downloadSecurityPatch("1.5"); // Downloading security patch version 1.5

        // Install updates using default methods
        smartphone.installUpdate("15.0"); // Installing OS: 15.0
        smartphone.installSecurityPatch("1.5");  // Installing security patch version: 1.5
        
    }
}
