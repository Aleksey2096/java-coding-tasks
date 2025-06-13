import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
	Сближение с целью
(Время: 1 сек. Память: 16 Мб Сложность: 37%)
Вы являетесь одним из разработчиков программного обеспечения боевой информационной системы для
ракетного крейсера нового поколения РК-2000. Один из компонентов этой системы отвечает за решение
задач тактического маневрирования. В настоящее время вы занимаетесь решением задачи о сближении с целью.

Заданы координаты x0 и y0 цели в начальный момент времени, а также вектор (Vx; Vy) ее скорости.
Считается, что цель движется равномерно и прямолинейно. В начальный момент времени
РК-2000 находится в начале координат. Его максимальная скорость равна V.

Необходимо выяснить, может ли РК-2000 через заданное время t оказаться ровно на заданном расстоянии d от цели.
Для простоты считайте, что РК-2000 может мгновенно изменять свою скорость.

Входные данные:
Первая строка входного файла INPUT.TXT содержит два целых числа x0 и y0 (|x0| ≤ 109, |y0| ≤ 109).
Вторая строка входного файла содержит два целых числа Vx и Vy (|Vx| ≤ 106, |Vy| ≤ 106).
Третья строка входного файла содержит три целых числа: V , t, d (1 ≤ V ≤ 106, 1 ≤ t ≤ 103, 1 ≤ d ≤ 109).

Выходные данные:
В выходной файл OUTPUT.TXT выведите YES, если РК-2000 может через заданное время t
оказаться ровно на заданном расстоянии d от цели, и NO – в противном случае.

Примеры:
№	INPUT.TXT	OUTPUT.TXT
1	1 1		NO
	1 1
	1 1 1
2	1 1		YES
	1 1
	1 1 2
*/
public class Task_492 {
	private static final String INPUT_FILE = "INPUT.TXT";
	private static final String OUTPUT_FILE = "OUTPUT.TXT";

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
				BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

			String[] position = reader.readLine().trim().split(" ");
			long x0 = Long.parseLong(position[0]);
			long y0 = Long.parseLong(position[1]);

			String[] velocity = reader.readLine().trim().split(" ");
			long vx = Long.parseLong(velocity[0]);
			long vy = Long.parseLong(velocity[1]);

			String[] cruiseData = reader.readLine().trim().split(" ");
			long V = Long.parseLong(cruiseData[0]);
			long t = Long.parseLong(cruiseData[1]);
			long d = Long.parseLong(cruiseData[2]);

			long tx = x0 + vx * t;
			long ty = y0 + vy * t;

			long targetDistanceSquared = tx * tx + ty * ty;
			long maxCruiserDistance = V * t;
			boolean canReach;

			if (d * d > targetDistanceSquared) {
				long difference = d - maxCruiserDistance;
				canReach = difference <= 0 || targetDistanceSquared >= difference * difference;
			} else {
				long sum = d + maxCruiserDistance;
				canReach = targetDistanceSquared <= sum * sum;
			}

			writer.write(canReach ? "YES" : "NO");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
