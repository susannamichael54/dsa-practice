import java.util.*;
import java.util.stream.*;

public class Queue {

	private int tail = 0;
	private int head = 0;
	private int [] queue;

	public Queue(int length) {
		this.length = length;
		this.queue = new int [length + 1];
	}

	public void enqueue(int x) throws Exception {
		if(incrementIndex(tail) + 1 != head) {
			queue[tail] = x;
			tail = incrementIndex(tail);
		} else {
			throw new Exception("Queue overflow exception!!!");
		}
	}

	public int dequeue() throws Exception {
		int output = 0;
		if(head != tail) {
			output = queue[head];
			head = incrementIndex(head);
		} else {
			throw new Exception("Queue underflow exception!!!");
		}
		return output;
	}

	private int incrementIndex(int index) {
		if(index == queue.length - 1) {
			return 0;
		} else {
			return index + 1;
		}
	}

	public static void main (String [] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter length of queue: ");
		int n = scan.nextInt();
		scan.nextLine();
		Queue queue = new Queue(n);
		System.out.println("Enter the elments of the Queue as space separated Integers");
		String input = scan.nextLine();
		int [] inputArry = Stream.of(input.split(" "))
								.mapToInt(Integer :: parseInt)
								.toArray();
		for(int i = 0; i < n; i++) {
			queue.enqueue(inputArry[i]);
		}
		System.out.println("Dequeue 1: " + queue.dequeue());
		System.out.println("Dequeue 2: " + queue.dequeue());
		System.out.println("Dequeue 3: " + queue.dequeue());
		System.out.println("Dequeue 4: " + queue.dequeue());
		System.out.println("Dequeue 5: " + queue.dequeue());
	}
}
