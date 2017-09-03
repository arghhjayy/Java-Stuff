public class FindMissingNumber {
	
	public static int findMissingNo(int[] arr){
		//XOR all the elements and the result will be the XOR result
		//It works because x ^ x = 0 and x ^ 0 = x
		//so that if three elements are given (starting from a[1])
		//a[1] ^ a[1] ^ a[2] ^ a[3] ^ a[3] = a[2]
		int res = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			res ^= arr[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 5, 6, 7, 2, 4, 1, 6, 5};
		
		System.out.println(findMissingNo(arr));
	}
}
