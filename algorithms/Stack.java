import java.util.*;

public class Stack {

	int[] stack;
	int length;
	int top = 0;

	public Stack(int n) {
		stack = new int[n];
		length = n;
	}

	public int pop() {
		try {
			int temp = stack[--top];
			return temp;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Stack underflow error");
		}
	}

	public void push(int n) {
		try {
			stack[top] = n;
			top++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Stack overflow error");
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the length of the Stack");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Stack s = new Stack(n);
		System.out.println("Enter the elements to push to the stack");
		for (int i = 0; i < n; i++) {
			int input = scan.nextInt();
			s.push(input);
		}
		System.out.println("popping elements from the stack");
		for (int i = 0; i < n; i++) {
			System.out.println(s.pop());
		}
	}
}