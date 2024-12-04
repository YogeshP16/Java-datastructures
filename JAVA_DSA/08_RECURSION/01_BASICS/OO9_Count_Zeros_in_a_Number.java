

public class OO9_Count_Zeros_in_a_Number {
    public static void main(String[] args) {
        System.out.println(countzeros(3020100, 0));

        
    }
    static int countzeros(int n, int count){
        if(n==0) return count;
        int rem = n%10;
        if(rem ==0){
            return countzeros(n/10,  count+1);
        }
        return countzeros( n/10, count);
    }

}
