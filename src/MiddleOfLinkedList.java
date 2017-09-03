//Find the middle element of the linked list
//If the size is even, return the second one

public class MiddleOfLinkedList {
	//Method 1: find the length(say n) of linked list then return the
	//(n / 2)th element
	
	//Method 2:
	public static int findMiddle(LinkedListNode head){
		//Declare two references
		//The slow reference hops one node at a time
		//Fast reference hops two nodes at a time
		LinkedListNode slow = head, fast = head;
		
		//We move the two pointers till the fast pointer reaches
		//the end and becomes null. At this moment, the slow pointer
		//is at the middle of the linked list, hence we return the
		//node's data
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
	}
	
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(10);
		head.next = new LinkedListNode(12);
		head.next.next = new LinkedListNode(15);
		head.next.next.next = new LinkedListNode(30);
		head.next.next.next.next = new LinkedListNode(36);
		
		System.out.println(findMiddle(head));
	}
}
