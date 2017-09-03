
/*
Given a Binary Tree you need to  find maximum value which you  can get by
subtracting value of node B from value of node A, where A and B are two nodes
of the binary tree and A is an ancestor of B . You are required to
complete the function maxDiff.
*/

class Result{
	int diff;

	public Result() {
		this.diff = Integer.MIN_VALUE;
	}
}

public class MaximumDifference {
	
	public static int maxDiff(BinaryTreeNode root, Result maxi){
		//No tree/ no more tree
		if(root == null)
			return Integer.MAX_VALUE;
		
		//If current node is a leaf, return its value
		if(root.left == null && root.right == null)
			return root.data;
		
		//Recurse for left and right subtree
		int minValue = Math.min(
				maxDiff(root.left, maxi),
				maxDiff(root.right, maxi));
		
		//Update the maximum difference till now
		maxi.diff = Math.max(maxi.diff, root.data - minValue);
		
		//Whether the value of the children is minimum or the current's
		return Math.min(minValue, root.data);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(3);
		root.right = new BinaryTreeNode(10);
		root.left.left = new BinaryTreeNode(1);
		root.left.right = new BinaryTreeNode(6);
		root.left.right.left = new BinaryTreeNode(4);
		root.left.right.right = new BinaryTreeNode(7);
		
		root.right.right = new BinaryTreeNode(14);
		root.right.right.left = new BinaryTreeNode(13);
		
		Result r = new Result();
		
		maxDiff(root, r);
		
		System.out.println(r.diff);
	}
}
