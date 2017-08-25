public class Mirror {
	
	public static BinaryTreeNode mirror(BinaryTreeNode root)
	{
		if(root == null)
			return null;
		
		BinaryTreeNode left = mirror(root.left);
		BinaryTreeNode right = mirror(root.right);
		
		root.left = right;
		root.right = left;
		
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
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		
		root.left.left = new BinaryTreeNode(7);
		root.left.right = new BinaryTreeNode(6);
		
		root.right.left = new BinaryTreeNode(5);
		root.right.right = new BinaryTreeNode(4);
		
		System.out.println("Before mirror(): ");
		inOrder(root);
		System.out.println();
		
		root = mirror(root);
		
		System.out.println("After mirror(): ");
		inOrder(root);
		
		System.out.println();
	}
}
