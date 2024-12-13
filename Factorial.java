/*
 * How can you find the factorial of an integer in Java?
 */
public class Factorial {
	public static void main(String[] args) {
		System.out.println(calculateFactorialOf(7));
	}

	public static int calculateFactorialOf(int num) {
		if (num == 1) {
			return 1;
		}
		return num * calculateFactorialOf(num - 1);
	}
}
