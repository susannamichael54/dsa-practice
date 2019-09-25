import java.util.*;
import java.util.stream.*; 

public class MaximumSubArray {

	public static void main (String [] args){
		System.out.println("Enter the array");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();		
		String [] inputStrArry = input.split(" ");
		int [] inputIntArry = Stream.of(inputStrArry).mapToInt(Integer::parseInt).toArray();
		int [] maxSubArryValues = findMaxSubArray(inputIntArry, 0, inputIntArry.length -1);
		String output = "";
		for(int i = maxSubArryValues[0]; i <= maxSubArryValues[1]; i++){
			output += inputIntArry[i] + " ";
		}
		System.out.println(output);
	}

	public static int [] findMaxCrossingSubArray (int [] inputIntArry, int low, int mid, int high) {
		int leftSum = -100000;
		int maxLeft = 0;
		int sumL = 0;
		for(int i = mid; i >= low; i--)  {
			sumL += inputIntArry[i];
			if(sumL > leftSum) {
				leftSum = sumL;
				maxLeft = i;
			}
		}
		int rightSum = -100000;
		int maxRight = 0;
		int sumR = 0;
		for(int i = mid + 1; i <= high; i++) {
			sumR += inputIntArry[i];
			if(sumR > rightSum) {
				rightSum = sumR;
				maxRight = i;
			}
		}
		int [] midValues = {maxLeft, maxRight, rightSum + leftSum};
		return midValues;
	}

	public static int [] findMaxSubArray (int [] inputIntArry, int low, int high) {
		if(low == high){
			int [] maxSubArryValues = {low, high, inputIntArry[low]};
			return maxSubArryValues;
		} else {
			int mid = (low + high) / 2;
			int [] leftValues = findMaxSubArray(inputIntArry, low, mid);
			int [] rightVaues = findMaxSubArray(inputIntArry, mid + 1, high);
			int [] midValues = findMaxCrossingSubArray(inputIntArry, low, mid, high);
			if(leftValues[2] >= rightVaues[2] && leftValues[2] >= midValues[2]) {
				return leftValues;
			} else if (rightVaues[2] >= leftValues[2] && rightVaues[2] >= midValues[2]) {
				return rightVaues;
			} else {
				return midValues;
			}
		}
	}

}