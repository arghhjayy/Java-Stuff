//http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/

public class BinaryTreeToDLL {
	
	public static BinaryTreeNode binaryTree2DLL(BinaryTreeNode root){
		//If tree is empty, do nothing
		if(root == null)
			return root;
		
		if(root.left != null){
			//Recursively apply the method to the left subtree
			BinaryTreeNode left_node = binaryTree2DLL(root.left);
			
			//Find the inorder predecessor of the current root
			while(left_node.right != null)
				left_node = left_node.right;
			
			//Make the right of the inorder predecessor the root
			left_node.right = root;
			
			//Make the left of root the inorder predecessor
			root.left = left_node;
		}
		
		if(root.right != null){
			//Recursively apply the method to the right subtree
			BinaryTreeNode right_node = binaryTree2DLL(root.right);
			
			//Find the inorder successor of the current root
			while(right_node.left != null)
				right_node = right_node.left;
			
			//Make the left of the inorder successor the root
			right_node.left = root;
			
			//Make the right of the root the inorder successor
			root.right = right_node;
		}
		
		return root;
	}
	
	public static BinaryTreeNode b2ll(BinaryTreeNode root){
		if(root == null)
			return null;
		
		//Convert to DLL
		root = binaryTree2DLL(root);
		
		//Find the head of the DLL so generated
		while(root.left != null)
			root = root.left;
		
		//Root here refers to the head of the doubly linked list
		return root;
	}
	
	public static void show(BinaryTreeNode root){
		while(root != null){
			System.out.print(root.data + " ");
			root = root.right;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		
		root.left = new BinaryTreeNode(12);
		root.left.left = new BinaryTreeNode(25);
		root.left.right = new BinaryTreeNode(30);
		
		root.right = new BinaryTreeNode(15);
		root.right.left = new BinaryTreeNode(36);
		
		root = b2ll(root);
		
		show(root);
	}
}