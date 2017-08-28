public class DepthFirstTraversal {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		
		BinaryTreeNode.inOrder(root);
		System.out.println();
		
		BinaryTreeNode.preOrder(root);
		System.out.println();
		
		BinaryTreeNode.postOrder(root);
		System.out.println();
	}
}
