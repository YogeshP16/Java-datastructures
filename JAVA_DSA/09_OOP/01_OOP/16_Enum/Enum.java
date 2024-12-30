
enum Day{
    Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday
}

public class Enum {
    
        // Enums are used for fixed sets of constants
        // you cannot modify it
        // it implicitly final
    
        public static void main(String[] args) {
            Day today = Day.Tuesday;
    
            if(today == Day.Tuesday){
            System.out.println("day 2");  // day 2
        }

        for(Day d : Day.values()){
            System.out.println(d);
        }
        
    }

}
