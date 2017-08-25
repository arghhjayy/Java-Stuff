
import java.util.LinkedList;

/**
 *
 * @author arghhjayy
 */

public class LinkedListtoBinaryTree {
	
	public static BinaryTreeNode linkedListtoBinaryTree(LinkedListNode head)
	{
		LinkedList<LinkedListNode> queue = new LinkedList<>();
		
		while(head != null) {
			queue.offer(head);
			head = head.next;
		}
		
		LinkedList<BinaryTreeNode> queue2 = new LinkedList<>();
		BinaryTreeNode root = new BinaryTreeNode(queue.poll().data);
		queue2.offer(root);
				
		while(!queue.isEmpty())
		{
			BinaryTreeNode popped = queue2.poll();
			
			popped.left = new BinaryTreeNode(queue.poll().data);
			if(!queue.isEmpty())
				popped.right = new BinaryTreeNode(queue.poll().data);
			
			queue2.offer(popped.left);
			queue2.offer(popped.right);
		}
		return root;
	}
	
	public static void inOrder(BinaryTreeNode root)
	{
		if(root != null)
		{
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(10);
		head.next = new LinkedListNode(12);
		head.next.next = new LinkedListNode(15);
		head.next.next.next = new LinkedListNode(25);
		head.next.next.next.next = new LinkedListNode(30);
		head.next.next.next.next.next = new LinkedListNode(36);
		
		BinaryTreeNode root = linkedListtoBinaryTree(head);
		inOrder(root);
	}
}
