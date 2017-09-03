//Given a Binary Tree and a sum s, your task is to check whether
//there is a root to leaf path in that tree with the following sum.
//You are required to complete the function hasPathSum.

public class HasPathSum {
	public static boolean hasPathSum(BinaryTreeNode root, int sum){
		if(root == null)
			return sum == 0;
		else{
			if(sum == 0 && root.left == null && root.right == null)
				return true;
			
			if(root.left != null)
				return hasPathSum(root.left, sum - root.data);
			if(root.right != null)
				return hasPathSum(root.right, sum - root.data);
			//remove this
			return true;
		}
	}
	
	public static void main(String[] args) {
		/*
						10
					  /	   \
					12		15
				   /  \    /
				  25  30  36
		*/
		
		BinaryTreeNode root = new BinaryTreeNode(10);
		
		root.left = new BinaryTreeNode(12);
		root.left.left = new BinaryTreeNode(25);
		root.left.right = new BinaryTreeNode(30);
		
		root.right = new BinaryTreeNode(15);
		root.right.left = new BinaryTreeNode(36);
		
		System.out.println(hasPathSum(root, 25));
	}
}
