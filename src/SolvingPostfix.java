
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
public class SolvingPostfix {
	
	public static int apply(int first, int second, char operator)
	{
		if(operator == '*')
			return first * second;
		else if(operator == '-')
			return first - second;
		else if(operator == '+')
			return first + second;
		else if(operator == '/')
			return first / second;
		else if(operator == '^')
			return (int) Math.pow(first, second);
		return -1;
	}
	
	public static int solvePostfix(String exp)
	{
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < exp.length(); i++)
		{
			char scanned = exp.charAt(i);
			if(Character.isDigit(scanned)) {
				stack.push(Character.getNumericValue(scanned));
			} else
			{
				int first = stack.pop();
				int second = stack.pop();
				int result = apply(second, first, scanned);
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String infixExpr = "(3+3)/(1+1)";
		InfixToPostfix obj = new InfixToPostfix();
		String postfixExpr = obj.infixToPostFix(infixExpr);
		System.out.println("Result = " + solvePostfix(postfixExpr));
	}
}
