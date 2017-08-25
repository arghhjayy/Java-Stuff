import java.util.LinkedList;

public class BFS {
	
	public static void doBFS(GraphNode startNode)
	{
		LinkedList<GraphNode> q = new LinkedList<>();
		
		q.offer(startNode);
		
		while(!q.isEmpty())
		{
			GraphNode front = q.poll();
			
			if(!front.visited)
			{
				System.out.print(front.data + " ");
				front.visited = true;
			}
			
			for(GraphNode g : front.canGraphNodes)
				if(!g.visited)
					q.offer(g);
		}
	}
	
	public static void main(String[] args) {
		GraphNode zero = new GraphNode(0);
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		zero.addGraphNode(one);
		zero.addGraphNode(two);
		one.addGraphNode(two);
		two.addGraphNode(zero);
		two.addGraphNode(three);
		three.addGraphNode(three);
		doBFS(two);
		System.out.println();
	}
}
