import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> checkEvenOrNot = x  -> x % 2 == 0;
        System.out.println(checkEvenOrNot.test(45));  // false
    }

}
