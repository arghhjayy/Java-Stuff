public class HeightofBinaryTree {
	
	public static int getHeight(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		else
			return Math.max(1 + getHeight(root.left), 1 + getHeight(root.right));
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(2);
		
		//Fill left side
		root.addLeft(3);
		root.left.addLeft(1);
		root.left.left.addRight(11);
		
		//Fill right side
		root.addRight(5);
		root.right.addRight(10);
		root.right.right.addRight(8);
		root.right.right.right.addRight(4);
		
		System.out.println(getHeight(root));
	}
}
