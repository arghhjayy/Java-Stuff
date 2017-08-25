/**
 *
 * @author arghhjayy
 */

public class BinaryTreeToCircularLL {
	
	public static BinaryTreeNode concatenate(BinaryTreeNode head1, BinaryTreeNode head2)
	{
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		BinaryTreeNode lastLeft = head1.left;
		
		BinaryTreeNode lastRight = head2.right;
		
		lastLeft.right = head2;
		head2.left = lastLeft;
		
		lastRight.right = head1;
		
		head1.left = lastRight;
		
		return head1;
	}
	
	public static BinaryTreeNode binaryTreeToCLL(BinaryTreeNode root)
	{
		if(root == null)
			return null;
		
		BinaryTreeNode left = binaryTreeToCLL(root.left);
		BinaryTreeNode right = binaryTreeToCLL(root.right);
		
		System.out.println("Processing " + root.data);
		
		root.left = root.right = root;
		
		return concatenate(concatenate(left, root), right);
	}
	
	public static void traverseSpecial(BinaryTreeNode head)
	{
		BinaryTreeNode curr = head;
		
		while(curr.right != head)
		{
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(12);
		root.right = new BinaryTreeNode(15);
		root.left.left = new BinaryTreeNode(25);
		root.left.right = new BinaryTreeNode(30);
		root.right.left = new BinaryTreeNode(36);
		
		BinaryTreeNode head = binaryTreeToCLL(root);
		
		traverseSpecial(head);
	}
}
