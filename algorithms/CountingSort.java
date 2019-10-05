import java.util.*;
import java.util.stream.*;

public class CountingSort {

	public static void main(String[] args) {
		System.out.println("Enter the array to be sorted as spaced separated integers");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int[] inputIntArry = Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] outputArry = countingSort(inputIntArry);
		String output = "";
		for (int i = 0; i < outputArry.length; i++) {
			output += outputArry[i] + " ";
		}
		System.out.println(output.trim());
	}

	public static int[] countingSort(int[] arry) {
		int[] b = new int[arry.length];
		int[] c = new int[256];
		for (int i = 0; i < 256; i++) {
			c[i] = 0;
		}
		for (int i = 0; i < arry.length; i++) {
			c[arry[i] - 1]++;
		}
		for (int i = 1; i < 256; i++) {
			c[i] += c[i - 1];
		}
		for (int i = 0; i < arry.length; i++) {
			b[c[arry[i] - 1] - 1] = arry[i];
			c[arry[i] - 1]--;
		}
		return b;
	}

}
