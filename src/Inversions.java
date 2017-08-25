//Find number of inversions: An inversion in an array if at some i and j,
// arr[i] > arr[j] where i < j

public class Inversions {
	
	//Method 1
//	
//	//Two for loops, basic stuff
//	
//	public static int getInversions(int[] arr)
//	{
//		int inversions = 0;
//		for(int i = 0; i < arr.length; i++)
//		{
//			for(int j = i + 1; j < arr.length; j++)
//			{
//				if(arr[i] > arr[j])
//					inversions++;
//			}
//		}
//		return inversions;
//	}
	
	
	//Method 2
	//This is similar to merge sort algo
	//1) Divide the arrays into two halves
	//2) Find the number of inversions in the left half
	//3) Find the number of inversions in the right half
	//4) Find the number of inversions in the merge() step
	//5) Add step 2, 3, and 4's number of inversions and return it
	public static int getInversions(int[] arr, int[] temp, int l, int r)
	{
		int inversions = 0;
		int mid = (l + r) / 2;
		
		if(l < r)
		{
			//Dividing: left
			inversions += getInversions(arr, temp, l, mid);
			//Dividing: right
			inversions += getInversions(arr, temp, mid + 1, r);
			//merge()ing the above
			inversions += merge(arr, temp, l, r);
		}
		
		return inversions;
	}
	
	public static int calculateInversions(int[] arr, int l, int r)
	{
		int[] temp = new int[arr.length];
		return getInversions(arr, temp, l, r);
	}
	
	public static int merge(int[] arr, int[] temp, int l,  int r)
	{
		//The right subarray starts at arr[mid] i.e. arr[mid] is
		// the first element of the right subarray
		int mid = (l + r) / 2 + 1;
		
		int i = l;
		int j = mid;
		int k = l;
		
		int inversions = 0;
		
		while(i < mid && j <= r)
		{
			//If the current element of the left part of the array
			//is less than the current element of the right part,
			//add it to the temp array.
			if(arr[i] < arr[j])
			{
				temp[k] = arr[i];
				i++;
				k++;
			}
			//Else, if it is greater, add (mid - i) to the current
			//inversion count BECAUSE the left subarray is sorted
			//and if the element in the first subarray is greater,
			//then for every element between the current left array
			//element and arr[mid](arr[mid] is the element where right
			//array starts), there is an inversion. Hence, (mid - i) i. e.
			// the number of elements between the first element of right
			//subarray and the current left subarray element is added
			//to the number of inversions.
			else
			{
				temp[k] = arr[j];
				j++;
				k++;
				
				inversions += (mid - i);
			}
		}
		
		//Usual merge algo
		while(i < mid)
		{
			temp[k] = arr[i];
			k++;
			i++;
		}
		
		while(j < r)
		{
			temp[k] = arr[j];
			k++;
			j++;
		}
		
		//Copy processed(sorted) elements back into the original array
		for(i = l; i < r; i++)
			arr[i] = temp[i];
		
		return inversions;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 20, 6, 4, 5};
		
		System.out.println(calculateInversions(arr, 0, arr.length - 1));
	}
}
