public class PrintReducedString {
	public static void printReduced(String string)
	{
		if(string.isEmpty()) return;
		boolean flag = false;
		char buffer = string.charAt(0);
		System.out.print(buffer);
		
		for(int i = 1; i < string.length(); i++)
		{
			if(string.charAt(i) != buffer)
			{
				System.out.print(string.charAt(i));
				buffer = string.charAt(i);
			}
		}
	}
	
	public static void main(String[] args) {
		String string = "looooooooooooooooooooooool";
		printReduced(string);
		System.out.println();
	}
}
