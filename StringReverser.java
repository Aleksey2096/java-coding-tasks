/*
 * How do you reverse a string in Java?
 */
public class StringReverser {
    public static void main(String[] args) {
        System.out.println(reverseString("REDRUM"));
    }

    public static String reverseString(String initialString) {
        // 1
        // StringBuilder sb = new StringBuilder();
        // for (int i = initialString.length() - 1; i >= 0; --i) {
        // sb.append(initialString.charAt(i));
        // }
        // return sb.toString();

        // 2
        // return new StringBuilder(initialString).reverse().toString();

        // 3
        // String result = "";
        // for (int i = initialString.length() - 1; i >= 0; --i) {
        // result += initialString.charAt(i);
        // }
        // return result;

        // 4
        if (initialString == null) {
            throw new IllegalArgumentException("Null is not a valid input!");
        }
        char[] charArr = initialString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; --i) {
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}
