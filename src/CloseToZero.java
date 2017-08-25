import java.util.Arrays;

//Given an array, find two numbers for which the sum of them is closest
//to zero.

public class CloseToZero {
	//Method 1 : Two for loops
	
//	public static void findTwoNumbers(int[] arr)
//	{
//		int min_1, min_2;
//		min_1 = 0;
//		min_2 = 1;
//		int min_diff = Math.abs(arr[0] + arr[1]);
//		for(int i = 0; i < arr.length; i++)
//		{
//			for(int j = 0; j < arr.length; j++)
//			{
//				if(i != j)
//				{
//					int value = Math.abs(arr[i] + arr[j]);
//					if(value < min_diff){
//						min_diff = value;
//						min_1 = i;
//						min_2 = j;
//					}
//				}
//			}
//		}
//		System.out.println(arr[min_1] + " and " + arr[min_2] + " are the elements.");
//		System.out.println("Difference = " + min_diff);
//	}
	
	public static void swap(int[] arr, int pos_1, int pos_2)
	{
		int temp = arr[pos_1];
		arr[pos_1] = arr[pos_2];
		arr[pos_2] = temp;
	}
	
	public static void bubbleSort(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length - 1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void findTwoNumbers(int[] arr)
	{
		bubbleSort(arr);
		
		ArrayRotation.printArray(arr);
		
		//Use two pointers
		int l = 0; //One for the small element
		int r = arr.length - 1; //One for the large element
		
		int min_diff = Math.abs(arr[l] + arr[r]);
		int min_1 = l;
		int min_2 = r;
		
		//While we don't have more elements
		while(l < r)
		{
			int value = Math.abs(arr[l] + arr[r]);
			if(value < min_diff){
				min_diff = value;
				min_1 = l;
				min_2 = r;
			}
			
			//If value is negative
			if(value < 0)
				l++;//Increment the left pointer
			else
				r--;//Else decrement the right one
		}
		System.out.println(arr[min_1] + " and " + arr[min_2] + " are the elements.");
		System.out.println("Difference = " + min_diff);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 60, -10, 70, -80, 85};
		findTwoNumbers(arr);
	}
}
