
// Acheiving Multiple Inheritance via Interfaces
//  Multiple Inheritance --> child class inherits from two or more parent classes.
// here, child class (smartphone) inherits two parent interfaces (AndroidUpdate, SecurityUpdate)
public class SmartPhone implements AndroidUpdate, SecurityUpdate {  


    // here, the abstract method inplementaions for AndroidUpdate, SecurityUpdate
    @Override
    public void downloadUpdate(String updateOS) {
        System.out.println("Downloading Android update version " + updateOS);
    }

    @Override
    public void downloadSecurityPatch(String patchVersion) {
        System.out.println("Downloading security patch version " + patchVersion);
    }

}
