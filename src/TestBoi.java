public class TestBoi {
	
	public int real;
	public int imaginary;
	
	public String toString(){
		if(imaginary >= 0)
			return (real + " + ") + imaginary + "j"; 
		else
			return (real + " - ") + -imaginary + "j"; 
	}
	
	TestBoi(int real, int imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public static TestBoi add(TestBoi one, TestBoi two){
		return new TestBoi(one.real + two.real, one.imaginary + two.imaginary);
	}
	
	public static void main(String[] args) {
		TestBoi t = new TestBoi(1, -2);
		TestBoi s = new TestBoi(5, -5);
		TestBoi r = add(t, s);
		System.out.println(r);
		
	}
}