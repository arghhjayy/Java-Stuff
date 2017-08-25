public class IsBST {
	
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
	
	public static boolean isBST(BinaryTreeNode root)
	{
		if(root == null || (root.left == null && root.right == null))
			return true;
		else if(root.left == null && root.right != null)
			return (root.right.data > root.data && isBST(root.right));
		else if(root.right == null && root.left != null)
			return (root.data > root.left.data && isBST(root.left));
		else
			return (root.data > root.left.data && root.right.data > root.data && isBST(root.left) && isBST(root.right));
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(12);
		root.right = new BinaryTreeNode(15);
		root.left.left = new BinaryTreeNode(25);
		root.left.right = new BinaryTreeNode(30);
		root.right.left = new BinaryTreeNode(36);
		
		System.out.println(isBST(root));
	}
}
