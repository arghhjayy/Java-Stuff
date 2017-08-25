/**
 *
 * @author arghhjayy
 */

public class gcd {
	public static int getGCD(int x, int y)
	{
		if(x == 0)
			return y;
		else if(y == 0)
			return x;
		else
			return getGCD(y, x % y);
	}
	
	public static void main(String[] args) {
		System.out.println(getGCD(2, 12));
	}
}