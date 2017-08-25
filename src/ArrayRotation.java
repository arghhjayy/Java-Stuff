/**
 *
 * @author arghhjayy
 */

public class ArrayRotation {
	
	//Method 1
	
//	public static void rotate(int[] arr, int rotation)
//	{
//		int current_ele = 0;
//		int size = arr.length;
//		while(current_ele < rotation)
//		{
//			int temp = arr[0];
//			
//			int curr_pointer = 0;
//			
//			while(curr_pointer < size - 1)
//			{
//				arr[curr_pointer] = arr[curr_pointer + 1];
//				curr_pointer++;
//			}
//			
//			arr[size - 1] = temp;
//			current_ele++;
//		}
//	}
	
//	//Method 2
//	
//	public static int gcd(int x, int y)
//	{
//		return x == 0 || y == 0 ? (x == 0? y : x) : gcd(y, x % y);
//	}
//	
//	//Keep on updating an element of a 'block' at a time to an element which is
//	//'rotation' distance away from it. If the pointer which is pointing the
//	//element from which data is to be read overflows, reduce the pointer by 
//	//the size of the array and check if it came back to the initial pointer of
//	//this set. If so, stop the current iteration and update the element in the
//	//last block of current iteration
//	//Keep on doing this until the pointer for 
//	public static void rotate(int[] arr, int rotation)
//	{
//		int n = arr.length;
//		int gcd = gcd(n, rotation);
//		int j, k;
//		
//		for(int i = 0; i < gcd; i++)
//		{
//			int temp = arr[i];
//			j = i;
//			
//			while(true)
//			{
//				k = j + rotation;
//				if(k >= n)
//					k = k - n;
//				if(k == i)
//					break;
//				arr[j] = arr[k];
//				j = k;
//			}
//			arr[j] = temp;
//		}
//	}
	
	public static void reverseArray(int[] arr, int start, int end)
	{
		while(start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void rotate(int[] arr, int rotation)
	{
		int n = arr.length;
		reverseArray(arr, 0, rotation - 1);
		reverseArray(arr, rotation, n - 1);
		reverseArray(arr, 0, n - 1);
	}
	
	public static void printArray(int[] arr)
	{
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		printArray(arr);
		
		rotate(arr, 2);
				
		printArray(arr);
	}
}
