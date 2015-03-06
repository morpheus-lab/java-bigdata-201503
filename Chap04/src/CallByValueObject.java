
public class CallByValueObject {
	
	public static void main(String[] args) {
		
		Person2 p = new Person2();
		
		MyInt a = new MyInt(33);
		
		p.setAge(a);
		
		System.out.println(a.val);
		
	}
	
}

class MyInt {
	int val;
	MyInt(int i) {
		val = i;
	}
}

class Person2 {
	private int age;
	
	public void setAge(MyInt i) {
		age = i.val;
		i.val++;
	}
}
