import java.util.*;
import java.util.stream.*;

public class HeapSort {

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array to sort");
		String input = scan.nextLine();
		int [] inputIntArry = Stream.of(input.split(" "))
									.mapToInt(Integer::parseInt)
									.toArray();
		sort(inputIntArry);
		String output = "";
		for(int i = 0; i < inputIntArry.length; i++) {
			output += inputIntArry[i] + " ";
		}
		System.out.println(output.trim());

	}

	public static void heapify(int [] arry, int n, int heapSize) {
		int largestIndex = n;
		int leftIndex = 2 * n + 1;
		int rightIndex = 2 * n + 2;			
		if(leftIndex <= heapSize && arry[leftIndex] > arry[largestIndex]) {
			largestIndex = leftIndex;
		}
		if(rightIndex <= heapSize && arry[rightIndex] > arry[largestIndex]) {
			largestIndex = rightIndex;
		}
		if(largestIndex != n) {
			int temp = arry[n];
			arry[n] = arry[largestIndex];
			arry[largestIndex] = temp;
			heapify(arry, largestIndex, heapSize);
		}
	}

	public static void buildMaxHeap (int [] arry) {
		int heapSize = arry.length - 1;
		for(int i = (arry.length / 2) - 1; i >= 0; i--) {
			heapify(arry, i, heapSize);
		}
	}

	public static void sort (int [] arry) {
		buildMaxHeap (arry);
		int heapSize = arry.length - 1;
		for(int i = arry.length - 1; i >= 1; i--) {
			int temp = arry[0];
			arry[0] = arry[i];
			arry[i] = temp;
			heapSize--;
			heapify(arry, 0, heapSize);
		}
	}
}