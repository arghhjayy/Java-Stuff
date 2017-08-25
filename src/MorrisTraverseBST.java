public class MorrisTraverseBST {
	
	public static void addNode(BinaryTreeNode root, int data)
	{
		if(root.data > data)
			if(root.left != null)
				addNode(root.left, data);
			else
				root.left = new BinaryTreeNode(data);
		else
			if(root.right != null)
				addNode(root.right, data);
			else
				root.right = new BinaryTreeNode(data);
	}
	
	public static void MorrisTraversal(BinaryTreeNode root)
	{
		BinaryTreeNode curr, predecessor;
		
		curr = root;
		
		while(curr != null)
		{
			if(curr.left == null)
			{
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
			
			else
			{
				predecessor = curr.left;
				
				while(predecessor.right != null && predecessor.right != curr)
					predecessor = predecessor.right;
				
				if(predecessor.right == null)
				{
					predecessor.right = curr;
					curr = curr.left;
				}
				
				else
				{
					predecessor.right = null;
					System.out.print(curr.data + " ");
					curr = curr.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		addNode(root, 6);
		addNode(root, 4);
		addNode(root, 3);
		addNode(root, 10);
		addNode(root, 7);
		
		MorrisTraversal(root);
		System.out.println();
	}
}