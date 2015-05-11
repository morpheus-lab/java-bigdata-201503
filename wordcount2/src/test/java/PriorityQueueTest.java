import java.util.PriorityQueue;


public class PriorityQueueTest {
	
	public static class Item implements Comparable<Item> {

		private int value;
		
		public Item(int value) {
			this.value = value;
		}
		
		public int compareTo(Item o) {
			/*
			 * 음수: 현재 객체가 o 객체 보다 앞선다
			 * 0: 현재 객체와 o 객체가 같은 순위를 갖는다
			 * 양수: 현재 객체가 o 객체 보다 뒤선다
			 */
			return (o.value - value);	// => value가 작은 것이 앞선다
		}
		
		@Override
		public String toString() {
			return "<" + value + ">";
		}
		
	}
	
	public static void main(String[] args) {
		
		PriorityQueue<Item> queue = new PriorityQueue<Item>();
		
		queue.add(new Item(3));
		queue.add(new Item(5));
		queue.add(new Item(1));
		queue.add(new Item(7));
		
		while (queue.size() > 0) {
			System.out.println(queue.remove().toString() + " ");
		}
		
	}
	
}
