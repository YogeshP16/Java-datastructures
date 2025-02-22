public class OO5_Operators {

 

    public static void main(String[] args) {
        System.out.println("Arithmetic");
        int a = 10;
        int b = 20;

       
        boolean res  =  logical(a, b);
        System.out.println(res);
  

        
    }

    static boolean logical(int a, int b){
        if(a==b && a>b){
            return true;
        } else if (a>b || a==b){
            return true;
        }else if(a!=b){
            return true;
        }
        return false;
    }
    
}
