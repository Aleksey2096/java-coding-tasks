import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
