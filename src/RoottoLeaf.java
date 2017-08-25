
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author arghhjayy
 */

public class RoottoLeaf {
	
	public static void printArrayList(ArrayList<Integer> arrayList)
	{
		for(int item : arrayList)
			System.out.print(item + " ");
		System.out.println();
	}
	
	public static boolean isLeaf(BinaryTreeNode node)
	{
		return node.left == null && node.right == null;
	}
	
	public static void rootToLeaf(BinaryTreeNode root, ArrayList<Integer> arr)
	{
		if(root == null) {
			return;
		}
				
		arr.add(root.data);
		
		if(isLeaf(root))
			printArrayList(arr);
		else
		{
			rootToLeaf(root.left, new ArrayList<Integer>(arr));
			rootToLeaf(root.right, new ArrayList<Integer>(arr));
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(2);
		
		//Google "binary tree".. first photo
		
		//Fill left side
		root.addLeft(7);
		root.left.addLeft(2);
		root.left.addRight(6);
		root.left.right.addLeft(5);
		root.left.right.addRight(11);
		
		//Fill right side
		root.addRight(5);
		root.right.addRight(9);
		root.right.right.addLeft(4);
		
		ArrayList<Integer> arr = new ArrayList<>();

		rootToLeaf(root, arr);
	}
}
