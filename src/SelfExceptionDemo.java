public class SelfExceptionDemo {
	public static void main(String[] args) throws SelfException {
		try{
			throw new SelfException("We damned");
		}
		catch(SelfException e){
			System.out.println("Welcome to The Rice Fields");
			System.out.println(e.message);
		}
	}
}
