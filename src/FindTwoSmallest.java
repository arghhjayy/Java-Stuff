//Given an array, find the smallest two elements

public class FindTwoSmallest {
	public static void findTwoSmallest(int[] arr)
	{
		if(arr.length < 2)
		{
			System.out.println("Invalid input: Array length is less than 2");
			return;
		}
		
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] < first)
			{
				second = first;
				first = arr[i];
			}
			else if(arr[i] < second && arr[i] > first)
			{
				second = arr[i];
			}
		}
		System.out.println(first + " and " + second + " are the smallest.");
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 1, 5, 4};
		
		findTwoSmallest(arr);
	}
}
