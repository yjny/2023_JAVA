package Array;

public class Book {
	private String bookName;
	private String author;
	
	public Book() {} //디폴트 생성자
	
public Book(String bookName, String author){
	this.bookName = bookName;
	this.author = author;
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public void setAuthor(String author) {
	this.author = author;
}

public void showBookInfo() {
	System.out.println(bookName + "," + author);
	}	//책 정보를 출력해주는 메서드
}