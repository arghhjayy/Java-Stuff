import java.util.*;

//Given an array and an integer 'k', find if the array has duplicates
//within k range

//Examples:

//Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
//Output: false
//All duplicates are more than k distance away.
//
//Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
//Output: true
//1 is repeated at distance 3.
//
//Input: k = 3, arr[] = {1, 2, 3, 4, 5}
//Output: false
//
//Input: k = 3, arr[] = {1, 2, 3, 4, 4}
//Output: true

//Solution: We use a hash table
//In the hash table we store elements within the given range 'k'
//Consider the current element as 'arr[i]'. So if the current element
//is in the hash table, we return true, otherwise, continue searching
//hash table

public class DuplicateExists {
	public static boolean containsDuplicatesWithinK(int[] arr, int k){
		Map<Integer, Boolean> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i]))
				return true;
			
			map.put(arr[i], Boolean.TRUE);
			
			//Delete the boundary element if i >= k
			if(i >= k)
				map.remove(arr[i - k]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 4};
		
		System.out.println(containsDuplicatesWithinK(arr, 3));
	}
}
