interface Addable{
    int addition(int a, int b);

}

/*
class AddableImpl implements Addable{
    public int addition(int a, int b){
        return (a+b);
    }

}
 */


public class LambdaParameter {
    public static void main(String[] args) {

        Addable addition = (a,b) ->  (a+b);
        int res = addition.addition(10, 20);
        System.out.println(res); // 30
        
    }

}
