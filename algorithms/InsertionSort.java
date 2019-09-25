import java.util.*;
import java.util.stream.*; 


public class InsertionSort {

	public static void main (String [] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of numbers to be sorted");
		int n = scan.nextInt();
		System.out.println("Enter the numbers to be sorted");
		scan.nextLine();
		String input = scan.nextLine();
		String [] inputStrArry = input.split(" ");		
		int [] inputIntArry = Stream.of(inputStrArry).mapToInt(Integer::parseInt).toArray();
		int [] sortedArry = sortInput(inputIntArry);
		String output = "";
		for (int num: sortedArry){
			output += num + " ";
		}
		System.out.println("Sorted Array: " + output.trim());
	}


	public static int [] sortInput (int [] inputIntArry){
		for(int i = 1; i < inputIntArry.length; i++){
			int j = i-1;
			int key = inputIntArry[i];
			while(j >= 0 && inputIntArry[j] > key){
				inputIntArry[j+1] = inputIntArry[j];
				j--;
			}
			inputIntArry[j+1] = key;
		}
		return inputIntArry;
	}
}