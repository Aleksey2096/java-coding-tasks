import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/*
	Сумма двух чисел
(Время: 1 сек. Память: 16 Мб Сложность: 46%)
Заданы три числа: a, b, c. Необходимо выяснить, можно ли так переставить цифры в числах a и b, чтобы в сумме получилось c.

Входные данные:
Входной файл INPUT.TXT содержит три целых числа: a, b, c (0 ≤ a, b, c < 10^9). Числа разделены пробелом.

Выходные данные:
В выходной файл OUTPUT.TXT следует вывести YES, если искомая перестановка цифр возможна,
в противном случае необходимо вывести NO. При положительном ответе во второй строке следует вывести число x,
получаемое перестановкой цифр числа a, и число y, получаемое перестановкой цифр числа b, сумма которых равна c.
Числа x и y при выводе не должны содержать ведущих нулей. Числа в строке разделены пробелом.
Если решений несколько, то следует вывести ту пару, в которой число x минимально.

Примеры:
№	INPUT.TXT	OUTPUT.TXT
1	12 31 25	YES
			12 13
2	12 31 26	NO
3	101 2 13	YES
			11 2
*/
public class Task_346 {
	private static final String INPUT_FILE = "INPUT.TXT";
	private static final String OUTPUT_FILE = "OUTPUT.TXT";

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
				BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
			String[] strNumsArr = reader.readLine().trim().split(" ");
			char[] aChars = String.valueOf(strNumsArr[0]).toCharArray();
			char[] bChars = String.valueOf(strNumsArr[1]).toCharArray();
			int c = Integer.parseInt(strNumsArr[2]);

			Arrays.sort(aChars);
			Arrays.sort(bChars);
			String bSortedStr = new String(bChars);

			boolean found = false;
			int num1 = 0;
			int num2 = 0;

			do {
				String aPermStr = new String(aChars);
				int aPerm = Integer.parseInt(aPermStr);
				if (aPerm > c) {
					break;
				}

				int numVal = c - aPerm;
				StringBuilder sb = new StringBuilder(String.valueOf(numVal));

				while (sb.length() < bSortedStr.length()) {
					sb.append('0');
				}
				char[] chars = sb.toString().toCharArray();
				Arrays.sort(chars);
				if (new String(chars).equals(bSortedStr)) {
					num1 = aPerm;
					num2 = numVal;
					found = true;
					break;
				}
			} while (nextPermutation(aChars));

			if (found) {
				writer.write("YES\n" + num1 + " " + num2);
			} else {
				writer.write("NO");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean nextPermutation(char[] arr) {
		int i = arr.length - 2;
		while (i >= 0 && arr[i] >= arr[i + 1]) {
			--i;
		}
		if (i < 0) {
			return false;
		}
		int j = arr.length - 1;
		while (arr[j] <= arr[i]) {
			--j;
		}

		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

		for (int left = i + 1, right = arr.length - 1; left < right; ++left, --right) {
			tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
		}
		return true;
	}
}
