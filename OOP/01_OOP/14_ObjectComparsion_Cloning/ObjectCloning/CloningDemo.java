import java.util.ArrayList;

public class CloningDemo {
    public static void main(String[] args) {
        ArrayList<Integer> orginallist = new ArrayList<>();
        orginallist.add(10);
        orginallist.add(20);

        // shallow copy --> create new ref to same arraylist
        // new ref pointing to same object itself
        ArrayList<Integer> shallow = orginallist;


        // Deep copy --> it create new arraylist with same values in orginal arraylist
        ArrayList<Integer> deep = new ArrayList<>(orginallist);

        System.out.println("Orginal list --> shallow, deep");
        System.out.println("orginal " + orginallist);
        System.out.println("shallow " + shallow);
        System.out.println("deep " + deep);

        // after modifying orginal list 
        // shallow copy will chanage
        // deep copy remains unchange
        orginallist.set(0, 50);

        // print after modify
        System.out.println("Orginal list after modification --> shallow, deep");
        System.out.println("orginal " + orginallist);
        System.out.println("shallow " + shallow);
        System.out.println("deep " + deep);



    }

}

/*
Orginal list --> shallow, deep
orginal [10, 20]
shallow [10, 20]
deep [10, 20]

Orginal list after modification --> shallow, deep
orginal [50, 20]
shallow [50, 20]
deep [10, 20]
 */