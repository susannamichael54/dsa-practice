import java.util.*;
import java.util.stream.*;

public class Heap {

	public Heap (int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.heap = new int[maxSize];
	}

	private int size;

	private int maxSize;

	private int[] heap;

	public int size () {
		return this.size;
	}

	public int maxSize () {
		return this.maxSize;
	}

	private void maxHeapify (int index) {
		int largestIndex = index;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		if(leftIndex < this.size - 1 && this.heap[leftIndex] > this.heap[largestIndex]) {
			largestIndex = leftIndex;
		}
		if(rightIndex < this.size - 1 && this.heap[rightIndex] > this.heap[largestIndex]) {
			largestIndex = rightIndex;
		}

		if(index != largestIndex){
			swap(index, largestIndex);
			maxHeapify(largestIndex);
		}

	}

	private void swap (int index1, int index2) {
		int temp = this.heap[index1];
		this.heap[index1] = this.heap[index2];
		this.heap[index2] = temp;
	}

	private void buildMaxHeap (){
		for(int i = (this.size - 1) / 2; i <= 0; i--) {
			maxHeapify(i);
		}
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	public void insert(int value) {
		size++;
		if(size > maxSize) {
			return;
		}
		heap[size - 1] = value;
		int currentIndex = size - 1;
		while(heap[currentIndex] > heap[parent(currentIndex)]) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}		
	}

	public void print() {
		String output = "";
		for(int i = 0; i < size; i++) {
			output += heap[i] + " ";
		}
		System.out.println(output);
	}

	public int remove() {
		int popped = heap[0];
		size--;
		maxHeapify(size - 1);
		return popped;
	}

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the heap");
		int size = scan.nextInt();
		scan.nextLine();
		Heap heap = new Heap(size);
		for(int i = 0; i < size; i++) {
			System.out.println("Enter the " + i + "th element");
			int ith = scan.nextInt();
			heap.insert(ith);
		}
		heap.print();
		heap.remove();
		heap.print();
		heap.insert(15);
		heap.print();
	}

}