
import java.util.*;

//Given a binary tree, print it vertically

//E. g. :    1
//        /    \
//       2      3
//      / \    / \
//     4   5  6   7
//             \   \
//              8   9 

//Output: 
//	4
//	2
//	1 5 6
//	3 8
//	7
//	9

//We use the concept of Horizontal distance
//Horizontal distance is the horizontal distance between the root node and the child nodes
//It is calculated as follows:
//1) For right child, +1 is added to the current horizontal distance i. e. the horizontal distance upto the root node
//2) For left child, -1 is added to the current horizontal distance i. e. the horizontal distance upto the root node

public class PrintBinaryTreeVertically {
	
	public static void getVertical(BinaryTreeNode root, int hd, Map<Integer, ArrayList<Integer>> map){
		if(map.containsKey(hd))
				map.get(hd).add(root.data);
		else
			map.put(hd, new ArrayList(Arrays.asList(root.data)));
		if(root.left != null)
		{
			getVertical(root.left, hd - 1, map);
		}
		if(root.right != null)
		{
			getVertical(root.right, hd + 1, map);
		}
	}
	
	public static void printVertically(BinaryTreeNode root){
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		
		int hd = 0; //Horizontal distance for root node
		
		map.put(hd, new ArrayList(Arrays.asList(root.data)));
		
		getVertical(root.left, hd - 1, map);
		
		getVertical(root.right, hd + 1, map);
		
		for(Map.Entry entry : map.entrySet()){
			String value = entry.getValue().toString().replace("[", "").replace("]", "");
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.left.right = new BinaryTreeNode(8);
		root.right.right.right = new BinaryTreeNode(9);
		
		printVertically(root);
	}
}
