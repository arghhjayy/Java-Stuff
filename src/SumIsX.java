import java.util.HashMap;
import java.util.Map;

//Given an array and an integer 'x', find two elements in the array
//such that their sum is x.

public class SumIsX {
	
	//Method 1: Two for loops
//	public static void findElements(int[] arr, int x)
//	{
//		int ele1 = 0;
//		int ele2 = 1;
//		
//		int sum = arr[ele1] + arr[ele2];
//		boolean found = false;
//		
//		if(sum == x)
//		{
//			System.out.println("Numbers you are looking for are " + arr[ele1] + " and " + arr[ele2]);
//			return;
//		}
//		
//		for(int i = 0; i < arr.length; i++)
//		{
//			for(int j = 0; j < arr.length; j++)
//			{
//				if(i != j)
//				{
//					if(arr[i] + arr[j] == x)
//					{
//						ele1 = i;
//						ele2 = j;
//						found = true;
//						break;
//					}
//				}
//			}
//		}
//		if(found)
//		{
//			System.out.println("Numbers found!");
//			System.out.println("Numbers you are looking for are " + arr[ele1] + " and " + arr[ele2]);
//		}
//		else
//		{
//			System.out.println("Numbers not found");
//		}
//	}
	
	//Method 2: Use Map
	
	public static void findElements(int[] arr, int x)
	{
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		int ele1;
		int ele2;
		
		for(int i = 0; i < arr.length; i++)
		{
			if(map.containsKey(x - arr[i]))
			{
				System.out.println(arr[i] + " and " + (x - arr[i]) + " are the elements.");
				return;
			}
			map.put(arr[i], Boolean.TRUE);
		}
		System.out.println("No elements found");
	}
	
	public static void main(String[] args) {
		int[] arr = {-8, 1, 4, 6, 10, 45};
		
		findElements(arr, 16);
	}
}
