
/*
 * Key concept: Count the frequency of each character in a given string by utilizing an array to map characters to their ASCII values.

Approach:
Initialize frequency array:

Create an array of size 256 (ASCII size) to store the frequency of characters.
Each index in the array corresponds to an ASCII value of a character.
Traverse the string:

Iterate through each character in the string.
For every character, convert it to its ASCII value using charAt(i) and increment the corresponding index in the frequency array.
Print characters and their frequency:

Traverse the frequency array (0–255).
For indices with values greater than 0, convert the index back to a character and print the character and its frequency.
Example:
Input: "heelloooo"

Step 1: Initialize freq[256] = {0}.

Step 2: Process each character:

h → freq[104]++ → freq[104] = 1
e → freq[101]++ → freq[101] = 2
l → freq[108]++ → freq[108] = 2
o → freq[111]++ → freq[111] = 4
Step 3: Traverse freq to print results:

Output: h:1, e:2, l:2, o:4
 */

public class O2_FindFrequencyCharacter {

    public static void main(String[] args) {
        String str = "heelloooo";
        int[] freq = new int[256]; //ASCII --> COVERS A-Z, a-z, 1-0.....

        for(int i =0; i< str.length(); i++){
            freq[str.charAt(i)]++;
        }

        for(int i=0; i<256; i++){
            if(freq[i]>0){

                System.out.println((char) i + ":" + freq[i]);

            }
        }

    }

}
