//스레드 생성과 실행(1)Thread 클래스를 상속하는 방법 (0부터 10까지 카운트하는 스레드) 
package thread;
class MyThread extends Thread{
	public void run() {
		for (int i=0; i <= 10; i++)
			System.out.print(i+" ");
	}
}


public class MyThreadTest {
	public static void main(String args[]) {
		Thread t = new MyThread();
		t.start();
	}
}


// 1. Thread를 상속받아서 클래스를 작성한다.
// 2. run() 메소드를 재정의한다 - 스레드가 실행하는 모든 작업은 이 run 메소드 안에 있어야 한다. 
// 3. 자식클래스의 인스턴스를 생성한다.
// 4. start()를 호출하여 스레드를 시작한다.