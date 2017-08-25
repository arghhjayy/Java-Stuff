public class MakingChildrenSum {
	
	public static void increment(BinaryTreeNode root, int diff)
	{
		if(root.left != null)
		{
			root.left.data = root.left.data + diff;
			
			increment(root.left, diff);
		}
	
		else if(root.right != null)
		{
			root.right.data = root.right.data + diff;
			
			increment(root.right, diff);
		}
	}
	
	public static void makeChildrenSum(BinaryTreeNode root)
	{
		if(root == null || (root.left == null && root.right == null))
			return;
		
		else
		{
			int left_data = 0, right_data = 0;
			
			makeChildrenSum(root.left);
			makeChildrenSum(root.right);
			
			if(root.left != null)
				left_data = root.left.data;
			if(root.right != null)
				right_data = root.right.data;
			
			int diff = left_data + right_data - root.data;
			
			if(diff > 0)
				root.data += diff;
			else
				increment(root, -diff);
		}
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
		
        BinaryTreeNode root = new BinaryTreeNode(50);
        root.left = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(1);
        root.right.right = new BinaryTreeNode(30);
		
		inOrder(root);
		
		System.out.println();
		
		makeChildrenSum(root);
		
		inOrder(root);
		
		System.out.println();
	}
}
