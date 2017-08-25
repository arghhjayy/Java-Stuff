//http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

public class ReverseLinkedList {
	
	public LinkedListNode reverseLinkedList(LinkedListNode head, int k){
		LinkedListNode curr = head;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		
		int counter = 0;
		
		while(counter < k && curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			counter++;
		}
		
		if(next != null)
			head.next = reverseLinkedList(next, k);
		
		return prev;
	}
}
