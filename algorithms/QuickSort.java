import java.util.*;
import java.util.stream.*;

public class QuickSort {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array to sort as space separated integers");
		String input = scan.nextLine();
		int[] inputIntArry = Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		quickSort(inputIntArry, 0, inputIntArry.length - 1);
		String output = "";
		for (int i = 0; i < inputIntArry.length; i++) {
			output += inputIntArry[i] + " ";
		}
		System.out.println("Sorted Array: " + output.trim());

	}

	public static void quickSort(int[] arry, int p, int r) {
		if (p < r) {
			int q = partition(arry, p, r);
			quickSort(arry, p, q - 1);
			quickSort(arry, q + 1, r);
		}
	}

	public static int partition(int[] arry, int p, int r) {
		int x = arry[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (arry[j] < x) {
				i++;
				swap(arry, i, j);
			}
		}
		swap(arry, i + 1, r);
		return i + 1;
	}

	public static void swap(int[] arry, int i, int j) {
		int temp = arry[i];
		arry[i] = arry[j];
		arry[j] = temp;

	}

}
