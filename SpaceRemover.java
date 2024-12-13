/*
 * How do you remove spaces from a string in Java?
 */
public class SpaceRemover {
    public static void main(String[] args) {
        System.out.println(removeWhiteSpaces("  p  h  \nd  "));
    }

    public static String removeWhiteSpaces(String input) {
        StringBuilder output = new StringBuilder();

        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (!Character.isWhitespace(c))
                output.append(c);
        }

        return output.toString();
    }
}
