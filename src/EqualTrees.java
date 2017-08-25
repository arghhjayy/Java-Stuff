/**
 *
 * @author arghhjayy
 */

public class EqualTrees {
	
	public static boolean areEqual(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
			return true;
		else if(root1 != null && root2 != null)
			return (root1.data == root2.data && areEqual(root1.left, root2.left)
					&& areEqual(root1.right, root2.right));
		return false;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode(2);
		
		//Fill left side
		root1.addLeft(3);
		root1.left.addLeft(1);
		root1.left.left.addRight(11);
		
		//Fill right side
		root1.addRight(5);
		root1.right.addRight(10);
		root1.right.right.addRight(8);
		root1.right.right.right.addRight(4);
		
		BinaryTreeNode root2 = new BinaryTreeNode(2);
		
		//Fill left side
		root2.addLeft(3);
		root2.left.addLeft(1);
		root2.left.left.addRight(11);
		
		//Fill right side
		root2.addRight(5);
		root2.right.addRight(10);
		root2.right.right.addRight(8);
		root2.right.right.right.addRight(4);
		
		System.out.println(areEqual(root1, root2));
	}
}
