public class ThrowsKeyword {
	public void message() throws Exception{
		throw new Exception("Boy");
	}
	
	public static void main(String[] args) {
		ThrowsKeyword tk = new ThrowsKeyword();
		try{
			tk.message();
		}
		catch(Exception e){
			System.out.println("Woah");
		}
	}
}
