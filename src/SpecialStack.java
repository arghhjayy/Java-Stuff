import java.util.Stack;

/*
Design a data-structure SpecialStack (using the STL of stack) 
that supports all the stack operations
like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
which should return minimum element from the SpecialStack.
Your task is to complete all the functions, using stack data-Structure.
*/

public class SpecialStack {
	Stack<Integer> original_stack = new Stack<>();
	Stack<Integer> auxiliary_stack = new Stack<>();
	
	public void push(int x)
	{
		if(original_stack.isEmpty()){
			original_stack.push(x);
			auxiliary_stack.push(x);
		}
		else
		{
			original_stack.push(x);
			auxiliary_stack.push(x < auxiliary_stack.peek()? x : auxiliary_stack.peek());
		}
	}
	
	public int pop()
	{
		auxiliary_stack.pop();
		return original_stack.pop();
	}
	
	public int getMin()
	{
		return auxiliary_stack.peek();
	}
	
	public static void main(String[] args) {
		SpecialStack s = new SpecialStack();
		s.push(1);
		s.push(5);
		s.push(-1);
		s.push(6);
		s.push(10);
		System.out.println(s.getMin());
	}
}
