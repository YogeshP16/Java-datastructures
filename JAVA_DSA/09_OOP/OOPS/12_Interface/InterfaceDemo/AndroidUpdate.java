
public interface AndroidUpdate {

    void downloadUpdate(String UpdateOS);

    default void installUpdate(String UpdateOS){
        System.out.println("Installing OS: " + UpdateOS );

    }

}
