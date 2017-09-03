public class BinaryTreeNode
{
	public BinaryTreeNode left;
	public int data;
	public BinaryTreeNode right;

	BinaryTreeNode() {}
	
	BinaryTreeNode(int data)
	{
		this.data = data;
	}
	
	public void addLeft(int data)
	{
		this.left = new BinaryTreeNode(data);
	}
	
	public void addRight(int data)
	{
		this.right = new BinaryTreeNode(data);
	}
	
	public static void inOrder(BinaryTreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	public static void preOrder(BinaryTreeNode root){
		if(root != null){
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void postOrder(BinaryTreeNode root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
}