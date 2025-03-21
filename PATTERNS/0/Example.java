class staticDemo{
    static int count;

    void inc(){
        count++;
    }

}



public class Example {
    public static void main(String[] args) {
        staticDemo obj1 = new staticDemo();
        staticDemo obj2 = new staticDemo();

        obj1.inc();
        obj2.inc();
        System.out.println(staticDemo.count);  // count objects 
        
    }

}
