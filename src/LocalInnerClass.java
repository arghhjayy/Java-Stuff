class MethodOuterClass{
	int h = 2;
	
	public void dostuff(){
		System.out.println("SHit");
		
		class MethodInnerClass{
			public void doshit(){
				System.out.println(h);
				System.out.println("do shit");
			}
		}
		
		MethodInnerClass mic = new MethodInnerClass();
		mic.doshit();
	}
	
	public static void main(String[] args) {
		MethodOuterClass moc = new MethodOuterClass();
		moc.dostuff();
	}
}