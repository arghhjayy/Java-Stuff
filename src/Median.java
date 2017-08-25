
import java.util.Arrays;

/**
 *
 * @author arghhjayy
 */

public class Median {
	public static int median(int[] arr)
	{
		int n = arr.length;
		if(n % 2 == 0)
			return (arr[n/2] + arr[n/2 - 1]) / 2;
		return arr[n/2];
	}
	
	public static int getMedian(int[] arr1, int[] arr2, int n)
	{
		//Arrays contains no element
		if(n <= 0)
			return -1;
		if(n == 1)
			return (arr1[0] + arr2[0]) / 2;
		if(n == 2)
			return ((int)Math.max(arr1[0], arr2[0]) + (int)Math.min(arr1[1], arr2[1])) / 2;
		
		int med1 = median(arr1);
		int med2 = median(arr2);
		
		if(med1 == med2)
			return med1;
		
		//If med1 < med2, then median must exist in ar1[m1...] and ar2[...m2]
		if(med1 < med2){
			if(n % 2 == 0)
				return getMedian(Arrays.copyOfRange(arr1, n/2 - 1, n), arr2, n - n/2 + 1);
			return getMedian(Arrays.copyOfRange(arr1, n/2, n), arr2, n - n/2);
		}
		
		//Else if med1 >= med2, the median must be in arr1[...m1] and ar2[m2...]
		if(n % 2 == 0)
			return getMedian(Arrays.copyOfRange(arr2, n/2 - 1, n), arr1, n - n/2 + 1);
		return getMedian(Arrays.copyOfRange(arr2, n/2, n), arr1, n - n/2);
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 12, 15, 26, 38};
		int[] arr2 = {2, 13, 17, 30, 45};
		int n = arr1.length & arr2.length;
		
		System.out.println(getMedian(arr1, arr2, n));
	}
}
