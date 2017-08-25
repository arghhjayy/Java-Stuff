/**
 *
 * @author arghhjayy
 */

public class ReverseArray {
	
	public static void reverse(int[] arr)
	{
		int start = 0, end = arr.length - 1;
		
		while(start < end)
		{
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}
	
	public static void printArray(int[] arr)
	{
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		
		printArray(array);
		
		reverse(array);
		
		printArray(array);
	}
}
