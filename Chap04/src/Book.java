
public class Book {
	
	String title;
	String author;
	int isbn;
	
	public Book() {
		this(null, null, 0);	// 세 번째 생성자 호출
		System.out.println("기본 생성자");
	}
	
	public Book(String title, int isbn) {
		this(title, "Anonymous", isbn);	// 세 번째 생성자 호출
		System.out.println("인자 2개짜리 생성자");
	}
	
	public Book(String title, String author, int isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		System.out.println("인자 3개짜리 생성자");
	}
	
	
	
	public static void main(String[] args) {
		
//		Book a = new Book("Java", "BIT", 1234);
//		Book b = new Book("Holy Bible", 1);
		Book c = new Book();
		
	}
	
}
