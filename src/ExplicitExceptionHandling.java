public class ExplicitExceptionHandling {
	public static void main(String[] args) throws Exception{
		try{
			throw new Exception("Shit");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Boy");
		}
	}
}
