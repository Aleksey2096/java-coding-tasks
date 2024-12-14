import java.util.Arrays;

/*
 * Write a Java program that illustrates merge sort.
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 8, 5, 9, 6, 1, 8, 3, 2, 7, 4 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (arr.length < 2) {
			return;
		}
		int mid = (low + high) / 2;
		int[] arr1 = new int[mid - low + 1];
		for (int i = 0; i < arr1.length; ++i) {
			arr1[i] = arr[i + low];
		}
		int[] arr2 = new int[high - mid];
		for (int i = 0; i < arr2.length; ++i) {
			arr2[i] = arr[i + mid + 1];
		}

		mergeSort(arr1, 0, arr1.length - 1);
		mergeSort(arr2, 0, arr2.length - 1);

		merge(arr, arr1, arr2, low, high);
	}

	private static void merge(int[] arr, int[] arr1, int[] arr2, int low, int high) {
		int arr1Pointer = 0;
		int arr2Pointer = 0;

		for (int i = low; i <= high; ++i) {
			if (arr1Pointer < arr1.length &&
					(arr2Pointer >= arr2.length || arr1[arr1Pointer] <= arr2[arr2Pointer])) {
				arr[i] = arr1[arr1Pointer];
				++arr1Pointer;
			} else {
				arr[i] = arr2[arr2Pointer];
				++arr2Pointer;
			}
		}
	}
}
