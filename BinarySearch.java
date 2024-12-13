/*
 * How do you implement a binary search in Java?
 */

public class BinarySearch {
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6 }, 3));
		System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 8));
	}

	public static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] > target) {
				high = mid - 1;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}
