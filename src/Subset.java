import java.util.HashMap;
import java.util.Map;

//Given two arrays, array1 and array2, find if array2 is a subset of array1

public class Subset {
	public static boolean isSubset(int arr1[], int arr2[]){
		Map<Integer, Boolean> map = new HashMap<>();
		
		for(int i : arr1)
			map.put(i, true);
		
		for(int i : arr2)
			if(!map.containsKey(i))
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr1 =  {10, 5, 2, 23, 19};
		int[] arr2 = {19, 5, 3};
		
		System.out.println(isSubset(arr1, arr2));
	}
}
