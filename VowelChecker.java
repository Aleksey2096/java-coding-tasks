/*
 * Write a Java program to check if a vowel is present in a string.
 */
public class VowelChecker {
    public static void main(String[] args) {
        System.out.println(isVowelPresent("Hello!"));
        System.out.println(isVowelPresent("bcdfghjklmnprstvwxyz"));
    }

    public static boolean isVowelPresent(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Null is not a valid input!");
        }

        return s.matches(".*[aeiou].*");
    }
}
