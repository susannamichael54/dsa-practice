import java.util.*;
import java.util.stream.*; 

public class SquareMatrixMultiply {
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the order of the array");
		int n = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the 1st array");
		String [] inputStrArry1 = new String [n];
		int [][] inputArray1 = new int [n][n];
		for(int i = 0; i < n; i++){
			inputStrArry1[i] = scan.nextLine();
			inputArray1[i] = Stream.of(inputStrArry1[i].split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		System.out.println("Enter the 2nd array");
		String [] inputStrArry2 = new String [n];
		int [][] inputArray2 = new int [n][n];
		for(int i = 0; i < n; i++){
			inputStrArry2[i] = scan.nextLine();
			inputArray2[i] = Stream.of(inputStrArry2[i].split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int[][] output = new int [n][n];
		output = multiplyArrays(inputArray1, inputArray2, n);
		for(int i = 0; i < n; i++){
			String outputStr = "";
			for(int j = 0; j < n; j++){
				outputStr += output[i][j] + " ";
			}
			System.out.println(outputStr.trim());
		}
	}

	public static int [][] multiplyArrays (int [][] inputArray1, int [][] inputArray2, int n) {
		int [][] output = new int [n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++) {
				int sum = 0;
				for(int k = 0; k < n; k++){
					sum += inputArray1[i][k] * inputArray2[k][j];	
				}
				output[i][j] = sum;
			}
		}
		return output;
	}
}