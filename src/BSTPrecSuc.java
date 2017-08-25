import java.util.Scanner;

public class BSTPrecSuc {

	public static void addNode(BinaryTreeNode root, int data)
	{
		if(root.data > data) {
			if(root.left != null) {
				addNode(root.left, data);
			} else {
				root.left = new BinaryTreeNode(data);
			}
		} else
			if(root.right != null) {
				addNode(root.right, data);
		} else {
				root.right = new BinaryTreeNode(data);
		}
	}
	
	public static boolean search(BinaryTreeNode root, int data)
	{
		if(root == null) {
			return false;
		}
		if(data == root.data) {
			return true;
		}
		if(data < root.data) {
			return search(root.left, data);
		} else {
			return search(root.right, data);
		}
	}
	
	public static int getMinValue(BinaryTreeNode root)
	{
		if(root.left == null) {
			return root.data;
		} else {
			return getMinValue(root.left);
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
	
	public static BinaryTreeNode searchForNode(BinaryTreeNode root, int key)
	{
		if(root == null) {
			return null;
		}
		if(root.data == key) {
			return root;
		} else
			if(key < root.data) {
				return searchForNode(root.left, key);
		} else {
				return searchForNode(root.right, key);
		}
	}
	
	public static BinaryTreeNode maxKeyNode(BinaryTreeNode root)
	{
		if(root.right == null) {
			return root;
		} else {
			return maxKeyNode(root.right);
		}
	}
	
	public static BinaryTreeNode minKeyNode(BinaryTreeNode root)
	{
		if(root.left == null) {
			return root;
		} else {
			return minKeyNode(root.left);
		}
	}
	
	public static BinaryTreeNode inOrderPred(BinaryTreeNode root, int key)
	{
		BinaryTreeNode nodeWithKey = searchForNode(root, key);
		if(nodeWithKey != null && nodeWithKey.left != null) {
			return maxKeyNode(nodeWithKey.left);
		}
		return null;
	}
	
	public static BinaryTreeNode inOrderSucc(BinaryTreeNode root, int key)
	{
		BinaryTreeNode nodeWithKey = searchForNode(root, key);
		
		if(nodeWithKey != null && nodeWithKey.right != null) {
			return minKeyNode(nodeWithKey.right);
		}
		return null;
	}
	
	public static void inOrderSuccPrec(BinaryTreeNode root, BinaryTreeNode prec, BinaryTreeNode succ, int data)
	{
		if(root == null) {
			return;
		}
		
		if(root.data == data)
		{
			BinaryTreeNode nodeWithData = root;
			
			BinaryTreeNode curr = root.left;
			
			if(curr != null){
				while(curr.left != null) {
					curr = curr.left;
				}
				prec = curr;
			}
			
			curr = root.right;
			
			if(curr != null){
				while(curr.right != null) {
					curr = curr.right;
				}
				succ = curr;
			}
			
			return;
		}
		
		if(root.data > data)
		{
			succ = root;
			inOrderSuccPrec(root.left, prec, succ, data);
		}
		
		else
		{
			prec = root;
			inOrderSuccPrec(root.right, prec, succ, data);
		}
	}
		
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		addNode(root, 6);
		addNode(root, 4);
		addNode(root, 3);
		addNode(root, 10);
		addNode(root, 7);
		
		System.out.println("Inorder: ");
		
		inOrder(root);
		
		System.out.println();
		
		System.out.print("Enter a number: ");
				
		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		
//		BinaryTreeNode predecessor = inOrderPred(root, num);
//		BinaryTreeNode successor = inOrderSucc(root, num);
		
		BinaryTreeNode predecessor = null;
		BinaryTreeNode successor = null;
		
		inOrderSuccPrec(root, predecessor, successor, num);
		
		if(predecessor != null) {
			System.out.println("Predecessor: " + predecessor.data);
		} else {
			System.out.println("Nothing: Nothing");
		}
		
		if(successor != null) {
			System.out.println("Successor: " + successor.data);
		} else {
			System.out.println("Successor: Nothing");
		}
	}
}
