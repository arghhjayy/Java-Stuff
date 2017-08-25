
import java.util.Stack;

/**
 *
 * @author arghhjayy
 */

class SpecialQueue
{
	Stack<Integer> pushStack;
	Stack<Integer> popStack;
	
	SpecialQueue()
	{
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}
	
	public void enqueue(int x)
	{
		pushStack.push(x);
	}
	
	public int dequeue()
	{
		while(!pushStack.isEmpty())
		{
			int ele = pushStack.pop();
			popStack.push(ele);
		}
		
		int res;
		if(!popStack.isEmpty())
			res = popStack.pop();
		else
			res = -1;
		
		while(!popStack.isEmpty())
		{
			int ele = popStack.pop();
			pushStack.push(ele);
		}
		
		return res;
	}
}

public class QueueUsingStacks {
	public static void main(String[] args) {
		SpecialQueue q = new SpecialQueue();
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
