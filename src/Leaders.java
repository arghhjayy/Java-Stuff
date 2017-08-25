/**
 *
 * @author arghhjayy
 */

//Given an array, print all elements for which all the elements to their right
//are smaller

public class Leaders {
	
	//Let max = 0. Start scanning from the right of the array. If the current
	//element has value greater than the max value, change max value. Every time
	//maximum changes its value, print max value
	
	public static void printLeaders(int[] arr)
	{
		int max = 0;
		for(int i = arr.length - 1; i >= 0; i--)
		{
			if(arr[i] > max)
			{
				max = arr[i];
				System.out.print(max + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {16, 17, 4, 3, 5, 2};
		
		printLeaders(arr);
		
		System.out.println();
	}
}
