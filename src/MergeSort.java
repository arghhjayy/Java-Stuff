/**
 *
 * @author arghhjayy
 */

public class MergeSort {
	
	public static void merge(int[] arr, int leftLimit, int rightLimit)
	{
		//Find mid point, left array's and rigght array's length
		int mid = (leftLimit + rightLimit) / 2;
		int leftArrayLength = mid - leftLimit + 1;
		int rightArrayLength = rightLimit - mid;
		
		//Make temporary left and right arrays
		int[] leftArr = new int[leftArrayLength];
		int[] rightArr = new int[rightArrayLength];
		
		//Store data of left and right array in the respective temp arrays
		
		for(int i = 0; i < leftArrayLength; i++)
			leftArr[i] = arr[leftLimit + i];
		for(int i = 0; i < rightArrayLength; i++)
			rightArr[i] = arr[mid + 1 + i];
		
		//i points to the current element of left array
		//j points to the current element of right array
		//k points to the current element of output array
		int i, j, k;
		
		i = 0;
		j = 0;
		k = leftLimit;
		
		//Merge them, usual algo
		while(i < leftArrayLength && j < rightArrayLength)
		{
			if(leftArr[i]  < rightArr[j])
			{
				arr[k] = leftArr[i];
				i++;
			}
			else
			{
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i < leftArrayLength)
		{
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		
		while(j < rightArrayLength)
		{
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
	
	public static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void mergeSort(int[] arr, int leftLimit, int rightLimit)
	{
		int mid = (leftLimit + rightLimit)/ 2;
		if(leftLimit < rightLimit)
		{
			mergeSort(arr, leftLimit, mid);
			mergeSort(arr, mid + 1, rightLimit);
			merge(arr, leftLimit, rightLimit);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {38, 27, 43, 3, 9, 82, 10};
		
		printArray(arr);
		
		mergeSort(arr, 0, arr.length - 1);
		
		printArray(arr);
	}
}