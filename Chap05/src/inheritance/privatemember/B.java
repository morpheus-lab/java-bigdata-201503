package inheritance.privatemember;

public class B extends A {
	
	// A로부터 상속받는 멤버
	// public int p;
	// private int n;
	// public void setN(...){...}
	// public int getN() {...}
	
	// B 만의 추가 멤버
	
	// <Alt>+<Shift>+S, R => 이클립스의 Generate Getters and Setters 기능 활용
	
	private int m;

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
	
	public String toString() {
		return getN() + " " + getM();
	}
	
	public void incN() {
//		n++; // 물려받은 private 멤버에도 접근 불가
	}
	
}
