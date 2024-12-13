/*
 * Write a Java program to check if the given number is a prime number.
 */
public class PrimeNumberValidator {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(2));
        System.out.println(isPrimeNumber(3));
        System.out.println(isPrimeNumber(5));
        System.out.println(isPrimeNumber(7));
        System.out.println(isPrimeNumber(11));
        System.out.println(isPrimeNumber(13));
        System.out.println(isPrimeNumber(17));
        System.out.println(isPrimeNumber(19));
        System.out.println(isPrimeNumber(23));
        System.out.println(isPrimeNumber(29));
        System.out.println(isPrimeNumber(31));
        System.out.println(isPrimeNumber(37));
        System.out.println(isPrimeNumber(41));
        System.out.println(isPrimeNumber(43));
        System.out.println(isPrimeNumber(47));
        System.out.println(isPrimeNumber(53));
        System.out.println(isPrimeNumber(59));
        System.out.println(isPrimeNumber(61));
        System.out.println(isPrimeNumber(67));
        System.out.println(isPrimeNumber(71));
        System.out.println(isPrimeNumber(73));
        System.out.println(isPrimeNumber(79));
        System.out.println(isPrimeNumber(83));
        System.out.println(isPrimeNumber(89));
        System.out.println(isPrimeNumber(97));

    }

    public static boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
