package collections;

public class MyLinkedList<E> /*implements java.util.List<E>*/ {
	
	static class Node<E> {
		E element;
		Node<E> next;	// 리스트에서 이 노드 다음 노드의 참조값을 가지는 변수
	}
	
	Node<E> head;	// 리스트의 첫 번째 노드의 참조값을 가지는 변수
	
	public void add(E e) {
		Node<E> newNode = new Node<E>();
		newNode.element = e;
		
		// 첫 번째 데이터 삽입되는 경우
		if (head == null) {
			head = newNode;
		} else {
			// 마지막 노드를 찾아서 그 뒤에 이어 붙여야..
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			// while문을 벗어나면 current는 마지막 노드를 가리킴
			current.next = newNode;
		}
	}
	
	public void add(int index, E e) {	// 새로운 데이터를 index 위치에 삽입
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (isEmpty()) {
			if (index == 0) {
				// 새 데이터를 리스트의 첫 번째 위치에 삽입
				Node<E> newNode = new Node<E>();
				newNode.element = e;
				head = newNode;
			} else {
				throw new ArrayIndexOutOfBoundsException(index);// 예외 객체를 add 메소드를 호출한 곳으로 던짐
			}
		} else {
			try {
				Node<E> prevIthNode = head;
				for (int j = 0; j < index - 1; j++) {
					prevIthNode = prevIthNode.next;
				}
				// prevIthNode는 (index - 1) 위치의 노드
				
				Node<E> ithNode = prevIthNode.next;	// 기존의 index 번째 노드
				
				// 새 데이터 노드를 만들어서 (index - 1)과 (index) 사이에 삽입
				Node<E> newNode = new Node<E>();
				newNode.element = e;
				
				// index - 1의 next를 새 노드로
				prevIthNode.next = newNode;
				// 새 노드의 next를 기존의 index 노드로
				newNode.next = ithNode;
			} catch (NullPointerException ex) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
		}
	}
	
	public boolean isEmpty() {
		return head == null;	// head가 null이면 리스트가 비어 있는 것
	}
	
	public E get(int i) {
		if (i < 0) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		if (isEmpty()) {	// 리스트가 비어있다는 얘기
//			throw new NoSuchElementException();
			throw new ArrayIndexOutOfBoundsException(i);
		} else {
			try {
				Node<E> ithNode = head;
				for (int j = 0; j < i; j++) {
					ithNode = ithNode.next;
				}
				return ithNode.element;
			} catch (NullPointerException e) {	// NullPointException이 발생한 경우도 잘못된 인덱스에 접근한 것
				throw new ArrayIndexOutOfBoundsException(i);
			}
		}
	}
	
	public int size() {	// 리스트에 저장된 데이터가 몇개인지?
		if (isEmpty()) {
			return 0;
		}
		
		int count = 1;
		Node<E> current = head;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
}

















