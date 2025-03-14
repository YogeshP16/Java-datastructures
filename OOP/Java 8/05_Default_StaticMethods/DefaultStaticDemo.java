interface CarBrands{
    // abstract method
    void speed();
    void price();

    // Default keyword
    default void type(){
       System.out.println("Petrol");

    }


    // Static methods
    static String getModel(){
        return "BMW - 7 series";
    }

}

class BMW implements CarBrands{
    @Override
    public void speed(){
        System.out.println("210 kmph");
    }
    @Override
    public void price(){
        System.out.println(2000000);
    }

}



public class DefaultStaticDemo {
    public static void main(String[] args) {
        CarBrands car = new BMW();
        car.price();
        car.speed();
        car.type();


        // here we calling static metho with interface name
        System.out.println(CarBrands.getModel());
        
    }

}


/*
2000000
210 kmph
Petrol

BMW - 7 series
 */