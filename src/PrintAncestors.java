
import java.util.Scanner;

/**
 *
 * @author arghhjayy
 */

public class PrintAncestors {
	
	public static void printTheAncestors(BinaryTreeNode root, int key)
	{
		if(root == null) return;
		
		if(covers(root, key)) {
			if(key != root.data)
				System.out.println(root.data + " ");
		}
		
		printTheAncestors(root.left, key);
		printTheAncestors(root.right, key);
	}
	
	public static boolean covers(BinaryTreeNode root, int data)
	{
		if(root == null) return false;
		
		else if(root.data == data) return true;
		
		else return ((covers(root.left, data)) || covers(root.right, data));
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
		
		System.out.println("Enter the key:");
		Scanner scanner = new Scanner(System.in);
		int key = scanner.nextInt();
		printTheAncestors(root, key);
	}
}
