//예제16-1: 스레드 2개 만들어보기
//Runnable 인터페이스를 구현하는 방법으로 스레드를 생성하고 실행한다.
package thread; 
class MyRunnable1 implements Runnable{
	String myName;
	public MyRunnable1(String name) {	myName = name;}
	public void run() {
		for (int i = 0; i <= 10; i++) 
			System.out.print(myName + i + " ");
		
	}
}
public class TestThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable1("A"));
		Thread t2 = new Thread(new MyRunnable1("B"));
		t1.start();
		t2.start();
	}
}

//스레드를 구분하기 위해 이름을 설정한다.
//이름이 "A", "B"인 스레드 2개를 생성하고 시작한다.
//2개의 스레드가 실행되면서 스레드의 출력이 섞이는 것을 볼 수 있다.