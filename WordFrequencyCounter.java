import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * Count the frequency of words in a text file
 */
public class WordFrequencyCounter {
	public static void main(String[] args) {
		String filePath = "input.txt";
		Map<String, Integer> wordFrequency = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.toLowerCase().split("\\W+");
				for (String word : words) {
					if (!word.isEmpty()) {
						wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Word Frequency:");
		for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
