import java.util.*;
import java.util.stream.Stream;

public class RadixSort {

	public static void main (String [] args) {
		System.out.println("Enter the array to be sorted as spaced separated integers");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int[] inputIntArry = Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		radixsort(inputIntArry);
		String output = "";
		for (int i = 0; i < inputIntArry.length; i++) {
			output += inputIntArry[i] + " ";
		}
		System.out.println(output.trim());
	}

	public static void radixsort(int arr[]) {
		int n = arr.length;
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}
	
	public static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for (i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	public static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

}