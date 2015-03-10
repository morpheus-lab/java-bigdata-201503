package generics;

class Storage<E, T> {
	private E element;
	private T element2;
	
	public Storage(E element) {
		this.element = element;
	}
	
	public E getElement() {
		return element;
	}
}

public class GenericsTest {
	
	public static void main(String[] args) {
		
		Storage<String, Integer> st1 = new Storage<String, Integer>("1");
		Storage<Integer, Double> st2 = new Storage<Integer, Double>(3);
		Storage st3 = new Storage("2");
		
		String s = st1.getElement();
		Integer i = st2.getElement();
	}
	
}
