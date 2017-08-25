public class AddingPolynomialsLinkedList {
	
	public static void addPolynomials(PolynomialLinkedListNode root1, PolynomialLinkedListNode root2, PolynomialLinkedListNode res_head)
	{		
		PolynomialLinkedListNode curr1 = root1;
		PolynomialLinkedListNode curr2 = root2;
		
		while(curr1 != null && curr2 != null)
		{
//			System.out.println("Currently, curr1 is at " + curr1.data + "x^" + curr1.exponent);
//			System.out.println("and curr2 is at " + curr2.data + "x^" + curr2.exponent);
			if(curr1.exponent > curr2.exponent)
			{
				res_head.data = curr1.data;
				res_head.exponent = curr1.exponent;
				curr1 = curr1.next;
			}
			else if(curr1.exponent < curr2.exponent)
			{
				res_head.data = curr2.data;
				res_head.exponent = curr2.exponent;
				curr2 = curr2.next;
			}
			else
			{
				//System.out.println("Degree = " + curr2.exponent);
				res_head.data = curr2.data + curr1.data;
				res_head.exponent = curr1.exponent;
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			res_head.next = new PolynomialLinkedListNode();
			res_head = res_head.next;
			res_head.next = null;
		}
		
		while(curr1 != null || curr2 != null)
		{
			if(curr1 != null)
			{
				res_head.data = curr1.data;
				res_head.exponent = curr1.exponent;
				curr1 = curr1.next;
			}
			
			if(curr2 != null)
			{
				res_head.data = curr2.data;
				res_head.exponent = curr2.exponent;
				curr2 = curr2.next;
			}
			res_head.next = new PolynomialLinkedListNode();
			res_head = res_head.next;
			res_head.next = null;
		}
	}
	
	public static void printLinkedList(PolynomialLinkedListNode root)
	{
		PolynomialLinkedListNode curr = root;
		if(root == null)
			System.out.print("No elements");;
		while(curr != null)
		{
			if(!(curr.data == 0 && curr.exponent == 0))
				System.out.print(curr.data + "x^" + curr.exponent);
			curr = curr.next;
			if(curr != null && !(curr.data == 0 && curr.exponent == 0))
				System.out.print(" + ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		//Build first polynomial
		PolynomialLinkedListNode root1 = new PolynomialLinkedListNode(5, 2);
		root1.next = new PolynomialLinkedListNode(4, 1);
		
		//Build second polynomial
		PolynomialLinkedListNode root2 = new PolynomialLinkedListNode(5, 2);
		root2.next = new PolynomialLinkedListNode(9, 1);
		root2.next.next = new PolynomialLinkedListNode(5, 0);
		
		//Print first linked list
		printLinkedList(root1);
		
		//Print second linked list
		printLinkedList(root2);
		
		//Add them
		PolynomialLinkedListNode addedroot = new PolynomialLinkedListNode();
		
		addPolynomials(root1, root2, addedroot);
		
		//Print result
		printLinkedList(addedroot);
	}
}
