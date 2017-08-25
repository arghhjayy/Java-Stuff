
import java.util.LinkedList;

/**
 *
 * @author arghhjayy
 */

public class GenerateBinaryStrings {
	
	public static void printBinaryStrings(int n)
	{
		LinkedList<String> queue = new LinkedList<>();
		
		queue.add("1");
		
		while(n-- > 0)
		{
			
			String s = queue.poll();
			System.out.println(s);
			
			queue.offer(s + "0");
			queue.offer(s + "1");
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		printBinaryStrings(n);
	}
}
