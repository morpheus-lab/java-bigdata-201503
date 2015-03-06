package inheritance.privatemember;

public class Test {
	
	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		
		a.p = 5;	// public -> OK
//		a.n = 5;	// private -> Error
		
		b.p = 8;	// public -> OK
//		b.n = 8;	// private -> Error
		b.setN(8);	// public -> OK
		int i = b.getN();
		System.out.println(i);
		
//		b.m = 20;	// private -> Error
		b.setM(20);	// public -> OK
		System.out.println(b.toString());
	}
	
}
