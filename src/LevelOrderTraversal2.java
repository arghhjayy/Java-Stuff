
import java.util.LinkedList;

/**
 *
 * @author arghhjayy
 */

public class LevelOrderTraversal2 {
	
	public static void levelOrderTraversal2(BinaryTreeNode root)
	{
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			int nodeCount = queue.size();
			
			while(nodeCount-- > 0)
			{
				BinaryTreeNode popped = queue.poll();
				System.out.print(popped.data + " ");
				if(popped.left != null)
					queue.offer(popped.left);
				if(popped.right != null)
					queue.offer(popped.right);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.left.right.left = new BinaryTreeNode(7);
		root.left.right.right = new BinaryTreeNode(8);
		
		root.right = new BinaryTreeNode(3);
		root.right.right = new BinaryTreeNode(6);
		root.right.right.left = new BinaryTreeNode(9);
		
		levelOrderTraversal2(root);
		
		System.out.println();
	}
}
