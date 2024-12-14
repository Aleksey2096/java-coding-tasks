import java.util.Arrays;
import java.util.Random;

/*
 * How do you shuffle an array in Java?
 */
public class ArrayShuffle {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };

		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}

		System.out.println(Arrays.toString(array));
	}
}
