/*
 * How do you check whether a string is a palindrome in Java?
 */
public class PalindromeValidator {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abca"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Null or blank value is not valid!");
        }

        // 1
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;

        // 2
        // return s.equals(new StringBuilder(s).reverse().toString());
    }
}
