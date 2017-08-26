import java.util.Deque;
import java.util.LinkedList;

/*
Given an array and an integer k, find the maximum for each and
every contiguous subarray of size k.
*/

public class MaximumWindow {
	
	//Using deque
	public static void printMaximumWindow(int[] arr, int k){
		//A double ended queue: insertions and deletions are possible
		//through both the sides, front and rear
		Deque<Integer> dq = new LinkedList<>();
		
		//Array size
		int n = arr.length, i;
		
		//Process the first 'k' elements
		for(i = 0; i < k; i++){
			//Remove all the indices of elements which are smaller than
			//the element we're currently looking at i. e. arr[i]
			//while the dequeue has elements to offer
			while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]){
				dq.removeLast();
			}
			
			//Add the current element to the list
			dq.addLast(i);
		}
		
		//Now we process the further elements of the array
		while(i < n){
			//The first element of the list is the largest element of the
			//given subarray/window. Print it.
			
			//If want the minimum of this window, dq.peekLast()
			System.out.print(arr[dq.peekFirst()]+ " ");
			
			//Now, remove the elements which are not in this window/subarray
			//while the dequeue has more elements to offer
			while(!dq.isEmpty() && dq.peekFirst() <= i - k){
				dq.removeFirst();
			}
			
			//Now, remove all the indices of elements which are smaller than the
			//element which we're curently looking at i.e. arr[i] while 
			//the dequeue has more elements to offer
			while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]){
				dq.removeLast();
			}
			
			//Add the current element
			dq.addLast(i);
			
			i++;
		}
		
		System.out.println(arr[dq.peekFirst()]);
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 1, 78, 90, 57, 89, 56};
		
		printMaximumWindow(arr, 2);
	}
}
