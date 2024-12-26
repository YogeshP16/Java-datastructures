

import java.util.HashSet;

public class OO2_SET {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        // add
        set.add(12);
        set.add(34);
        set.add(35);
        set.add(34);
        set.add(36); 
        set.add(37);
        set.add(39);
        set.add(44); 

        set1.add(56);
        set1.add(34);
        set1.add(67);
        set1.add(44);

                                  //  it print 34 one time only cuz it doesnt allow duplicates
        System.out.println(set);  // [34, 35, 36, 37, 39, 12, 44] 

        // traverse
        for(int item : set){
            System.out.print(item + " ");   // 34 35 36 37 39 12 44
        }

        // remove element directly
        set.remove(44);
        System.out.println(set); // [34, 35, 36, 37, 39, 12] --> unordered
        
        // contains
        System.out.println(set.contains(34)); // true
        
        // size
        System.out.println(set.size());  // 6

        //is empty
        System.out.println(set.isEmpty());  // false


        // UNION ---> USE addall() 
        HashSet <Integer> union = new HashSet<>(set);
        union.addAll(set1);
        System.out.println(union);     // [34, 35, 67, 36, 37, 39, 56, 12, 44]

        // INTERSECTION --> USE --> retainAll()

        HashSet <Integer> intersection = new HashSet<>(set);
        intersection.retainAll(set1);
        System.out.println(intersection);  // [34]



    }

}
