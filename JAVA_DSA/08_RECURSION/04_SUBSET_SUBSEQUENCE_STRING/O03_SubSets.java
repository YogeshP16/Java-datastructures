/*
when we dealing with permutations and combinations
susets --> non adjacent collections (taking any number of elements from it may or may not be adjacents)
example:
[1,2,3] --> [], [1], [1,2],[1,2,3], [2,3], [2], [3] ---> (adjacents)  [1,3] --> non adjacent
        ---> Order is mandatory

                        ""
                  /           \
                ""             "a"
              /    \         /     \
            ""      "b"    "a"      "ab"
           / \     /  \   /  \     /   \
         ""  "c" "b" "bc" "a" "ac" "ab" "abc"

Subsets do not maintain order (since they are derived from sets).
Subsequences do maintain order (because they are derived from sequences).
 */

import java.util.ArrayList;

public class O03_SubSets {
    public static void main(String[] args) {
        // Start the process of generating subsets with an empty prefix and the input string "abc".
        generateSubsets("", "abc");   // p --> processed  up --> unprocessed
        /*
        abc
        ab
        ac
        a
        bc
        b
        c
        " "  -> empty space
        */

        System.out.println(generateSubset("", "xyz"));  // [xyz, xy, xz, x, yz, y, z, ]


    }
    
    // Recursive function to generate all subsets of a given string.
    static void generateSubsets(String p, String up) {
        // Base case: if the remaining string is empty, print the current subset (prefix).
        if (up.isEmpty()) {
            System.out.println(p);  // Print the subset formed so far (p).
            return;
        }

        // Extract the first character of the remaining string.
        char ch = up.charAt(0);

        // Recursive call 1: include the current character in the subset and move to the next character.
        // left side 
        // first it calls left side of recursion tree
        generateSubsets(p + ch, up.substring(1));

        // Recursive call 2: exclude the current character from the subset and move to the next character.
        // right side of recursion tree
        generateSubsets(p, up.substring(1));  // substring  creating new objects

      
    }

    // return arraylist of subset
    static ArrayList<String> generateSubset(String p, String up){
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();   
            list.add(p); 
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = generateSubset(p + ch, up.substring(1));
        ArrayList<String> right = generateSubset(p,  up.substring(1));
       

        left.addAll(right);
        return left;
        
    }

}






