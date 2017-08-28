/*
Given a binary tree, your task is to complete the function
verticalOrder which takes one argument the root of the binary
tree and prints the node of the binary tree in vertical order.
*/

/*
Strategy:
First, we calculate the minimum and maximum horizontal distances from the root.
Horizontal distance is the distance which one has to go through to get to
the node starting from the root
Horizontal distances for nodes in the left hand side of the is taken in negative
sign and similarly for right hand side, positive just like in the number line.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 

For the above binary tree, the horizontal distance of 4 is -2 since it
takes two unit of distance to go to 4 starting with 1
Similary horizontal distance of 9 is +3.

After calculating the minimum and maximum value for the horizontal distances,
we go from the minimum horizontal distance to the maximum and print every node
that lies in the same horizontal distance line
*/

class Value{
	int value;
}

public class VerticalTreePrint {
	
	public static void calculateMinMax(BinaryTreeNode root, Value min, Value max, int hd){
		//If tree is empty, do nothing
		if(root == null)
			return;
		
		//If the current horizontal distance is less than the minimum horizontal
		//distance caluclated so far, change it to current
		min.value = Math.min(min.value, hd);
		
		//If the current horizontal distance is greater than the maximum 
		//horizontal distance caluclated so far, change it to current
		max.value = Math.max(max.value, hd);
		
		//Recur for left and right nodes
		//With
		//Horizontal distance one less than the current
		calculateMinMax(root.left, min, max, hd - 1);
		//Horizontal distance one more than the current
		calculateMinMax(root.right, min, max, hd + 1);
	}
	
	//This function prints a line at a particular horizontal distance
	//and ignores others
	public static void printVerticalLine(BinaryTreeNode root, int line_no, int hd){
		if(root == null)
			return;
		
		//Print the nodes which are at the same hd
		if(hd == line_no)
			System.out.print(root.data + " ");
		
		//Recur for children
		printVerticalLine(root.left, line_no, hd - 1);
		printVerticalLine(root.right, line_no, hd + 1);
	}
	
	public static void printVerticalTree(BinaryTreeNode root){
		//Create minimum and maximum
		Value min = new Value();
		Value max = new Value();
		
		//Calculate minimum and maximum
		calculateMinMax(root, min, max, 0);
		
		//Now min and max have the minimum and maximum horizontal distances
		//in them
		
		//Now the printing part
		//For every horizontal distance, starting from the minimum
		for(int line_no = min.value; line_no <= max.value; line_no++){
			printVerticalLine(root, line_no, 0);
			System.out.println();
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
		root.right.right.right = new BinaryTreeNode(8);
		
		printVerticalTree(root);
	}
}
