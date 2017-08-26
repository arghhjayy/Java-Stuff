
import java.util.Arrays;

//Given an array of integers, write a function that returns true
//if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

public class PythagoreanTriplets {
	
	public static boolean anyTriplets(int[] arr){
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = arr[i] * arr[i];
		}
		
		for(int i = arr.length - 1; i >= 2; i--){
			//Fix arr[i](consider this as 'c') and check for corresponding
			//a and b such that a**2 + b**2 = c**2
			int l = 0;
			int r = i - 1;
			
			while(l < r){
				//Found a triplet
				if(arr[i] == arr[l] + arr[r])
					return true;

				if(arr[i] > arr[l] + arr[r])
					l++;
				else
					r--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 6, 5};
		
		System.out.println(anyTriplets(arr));
	}
}
