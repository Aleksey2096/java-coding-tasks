import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task_193 {

	private static final String INPUT_FILE = "INPUT.TXT";
	private static final String OUTPUT_FILE = "OUTPUT.TXT";

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
				BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
			String[] configData = reader.readLine().trim().split(" ");
			int rowNum = Integer.parseInt(configData[0]);
			int colNum = Integer.parseInt(configData[1]);
			int rectangleNum = Integer.parseInt(configData[2]);

			int[] xMin = new int[rectangleNum + 1];
			int[] xMax = new int[rectangleNum + 1];
			int[] yMin = new int[rectangleNum + 1];
			int[] yMax = new int[rectangleNum + 1];

			boolean[] seenRectangles = new boolean[rectangleNum + 1];

			for (int i = 0; i <= rectangleNum; ++i) {
				xMin[i] = colNum;
				xMax[i] = -1;
				yMin[i] = rowNum;
				yMax[i] = -1;
			}

			for (int i = 0; i < rowNum; ++i) {
				String[] line = reader.readLine().trim().split(" ");
				for (int j = 0; j < colNum; ++j) {
					int value = Integer.parseInt(line[j]);

					if (value != 0) {
						xMin[value] = Math.min(xMin[value], j);
						xMax[value] = Math.max(xMax[value], j);
						yMin[value] = Math.min(yMin[value], rowNum - i - 1);
						yMax[value] = Math.max(yMax[value], rowNum - i - 1);

						seenRectangles[value] = true;

						xMin[0] = Math.min(xMin[0], j);
						xMax[0] = Math.max(xMax[0], j);
						yMin[0] = Math.min(yMin[0], rowNum - i - 1);
						yMax[0] = Math.max(yMax[0], rowNum - i - 1);
					}
				}
			}

			for (int i = 1; i <= rectangleNum; ++i) {
				if (seenRectangles[i]) {
					writer.write(xMin[i] + " " + yMin[i] + " " + (xMax[i] + 1) + " " + (yMax[i] + 1));
				} else {
					writer.write(xMin[0] + " " + yMin[0] + " " + (xMax[0] + 1) + " " + (yMax[0] + 1));
				}
				writer.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
