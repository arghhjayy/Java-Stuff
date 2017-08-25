/**
 *
 * @author arghhjayy
 */

public class TreeSize {
	
	public static int getSize(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		else
			return (1 + getSize(root.left) + getSize(root.right));
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(2);
		
		//Google "binary tree".. first photo
		//Fill left side
		root.addLeft(7);
		root.left.addLeft(2);
		root.left.addRight(6);
		root.left.right.addLeft(5);
		root.left.right.addRight(11);
		
		//Fill right side
		root.addRight(5);
		root.right.addRight(9);
		root.right.right.addLeft(4);
		
		System.out.println(getSize(root));
	}
}
