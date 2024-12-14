public class O02_SkipStrings {
    public static void main(String[] args) {
        String str = "baccappled";
        String target1 = "apple";
        System.out.println(skipString(str, target1));  // baccd
    
    }
        // SKIP STRINGS
        static String skipString(String str,  String target1){
            if(str.isEmpty()) return " ";
    
    
    
            if(str.startsWith(target1)){  // skip that string
                return skipString(str.substring(target1.length()), target1);

            }  else{  // add the string
                return str.charAt(0) + skipString(str.substring(1), target1);
            }
    
        }


}
