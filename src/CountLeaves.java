public class CountLeaves {
	
	public static int countLeaves(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return countLeaves(root.left) + countLeaves(root.right);
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(12);
		root.right = new BinaryTreeNode(15);
		root.left.left = new BinaryTreeNode(25);
		root.left.right = new BinaryTreeNode(30);
		root.right.left = new BinaryTreeNode(36);
		
		System.out.println(countLeaves(root));
	}
}
