//Given a sorted and rotated array, search for an element
//If element is found, return the index, else return -1

import java.util.Arrays;

public class SearchinRotatedSorted {
	
	public static int searchinRS(int[] arr, int key){
		int pivot = 0;
		
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] > arr[i + 1]) {
				pivot = i;
				break;
			}
		}
		
		int location = Arrays.binarySearch(arr, 0, pivot, key);
		if(location > arr.length || location < 0)
			location = Arrays.binarySearch(arr, pivot + 1, arr.length, key);
		if(location > arr.length || location < 0)
			return -1;
		else
			return location;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		
		System.out.println(searchinRS(arr, 11));
	}
}
