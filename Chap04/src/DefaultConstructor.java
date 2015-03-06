
public class DefaultConstructor {
	
	int a;
	int j;
	
//	public DefaultConstructor() {}
	
	public DefaultConstructor(int x) {
		this.a = x;
	}
	
	void doSomething() {
		
	}
	
	public static void main(String[] args) {
		
		DefaultConstructor d = new DefaultConstructor(1);
		
	}
	
}
