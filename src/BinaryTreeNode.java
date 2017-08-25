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
}