import java.util.Arrays;

public class KeyPair {
	
	public static boolean hasKeyPair(int[] arr, int k){
		Arrays.sort(arr, 0, arr.length);
		
		for(int i = 0; i < arr.length; i++){
			int found = Arrays.binarySearch(arr, k - arr[i]);
			if(found >= 0 && found < arr.length)
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 3, 6};
		
		int k = 7;
		
		System.out.println(hasKeyPair(arr, k));
	}
}
