
public class CallByValue {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		
		int a = 33;
		
		p.setAge(a);
		
		System.out.println(a);
	}
	
}

class Person {
	
	private int age;
	
	public void setAge(int n) {
		age = n;
		n++;
	}
	
}






















