//스레드 생성과 실행(2)Runnable 인터페이스를 구현하는 방법 (0부터 10까지 카운트하는 스레드)
package thread;
class MyRunnable0 implements Runnable{
	public void run(){
		for (int i = 0; i <= 10; i++) 
			System.out.print(i + " ");
	}
}

public class MyRunnable0Test {
	public static void main(String args[]) {
		Thread t = new Thread(new MyRunnable0());
		t.start();
	}
}

// 1. Runnable 인터페이스를 구현한 클래스를 작성
// 2. run() 메소드를 작성
// 3. Thread 객체를 생성하고 이때 myRunnable 객체를 인수로 전달
// 4. start()를 호출해서 스레드를 시작!