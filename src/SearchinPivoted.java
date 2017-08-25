public class SearchinPivoted {
	
	//==============//
	//   Method 1	//
	//==============//
	
//	public static int binarySearch(int[] arr, int low, int high, int key)
//	{
//		if(high < low)
//			return -1;
//		
//		int mid = (low + high) / 2;
//		if(arr[mid] == key)
//			return mid;
//		if(arr[mid] > key)
//			return binarySearch(arr, 0, mid - 1, key);
//		return binarySearch(arr, mid + 1, high, key);
//	}
//	
//	public static int findPivot(int[] arr, int low, int high)
//	{
//		if(low > high) return -1; //Base check. If true, no pivot exists
//		if(low == high) return low; //Array contains only one element, return either low or high, doesn't matter as they're equal
//		
//		int mid = (low + high) / 2;
//		
//		// Base check    if current (mid) element is pivot, it should be greater than its next element
//		if(mid < high && arr[mid] > arr[mid+1])
//			return mid;
//		
//		// Base check    if current (mid - 1) element is pivot, it should be greater than its next element
//		if(mid > low && arr[mid] < arr[mid - 1])
//			return mid - 1;
//		if(arr[low] >= arr[mid])
//			return findPivot(arr, low, mid - 1);
//		return findPivot(arr, mid + 1, high);
//	}
//	
//	public static int search(int[] arr, int key)
//	{
//		//Find pivot element i.e. the element for which the next element is smaller than itself
//		int pivotIndex = findPivot(arr, 0, arr.length);
//		
//		//If pivot element doesn't exist (if findPivot returns -1), run Binary Search on the whole array
//		if(pivotIndex == -1)
//			return binarySearch(arr, 0, arr.length, key);
//		
//		if(arr[pivotIndex] == key)
//			return pivotIndex;
//		if(arr[0] <= key)
//			return binarySearch(arr, 0, pivotIndex - 1, key);
//		return binarySearch(arr, pivotIndex, arr.length, key);
//	}
	
	//==========//
	// Method 2 //
	//==========//
	
	public static int search(int[] arr, int low, int high, int key)
	{
		//If no pivot exists
		if(low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if(arr[mid] == key) return mid;
		
		//If current array is sorted
		if(arr[low] <= arr[mid])
		{
			
			//If the key is in between the bounds, search for the key in the first half of the array
			if(key >= arr[low] && key < arr[mid])
				return search(arr, low, mid - 1, key);
			
			//else, search for the key in the other half of the array
			return search(arr, mid + 1, high, key);
		}
		
		//Else if the array is not sorted
		//If the key is contained in the given bounds
		if(key >= arr[mid + 1] && key <= arr[high])
			return search(arr, mid + 1, high, key);
		
		//else, search in the other half
		return search(arr, low, mid - 1, key);
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 1, 2, 3};
		
		int elementIndex = search(arr, 0, arr.length, 3);
		
		if(elementIndex == -1)
			System.out.println("No " + 3 + " found");
		else
			System.out.println(3 + " found at " + elementIndex);
	}
}
