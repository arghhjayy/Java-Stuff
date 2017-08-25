public class LinkedListNode {
	public int data;
	public LinkedListNode next;
	
	public static void display(LinkedListNode head){
		LinkedListNode temp = head;
		
		while(temp != null){
			System.out.print(temp.data + " ");	
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	LinkedListNode(int data)
	{
		this.data = data;
	}
}
