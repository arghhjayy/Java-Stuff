class Parent{
	public void speak(){
		System.out.println(" kjdjfds\rfjadkf");
	}
}

class Child extends Parent{
	public void speak(){
		super.speak();
	}
}

class Caller{
	public static void main(String[] args) {
		Child c = new Child();
		c.speak();
	}
}