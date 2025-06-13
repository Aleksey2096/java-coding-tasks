import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
	A / B
(Время: 1 сек. Память: 16 Мб Сложность: 43%)
Требуется получить точное значение частного А/В для двух натуральных чисел A и B.

Входные данные:
В единственной строке входного файла INPUT.TXT записано частное двух натуральных чисел,
не превышающих 1000. Числа разделены символом «/» без лишних пробелов.

Выходные данные:
В выходной файл OUTPUT.TXT нужно вывести точное значение A/B без лишних точек, нулей и пробелов.
В случае присутствия бесконечной записи числа следует вывести период в скобках.

Например, неправильно выведены числа: 08.92, 3.20, 120.6(6), 0.(33), 5.(0), 2. , .3, 0.33(03). 
Их следует выводить как 8.92, 3.2, 120.(6), 0.(3), 5, 2, 0.3, 0.3(30) .

Примеры:
№	INPUT.TXT	OUTPUT.TXT
1	10/7		1.(428571)
2	1/3		0.(3)
3	100/25		4
 */
public class Task_109 {
	private static final String INPUT_FILE = "INPUT.TXT";
	private static final String OUTPUT_FILE = "OUTPUT.TXT";

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
				BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
			String numberStr = reader.readLine().trim();
			String[] numParts = numberStr.split("/");
			int a = Integer.parseInt(numParts[0]);
			int b = Integer.parseInt(numParts[1]);
			StringBuilder dividedNum = new StringBuilder();

			int integerPart = a / b;
			dividedNum.append(integerPart);

			int remainder = a % b;
			if (remainder != 0) {
				dividedNum.append(".");
				Map<Integer, Integer> remainderPositions = new HashMap<>();
				StringBuilder fraction = new StringBuilder();
				int position = 0;
				boolean repeating = false;
				int repeatStart = 0;

				while (remainder != 0) {
					if (remainderPositions.containsKey(remainder)) {
						repeating = true;
						repeatStart = remainderPositions.get(remainder);
						break;
					}

					remainderPositions.put(remainder, position++);
					remainder *= 10;
					fraction.append(remainder / b);
					remainder %= b;
				}

				if (repeating) {
					dividedNum
							.append(fraction.substring(0, repeatStart))
							.append("(")
							.append(fraction.substring(repeatStart))
							.append(")");
				} else {
					dividedNum.append(fraction);
				}
			}

			String resultStr = dividedNum.toString();
			if (resultStr.contains(".")) {
				if (resultStr.matches("\\d+\\.0+")) {
					resultStr = resultStr.substring(0, resultStr.indexOf('.'));
				} else if (resultStr.endsWith(".(0)")) {
					resultStr = resultStr.substring(0, resultStr.indexOf('.'));
				}
			}

			writer.write(resultStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
