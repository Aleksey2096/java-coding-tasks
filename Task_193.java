import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
	Поиск прямоугольников
(Время: 0,5 сек. Память: 16 Мб Сложность: 34%)
На поле N×M клеток (N строк и M столбцов) положили K прямоугольников один поверх другого в случайном порядке.
Длины сторон прямоугольников выражаются целым числом клеток. Прямоугольники не выходят за границы поля.
Границы прямоугольников совпадают с границами клеток поля.

Получившуюся ситуацию записали в таблицу чисел (каждой клетке поля соответствует клетка таблицы).
Если клетка поля не закрыта прямоугольником, то в соответствующую клетку таблицы записали число 0.
Если же клетка закрыта одним или несколькими прямоугольниками, то в соответствующую клетку таблицы
записали число, соответствующее номеру самого верхнего прямоугольника, закрывающего эту клетку.

Требуется написать программу, которая определит положение и размеры прямоугольников. Гарантируется,
что во входных данных содержится информация, которой достаточно для однозначного определения размеров прямоугольников.

Входные данные
Входной файл INPUT.TXT содержит в первой строке целые числа N, M, K (1 ≤ N ≤ 200, 1 ≤ M ≤ 200, 1 ≤ K ≤ 255).
Далее следует N строк по M чисел в каждой — содержимое таблицы. 
Все числа в таблице целые, находятся в диапазоне от 0 до K включительно.

Выходные данные
Поиск прямоугольниковВыходной файл OUTPUT.TXT должен содержать K строк. Каждая строка должна описывать
соответствующий ее номеру прямоугольник четырьмя числами X1 Y1 X2 Y2 (X1 и Y1 должны описывать
координаты левого нижнего угла прямоугольника, а X2 и Y2 — координаты правого верхнего угла). Числа должны разделяться пробелом.

Начало координат расположено в левом нижнем углу таблицы.
Таким образом, координаты левого нижнего угла поля — (0,0), правого верхнего — (M,N).

Пример
№	INPUT.TXT	OUTPUT.TXT
1	4 5 2		0 0 2 2
	0 2 2 2 2	1 1 5 4
	0 2 2 2 2
	1 1 2 2 2
	1 1 0 0 0
*/
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
