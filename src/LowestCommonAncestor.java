/**
 *
 * @author arghhjayy
 */

public class LowestCommonAncestor {
	
	public static void addNode(BinaryTreeNode root, int data)
	{
		if(root.data > data)
			if(root.left != null)
				addNode(root.left, data);
			else
				root.left = new BinaryTreeNode(data);
		else
			if(root.right != null)
				addNode(root.right, data);
			else
				root.right = new BinaryTreeNode(data);
	}
	
	public static BinaryTreeNode getLCA(BinaryTreeNode root, int data1, int data2)
	{
		if(root == null)
			return null;
		
		if(root.data > data1 && root.data < data2)
			return root;
		else
			if(root.data > data1 && root.data > data2)
				return getLCA(root.left, data1, data2);
			else
				return getLCA(root.right, data1, data2);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		addNode(root, 6);
		addNode(root, 4);
		addNode(root, 3);
		addNode(root, 10);
		addNode(root, 7);
		addNode(root, 21);
		addNode(root, 2);
		addNode(root, 1);
		
		BinaryTreeNode lca;
		lca = getLCA(root, 7, 21);
		System.out.println(lca.data);
	}
}
