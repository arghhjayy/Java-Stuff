
import java.util.LinkedList;

/**
 *
 * @author arghhjayy
 */

public class LevelOrderTraversal {
	
	public static void levelOrderTraversal(BinaryTreeNode root)
	{
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			BinaryTreeNode popped = queue.poll();
			
			System.out.print(popped.data + " ");
			
			if(popped.left != null)
				queue.offer(popped.left);
			if(popped.right != null)
				queue.offer(popped.right);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right = new BinaryTreeNode(3);
		
		levelOrderTraversal(root);
		
		System.out.println();
	}
}
