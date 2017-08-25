/**
 *
 * @author arghhjayy
 */

//Given two sorted arrays:
	//1) of size m + n but containing only m elements, rest of them are empty
	//   which is denoted by -1 in the code
	//2) of size n containing n elements
	//Fill in the contents of the second array onto the first without disturbing
	//the sorting order

public class FillEmptyArray {
	
	//------------//
	// Method 1: No overlap //
	//------------//
	
//	public static void fillIn(int[] mPlusN, int[] from)
//	{
//		//Iterators for both the list
//		int i = 0, j = 0;
//		
//		int mPlusNlen = mPlusN.length;
//				
//		//Make 'i' point to the first empty element
//		while(mPlusN[i] != -1)
//			i++;
//				
//		while(i < mPlusNlen)
//		{
//			mPlusN[i] = from[j];
//			i++;
//			j++;
//						
//			while( i < mPlusNlen && mPlusN[i] != -1)
//				i++;
//		}
//	}
	
	//------------//
	//Method 2: With overlap//
	//------------//
	
	//Moves m elements from array of m + n size to the end of it
	public void moveToEnd(int[] arr)
	{
		int size = arr.length;
		
		int i, j = size - 1;
		
		for(i = size - 1; i >= 0; i--)
		{
			if(arr[i] != -1)
			{
				arr[j] = arr[i];
				j--;
			}
		}
	}
	
	public void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public void fillIn(int[] mPlusN, int[] from)
	{	
		int n = from.length;
		int m = mPlusN.length - n;
		
		//Current pointers
		int i = n;//Pointer to crrent element to be accessed of the 'mPlusN' array
		int j = 0;//Pointer to current element to be accessed of the 'from' array
		int k = 0;//Pointer to current element to be accessed of the output array
		
		while(k < (m + n))
		{
			//Take element from (m + n) if:
			//	The current element of 'mPlusN' is smaller than the current
			//	element of 'from' and we've not reached the end of mPlusN
			//							OR
			//	The elements from the 'from' array have been exhausted
			if((i < (m + n) && mPlusN[i] <= from[j]) || (j == n))
			{
				mPlusN[k] = mPlusN[i];
				k++;
				i++;
			}
			
			//Else, take an element from 'from'
			else
			{
				mPlusN[k] = from[j];
				k++;
				j++;
			}
			
			printArray(mPlusN);
		}
	}
	
	public static void main(String[] args) {
		FillEmptyArray f = new FillEmptyArray();
		
		int[] mPlusN = {2, 8, -1, -1, -1, 13, -1, 15, 20};
		
		int[] from = {5, 7, 9, 25};
		
		System.out.println("===Input===");
		f.printArray(mPlusN);
		System.out.println("===========");
		
		//Move m element to the end
		f.moveToEnd(mPlusN);
		
		System.out.println("===After moving:===");
		f.printArray(mPlusN);
		System.out.println("===================");
				
		f.fillIn(mPlusN, from);
		
		System.out.println("===Final Result===");
		f.printArray(mPlusN);
	}
}
