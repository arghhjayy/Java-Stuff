
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arghhjayy
 */

public class InfixToPostfix {
	
	//Returns true is the given character is an opeator otherwise false
	public boolean isOperator(char ch)
	{
		return (ch == '*' || ch == '+' || ch == '-' || ch == '/' || ch == '^');
	}
	
	//Returns the priority of the operators
	public int priority(char operator)
	{
		if (operator == '^')
			return 5;
		else if(operator == '/')
			return 4;
		else if(operator == '*')
			return 3;
		else if(operator == '+')
			return 2;
		else if(operator == '-')
			return 1;
		else
			return -1;
	}
	
	public String infixToPostFix(String exp)
	{
		Stack stack = new Stack(); //Stores the operators and opening brackets
		String res = ""; //The output Postfix string
		
		//Iterate over the string once
		for(int i = 0; i < exp.length(); i++)
		{
			char a = exp.charAt(i); //a becomes the ith character
			
			//if a is an operand, add it to the output postfix string
			if(!isOperator(a) && a != '(' && a != ')')
				res += (a + "");
			else
			{
				//if a is an opening parenthesis, push it to the stack
				if(a == '(')
					stack.push('(');
				
				//If a is a closing parenthesis, pop the stack and add the popped
				//stuff to the output postfix string
				else if(a == ')')
				{
					while(!stack.isEmpty() && ((char)stack.peek() != '('))
					{
						char popped = (char) stack.pop();
						res += (popped + "");
					}
					stack.pop();
				}
				
				//If a is an operator
				else
				{
					//If a's priority is bigger than the priority of stack's top,
					//push a to the stack
					if(!stack.isEmpty() && (priority(a) > priority((char) stack.peek())))
						stack.push(a);
					
					//Else, pop the operators from the stack until the stack's
					//top's priority becomes less than the priority of a
					else
					{
						while(!stack.isEmpty() && (priority(a) <= priority((char) stack.peek())))
						{
							char popped = (char) stack.pop();
							res += (popped + "");
						}
						
						//Finally, when the priority of stack top is less than
						//a's, push a to the stack
						stack.push(a);
					}
				}
			}
		}
		
		//Now that all the elements are scanned, pop successively and add the
		//popped stuff to the output postfix string
		while(!stack.isEmpty())
		{
			char popped = (char) stack.pop();
			res += (popped + "");
		}
		
		//Return the string
		return res;
	}
	
	public static void main(String[] args) {
		InfixToPostfix obj = new InfixToPostfix();
		String infixExpr = "(1+2)*(3-4)";
		String postfixExpr = obj.infixToPostFix(infixExpr);
		System.out.println(postfixExpr);
	}
}
