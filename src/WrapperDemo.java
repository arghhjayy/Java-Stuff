public class WrapperDemo {
	
	public static void changeValue(Integer value){
		value = 10;
	}
	
	public static void main(String[] args) {
		Integer i = 20;
		
		changeValue(i);
		
		System.out.println(i);
	}
}
