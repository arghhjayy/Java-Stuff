
import java.util.ArrayList;

/**
 *
 * @author arghhjayy
 */

public class UnionAndIntersection {
	public static ArrayList<Integer> union(ArrayList<Integer> a1, ArrayList<Integer> a2)
	{
		int i = 0, j = 0;
		ArrayList<Integer> result = new ArrayList<>();
		while(i != a1.size() && j != a2.size())
		{
			if(a1.get(i) < a2.get(j))
			{
				result.add(a1.get(i));
				i++;
			}
			else if(a1.get(i) > a2.get(j))
			{
				result.add(a2.get(j));
				j++;
			}
			else
			{
				result.add(a1.get(i));
				i++; j++;
			}
		}
		
		if(i != a1.size())
		{
			while(i != a1.size())
			{
				result.add(a1.get(i));
				i++;
			}
		}
		
		if(j != a2.size())
		{
			while(j != a2.size())
			{
				result.add(a2.get(j));
				j++;
			}
		}
		
		return result;
	}
	
	public static ArrayList<Integer> intersection(ArrayList<Integer> a1, ArrayList<Integer> a2){
		ArrayList<Integer> result = new ArrayList<>();
		
		int i = 0, j = 0;
		
		while(i < a1.size() && j < a2.size())
		{
			if(a1.get(i) < a2.get(j))
			{
				i++;
			}
			else if(a1.get(i) > a2.get(j))
				j++;
			else
			{
				result.add(a1.get(i));
				i++;j++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		
		a1.add(1);
		a1.add(3);
		a1.add(4);
		a1.add(5);
		a1.add(7);
		
		ArrayList<Integer> a2 = new ArrayList<>();
		
		a2.add(2);
		a2.add(3);
		a2.add(5);
		a2.add(6);
		
		System.out.println("First: " + a1);
		System.out.println("Second: " + a2);
		
		ArrayList<Integer> unioned = union(a1, a2);
		System.out.println(unioned);
		
		ArrayList<Integer> intersectioned = intersection(a1, a2);
		System.out.println(intersectioned);
	}
}
