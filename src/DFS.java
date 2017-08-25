import java.util.Stack;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class GraphNode
{
	int data;
	ArrayList<GraphNode> canGraphNodes;
	boolean visited;
	
	GraphNode(int data)
	{
		this.data = data;
		canGraphNodes = new ArrayList<>();
		visited = false;
	}
	
	public void addGraphNode(GraphNode toAdd)
	{
		canGraphNodes.add(toAdd);
	}
}

public class DFS {
	
	public static void doDFS(GraphNode startGraphNode)
	{
		Stack<GraphNode> stack = new Stack<GraphNode>();
		
		stack.push(startGraphNode);
		
		while(!stack.isEmpty())
		{
			GraphNode popped = stack.pop();
			
			for(GraphNode connected_node : popped.canGraphNodes) {
				if(!connected_node.visited)
					stack.push(connected_node);
			}

			if(!popped.visited)
			{
				popped.visited = true;
				System.out.println(popped.data);
			}
		}
	}
	
	public static void main(String[] args) {
		GraphNode zero = new GraphNode(0);
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		zero.addGraphNode(three);
		zero.addGraphNode(two);
		one.addGraphNode(zero);
		two.addGraphNode(one);
		three.addGraphNode(four);
		four.addGraphNode(zero);
		doDFS(zero);
	}
}
