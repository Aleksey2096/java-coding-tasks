import java.util.Arrays;

/*
 * Check if two strings are anagrams
 */
public class AnagramCheck {
	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";
		System.out.println("Are anagrams: " + areAnagrams(str1, str2));
	}

	public static boolean areAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		return Arrays.equals(charArray1, charArray2);
	}
}
