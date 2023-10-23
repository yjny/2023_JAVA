package Collection;	//Week05_03 (2/2)

import java.util.ArrayList;

public class BookArrayList {
	private ArrayList<Book> arrayList; //arrayList 선언
	
	public BookArrayList() {
		arrayList = new ArrayList<Book>(); //Book형으로 선언한 ArrayList 생성
	}
	
	public void addBook(Book book) { //Book데이터 추가
		arrayList.add(book);
	}
	
	public boolean removeBook(int BookId) {
		for (int i = 0; i < arrayList.size(); i++) {
			Book book = arrayList.get(i);
			int tempId = book.getBookId();
			if(tempId == BookId) {
				arrayList.remove(i);
				return true;	
			}
		}
		System.out.println(BookId + "가 존재하지 않습니다.");
		return false;
	}
	//어케하는건데 특정위치 삽입.
	public void insertBook(int BookId) { 
		for (int i=0; i < arrayList.size(); i++) {
			Book book = arrayList.get(i);
			int tempId = book.getBookId();
			if(tempId == BookId) {
				arrayList.add(book);
				
			}
		}
	}

	public void showAllBook() {
		for(Book book : arrayList) {
			System.out.println(book);
		}
		System.out.println();
	}
}
