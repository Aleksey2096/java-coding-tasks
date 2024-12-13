
/*
 * How do you check if a list of integers contains only odd numbers in Java?
 */
import java.util.List;

public class OddNumbersValidator {
    public static void main(String[] args) {
        System.out.println(isOddNumbersList(List.of(1, 2, 3, 4, 5)));
        System.out.println(isOddNumbersList(List.of(1, 3, 5)));
    }

    public static boolean isOddNumbersList(List<Integer> list) {
        // 1
        // for (int i : list) {
        // if (i % 2 == 0)
        // return false;
        // }
        // return true;

        // 2
        return !list.stream().anyMatch(num -> num % 2 == 0);
    }
}
