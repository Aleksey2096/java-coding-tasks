/*
 * How do you swap two numbers without using a third variable in Java?
 */
public class NumberSwapper {
    public static void main(String[] args) {
        int a = 10;
        int b = 13;

        a += b;
        b = a - b;
        a -= b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
