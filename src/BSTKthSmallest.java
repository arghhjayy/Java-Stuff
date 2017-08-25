import java.util.Stack;

public class BSTKthSmallest {

	public static void addNode(BinaryTreeNode root, int data) {
		if (root.data > data) {
			if (root.left != null) {
				addNode(root.left, data);
			} else {
				root.left = new BinaryTreeNode(data);
			}
		} else {
			if (root.right != null) {
				addNode(root.right, data);
			} else {
				root.right = new BinaryTreeNode(data);
			}
		}
	}

	public static BinaryTreeNode kthSmallest(BinaryTreeNode root, int k) {
		Stack<BinaryTreeNode> stack = new Stack<>();

		BinaryTreeNode curr = root;

		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}

		curr = stack.pop();
		while (curr != null) {
			k--;
			if (k == 0) {
				break;
			}

			if (curr.right != null) {
				
				curr = curr.right;
				
				while (curr != null) {
					stack.push(curr);
					curr = curr.left;
				}
			}
			curr = stack.pop();
		}

		return curr;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		addNode(root, 6);
		addNode(root, 4);
		addNode(root, 3);
		addNode(root, 10);
		addNode(root, 7);

		System.out.println(kthSmallest(root, 3).data);

		System.out.println();
	}
}
