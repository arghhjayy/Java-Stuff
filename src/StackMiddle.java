/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arghhjayy
 */

/*
	Stack which gives the middle value in O(1) (Constant time):
	Implementing using Doubly Linked List
*/

class Node
{
	Node prev;
	int data;
	Node next;
	
	Node(int x)
	{
		prev = null;
		data = x;
		next = null;
	}
}

public class StackMiddle {
	Node head;
	Node mid;
	int count;
	
	StackMiddle()
	{
		head = null;
		mid = null;
		count = 0;
	}
	
	public void push(int x)
	{
		Node newNode = new Node(x);
		
		newNode.next = head;
		
		count++;
		
		if(count == 1)
		{
			mid = newNode;
		}
		else
		{
			head.prev = newNode;
			
			if(count % 2 != 0)
				mid = mid.prev;
		}
		
		head = newNode;
	}
	
	public int pop()
	{
		int toreturn = head.data;
		head = head.next;
		
		if(head != null){
			head.prev = null;
		}
		
		count -= 1;
		
		if(count % 2 == 0)
		{
			mid = mid.next;
		}
		
		return toreturn;
	}
	
	public int getMiddle()
	{
		return mid.data;
	}
	
	public void deleteMiddle()
	{
		if(count % 2 == 0)
		{
			count -= 1;
			mid = mid.prev;
		}
		else
		{
			count -= 1;
			mid = mid.next;
		}
	}
	
	public static void main(String[] args) {
		StackMiddle sm = new StackMiddle();
		sm.push(1);
		sm.push(2);
		sm.push(3);
		sm.push(4);
		sm.push(5);
		System.out.println(sm.getMiddle());
		sm.pop();
		sm.pop();
		System.out.println(sm.getMiddle());
	}
}
