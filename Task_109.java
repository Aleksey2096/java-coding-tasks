import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
