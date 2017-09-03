//Given an array containing both negative and positive integers.
//Find the contiguous sub-array with maximum sum.

public class KadaneAlgo {
	
	//Algorithm:
	//set running maximum = INFINITY, max ends here = 0
	public static int findMaximumSum(int[] arr){
		
		int running_maximum = arr[0];
		int maximum = arr[0];
		
		for(int i = 0; i < arr.length; i++){
			running_maximum = Math.max(arr[i], running_maximum + arr[i]);
			maximum = Math.max(running_maximum, maximum);
		}
		
		return maximum;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, -1, 2, -2, 3, 4, -6, -1, 1, 5, -2};
		
		System.out.println(findMaximumSum(arr));
	}
}
