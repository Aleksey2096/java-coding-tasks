import java.util.Stack;

/*
 * Sort a stack using recursion
 */
public class StackSorter {
	public static void sortStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sortStack(stack);
			insertInSortedOrder(stack, temp);
		}
	}

	private static void insertInSortedOrder(Stack<Integer> stack, int value) {
		if (stack.isEmpty() || stack.peek() <= value) {
			stack.push(value);
		} else {
			int temp = stack.pop();
			insertInSortedOrder(stack, value);
			stack.push(temp);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(2);

		sortStack(stack);
		System.out.println("Sorted Stack: " + stack);
	}
}
