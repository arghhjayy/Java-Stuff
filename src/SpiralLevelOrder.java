
import java.util.Stack;

/**
 *
 * @author arghhjayy
 */

public class SpiralLevelOrder {
	
	public static void spiralLevelOrder(BinaryTreeNode root)
	{
		
		//leftToRightStack actually prints the elements in a Right to left manner
		//while rightToLeftStack actually prints the elemtns in a left to  right manner
		//Naming was accidentally done opposite
		
		Stack<BinaryTreeNode> rightToLeftStack = new Stack<>();
		Stack<BinaryTreeNode> leftToRightStack = new Stack<>();
		
		leftToRightStack.push(root);
		
		while(!rightToLeftStack.isEmpty() || !leftToRightStack.isEmpty())
		{
			while(!leftToRightStack.isEmpty())
			{
				BinaryTreeNode temp = leftToRightStack.pop();
				
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					rightToLeftStack.push(temp.right);
				
				if(temp.right != null)
					rightToLeftStack.push(temp.left);
			}
			
			while(!rightToLeftStack.isEmpty())
			{
				BinaryTreeNode temp = rightToLeftStack.pop();
				
				System.out.print(temp.data + " ");
				
				if(temp.right != null)
					leftToRightStack.push(temp.right);
				
				if(temp.left != null)
					leftToRightStack.push(temp.left);
			}
		}
	}
	
	public static void inOrder(BinaryTreeNode root)
	{
		if(root != null)
		{
			inOrder(root.left);
			System.out.println(root.data + " ");
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		
		root.left.left = new BinaryTreeNode(7);
		root.left.right = new BinaryTreeNode(6);
		
		root.right.left = new BinaryTreeNode(5);
		root.right.right = new BinaryTreeNode(4);
		
		spiralLevelOrder(root);
		
		System.out.println();
	}
}
