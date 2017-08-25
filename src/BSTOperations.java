public class BSTOperations {
	
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
	
	public static boolean search(BinaryTreeNode root, int data)
	{
		if(root == null)
			return false;
		if(data == root.data)
			return true;
		return (search(root.left, data) || search(root.right, data));
	}
	
	public static int getMinValue(BinaryTreeNode root)
	{
		if(root.left == null)
			return root.data;
		else
			return getMinValue(root.left);
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
		BinaryTreeNode root = new BinaryTreeNode(5);
		addNode(root, 6);
		addNode(root, 4);
		addNode(root, 3);
		addNode(root, 10);
		addNode(root, 7);
		inOrder(root);
		System.out.println();
		
		System.out.println(search(root, 8));
		
		System.out.println(getMinValue(root));
	}
}
