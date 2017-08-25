/**
 *
 * @author arghhjayy
 */

public class DeleteTree {
	
	public static void deleteTree(BinaryTreeNode root)
	{
		if(root == null) return;
		
		deleteTree(root.left);
		deleteTree(root.right);
		
		root = null;
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
		
		deleteTree(root);
		
		if(root == null)
			System.out.println("Successful.");
	}
}
