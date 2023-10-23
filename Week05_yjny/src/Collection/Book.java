package Collection;	//Week05_03 (1/2) 

public class Book {
	private int BookId;
	private String BookName;
	
	public Book(int BookId, String BookName) {
		this.BookId = BookId;
		this.BookName = BookName;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int BookId) {
		this.BookId = BookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String setBookName) {
		this.BookName = BookName;
	}
	
	@Override
	public String toString() {
		return BookName + "도서의 아이디는 " + BookId + "입니다";
	}
}
