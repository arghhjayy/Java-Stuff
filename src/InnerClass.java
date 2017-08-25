class OuterClass{
	int shit;
	
	class InnerClass{
		public void show(){
			System.out.println("Show");
		}
	}
	
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		InnerClass ic = oc.new InnerClass();
		ic.show();
	}
}