import java.util.Stack;

/*
 * Convert infix expressions to postfix expressions
 */
public class InfixToPostfix {
	public static String infixToPostfix(String expression) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (char c : expression.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				result.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				stack.pop(); // Remove '('
			} else {
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
					result.append(stack.pop());
				}
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		return result.toString();
	}

	private static int precedence(char operator) {
		return switch (operator) {
		case '+', '-' -> 1;
		case '*', '/' -> 2;
		case '^' -> 3;
		default -> -1;
		};
	}

	public static void main(String[] args) {
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Postfix: " + infixToPostfix(infix));
	}
}
