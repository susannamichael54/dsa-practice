import java.util.*;
import java.util.stream.*; 

public class MergeSort {

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array to be sorted");
		String input = scan.nextLine();
		String [] inputStrArry = input.split(" ");	
		int [] inputIntArry = Stream.of(inputStrArry).mapToInt(Integer::parseInt).toArray();
		mergeSort(inputIntArry, 0, inputIntArry.length - 1);
		arryToStr(inputIntArry);
	}

	public static  void mergeSort(int [] arry, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(arry, p, q);
			mergeSort(arry, q + 1, r);
			merge(arry, p, q, r);
		}
	}

	public static void merge (int [] arry, int p, int q, int r) {
		int [] left = new int [q - p + 1];
		int [] right = new int [r-q];
		for(int i = 0; i < left.length; i++) {
			left[i] = arry[p + i];
		}
		for(int i = 0; i < right.length; i++) {
			right[i] = arry[q + 1 + i];
		}
		int i = 0;
		int j = 0;
		int k = p;
		while(i < left.length && j < right.length){
			if(left[i] <= right[j]){
				arry[k] = left[i];
				i++;
			} else {
				arry[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < left.length) {
			arry[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length) {
			arry[k] = right[j];
			j++;
			k++;
		}
	}

	public static void arryToStr (int[] inputIntArry) {
		String output = "";
		for (int num: inputIntArry){
			output += num + " ";
		}
		System.out.println("Sorted Array: " + output.trim());
	}
}
