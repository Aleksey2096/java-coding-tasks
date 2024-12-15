/*
 * Implement a stack using arrays
 */
public class ArrayStack {
	private final int[] stack;
	private final int capacity;
	private int top;

	public ArrayStack(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		top = -1;
	}

	public void push(int value) {
		if (top == capacity - 1) {
			throw new RuntimeException("Stack overflow");
		} else {
			stack[++top] = value;
		}
	}

	public int pop() {
		if (top == -1) {
			throw new RuntimeException("Stack underflow");
		}
		return stack[top--];
	}

	public int peek() {
		if (top == -1) {
			throw new RuntimeException("Stack is empty");
		}
		return stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Top element: " + stack.peek());
		System.out.println("Popped: " + stack.pop());
		System.out.println("Is stack empty? " + stack.isEmpty());
	}
}
