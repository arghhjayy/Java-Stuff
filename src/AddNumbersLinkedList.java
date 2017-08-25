public class AddNumbersLinkedList {
	public static LinkedListNode addNumbers(LinkedListNode head1, LinkedListNode head2){
		LinkedListNode result = new LinkedListNode(0);
		LinkedListNode head = result, temp1 = head1, temp2 = head2;
		
		int carry = 0;
		
		while(true){				
			result.data = (temp1.data + temp2.data + carry) % 10;
			
			carry = (temp1.data + temp2.data) / 10;
				
			temp1 = temp1.next;
			temp2 = temp2.next;
			
			if(temp1 == null || temp2 == null)
				break;
			
			result.next = new LinkedListNode(0);
			result = result.next;
		}
		
		if(temp1 == null && temp2 != null){
			while(true){
				result.data = (temp2.data + carry) % 10;
				
				carry = (temp2.data + carry) / 10;
				
				if(temp2.next == null)
					break;
				
				result.next = new LinkedListNode(0);
				
				temp2 = temp2.next;
			}
		}
		
		if(temp2 == null && temp1 != null){
			while(temp1 != null){
				result.data = (temp1.data + carry) % 10;
				carry = (temp1.data + carry) % 10;
				
				if(temp1.next == null)
					break;
				
				result.next = new LinkedListNode(0);
				
				temp1 = temp1.next;
			}
		}
		
		if(carry != 0){
			result.next = new LinkedListNode(carry);
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		LinkedListNode head1 = new LinkedListNode(8);
		head1.next = new LinkedListNode(9);
		head1.next.next = new LinkedListNode(9);
		head1.next.next.next = new LinkedListNode(1);
		
		LinkedListNode head2 = new LinkedListNode(7);
		head2.next = new LinkedListNode(9);
		head2.next.next = new LinkedListNode(9);
		head2.next.next.next = new LinkedListNode(1);
		
		LinkedListNode.display(head1);
		LinkedListNode.display(head2);
		
		LinkedListNode result = addNumbers(head1, head2);
		
		LinkedListNode.display(result);
	}
}