import java.util.*;
import java.util.stream.*; 

/*
* Finds the subarrays with maximum sum in the input array
*/

public class MaxSubArrayIterative {

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the input Array");
		String input = scan.nextLine();
		int [] inputIntArry = Stream.of(input.split(" "))
									.mapToInt(Integer::parseInt)
									.toArray();
		String maxSubArryIndexStr = findMaxSubArrayIndices(inputIntArry);
		int [] maxSubArryIndices = Stream.of(maxSubArryIndexStr.split(" "))
									.mapToInt(Integer::parseInt)
									.toArray();
		for(int i = 0; i < maxSubArryIndices.length; i = i + 2){
			String outputArry = "";
			for(int j = maxSubArryIndices[i]; j <= maxSubArryIndices[i + 1]; j++){
				outputArry += inputIntArry[j] + " ";
			}
			System.out.println(outputArry);
		}
	}

	public static String findMaxSubArrayIndices(int [] inputIntArry) {
		int maxSum = inputIntArry[0];
		int sum = 0;
		int startIndex = 0;
		boolean allNegative = true;
		String indexStr = "";
		for (int i = 0; i < inputIntArry.length; i++) {
			sum += inputIntArry[i];
			if(sum >= maxSum){
				if(sum == maxSum){
					indexStr += startIndex + " " + i + " ";
				} else {
					indexStr = startIndex + " " + i + " ";
				}
				maxSum = sum;
			} 
			if (sum <= 0){
				startIndex = i + 1;
				sum = 0;
			}			
		}
		return indexStr.trim();
	}
	
}