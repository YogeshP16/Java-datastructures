public interface SecurityUpdate {
    
    void downloadSecurityPatch(String PatchVersion);

    default void installSecurityPatch(String PatchVersion){
        System.out.println("Installing security patch version: " + PatchVersion );
    }


    
} 
