import java.util.HashMap;

public class SortByFrequency {
	
	public static void sortByFreq(int[] arr)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr)
		{	
			if(map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}
		
		int arrIndex = 0;
		for(HashMap.Entry<Integer, Integer> item : map.entrySet())
		{
			int times = item.getValue();
			for(int i = 1; i <= times; i++)
			{
				arr[arrIndex++] = item.getKey();
			}
		}
	}
	
	public static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
		
		printArray(arr);
		
		sortByFreq(arr);
		
		printArray(arr);
	}
}
