import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
	Минимальное число
(Время: 1 сек. Память: 16 Мб Сложность: 35%)
Требуется написать программу, которая из цифр двух натуральных чисел создает
наименьшее возможное число, сохраняя при этом порядок следования цифр в этих числах.

Входные данные:
Входной файл INPUT.TXT содержит два натуральных числа, записанных в двух строках. Числа больше нуля и меньше 10^255.

Выходные данные:
В единственную строку выходного файла OUTPUT.TXT нужно вывести наименьшее возможное число, удовлетворяющее условию задачи.

Пример:
№	INPUT.TXT	OUTPUT.TXT
1	125		12345
	34
*/
public class Task_548 {

	private static final String INPUT_FILE = "INPUT.TXT";
	private static final String OUTPUT_FILE = "OUTPUT.TXT";

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
				BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
			String num1Str = reader.readLine().trim();
			String num2Str = reader.readLine().trim();

			String minNumStr = createMinimalNumberString(num1Str, num2Str);

			writer.write(minNumStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String createMinimalNumberString(String num1Str, String num2Str) {
		int i = 0;
		int j = 0;
		StringBuilder outputNum = new StringBuilder();

		while (i < num1Str.length() || j < num2Str.length()) {
			if (isFirstStringSmaller(num1Str, i, num2Str, j)) {
				outputNum.append(num1Str.charAt(i++));
			} else {
				outputNum.append(num2Str.charAt(j++));
			}
		}

		outputNum.append(num1Str.substring(i));
		outputNum.append(num2Str.substring(j));

		return outputNum.toString();
	}

	private static boolean isFirstStringSmaller(String num1Str, int index1, String num2Str, int index2) {
		if (index1 == num1Str.length()) {
			return false;
		}
		if (index2 == num2Str.length()) {
			return true;
		}

		char char1 = num1Str.charAt(index1);
		char char2 = num2Str.charAt(index2);

		if (char1 == char2) {
			return isFirstStringSmaller(num1Str, ++index1, num2Str, ++index2);
		}
		return char1 < char2;
	}
}
