/*
 * Write a Java program to print a Fibonacci sequence using recursion.
 */
public class FibonacciPrinter {
    public static void main(String[] args) {
        printFibonacciSequence(20);
        System.out.println();

        int seqLength = 20;

        System.out.print("A Fibonacci sequence of " + seqLength + " numbers: ");

        for (int i = 0; i < seqLength; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static void printFibonacciSequence(int count) {
        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 1; i <= count; i++) {
            System.out.print(a + ", ");

            a = b;
            b = c;
            c = a + b;
        }
    }

    public static int fibonacci(int count) {
        if (count <= 1) {
            return count;
        }

        return fibonacci(count - 1) + fibonacci(count - 2);
    }
}
