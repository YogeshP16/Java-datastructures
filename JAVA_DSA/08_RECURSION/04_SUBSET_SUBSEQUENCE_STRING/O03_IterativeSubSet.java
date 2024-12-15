import java.util.ArrayList;

public class O03_IterativeSubSet {
    public static void main(String[] args) {
        System.out.println(subset("xyz")); 
        
    }
    static ArrayList<String> subset(String s){
        ArrayList<String> res = new ArrayList<>();
        res.add(" ");  // create empty subset
        
        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            int n = res.size();
            // For each existing subset, add the current character to create new subsets
            for(int j=0; j<n; j++){
                String current =    res.get(j);
                res.add(current + ch); // Add the current character to the subset
            }

        }
        return res;
    }

}


/*
Example Walkthrough (for "xyz"):
Initialization:

result = [""] (Start with the empty subset).
First Iteration (ch = 'x'):

We add 'x' to each subset in result:
Add 'x' to "", resulting in ["", "x"].
Second Iteration (ch = 'y'):

We add 'y' to each subset in result:
Add 'y' to "", resulting in ["", "x", "y"].
Add 'y' to "x", resulting in ["", "x", "y", "xy"].
Third Iteration (ch = 'z'):

We add 'z' to each subset in result:
Add 'z' to "", resulting in ["", "x", "y", "xy", "z"].
Add 'z' to "x", resulting in ["", "x", "y", "xy", "z", "xz"].
Add 'z' to "y", resulting in ["", "x", "y", "xy", "z", "xz", "yz"].
Add 'z' to "xy", resulting in ["", "x", "y", "xy", "z", "xz", "yz", "xyz"].
 */