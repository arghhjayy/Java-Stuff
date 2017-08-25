import java.util.Stack;

public class InOrderTraversal {
	
	public static void inOrder2(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> stack = new Stack<>();
				
		BinaryTreeNode current = root;
		
		while(current != null)
		{
			stack.push(current);
			current = current.left;
		}
				
		while(!stack.isEmpty())
		{
			current = stack.pop();
			
			System.out.print(current.data + " ");
			if(current.right != null){
				current = current.right;
				
				while(current != null)
				{
					stack.push(current);
					current = current.left;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right = new BinaryTreeNode(3);
		
		inOrder2(root);
		
		System.out.println();
	}
}
