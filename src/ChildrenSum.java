public class ChildrenSum {
	
	public static int hasChildrenSum(BinaryTreeNode root)
	{	
		if((root == null) || (root.left == null && root.right == null))
			return 1;
		else
		{
			int left_data = 0;
			int right_data = 0;
			
			if(root.left != null)
				left_data = root.left.data;
			
			if(root.right != null)
				right_data = root.right.data;
			
			if(root.data == (left_data + right_data) && (hasChildrenSum(root.left) != 0) && (hasChildrenSum(root.right) != 0))
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) {
//		BinaryTreeNode root = new BinaryTreeNode(10);
//        root.left = new BinaryTreeNode(8);
//        root.right = new BinaryTreeNode(2);
//        root.left.left = new BinaryTreeNode(3);
//        root.left.right = new BinaryTreeNode(5);
//        root.right.right = new BinaryTreeNode(2);
		
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(12);
		root.right = new BinaryTreeNode(15);
		root.left.left = new BinaryTreeNode(25);
		root.left.right = new BinaryTreeNode(30);
		root.right.left = new BinaryTreeNode(36);
		
		if(hasChildrenSum(root) == 1)
			System.out.println("Yeah!");
		else
			System.out.println("Nope");
	}
}
