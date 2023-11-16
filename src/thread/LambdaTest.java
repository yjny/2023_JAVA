//람다식을 이용한 스레드 작성 (0부터 10까지 카운트하는 스레드)
package thread;
public class LambdaTest {
	public static void main(String args[]) {
		
		// Runnable 객체 생성 및 람다식 사용
		Runnable task = () -> {		//Runnable 인터페이스를 구현하는 task 정의하기(run 메소드처럼 사용됨)
			for (int i=0; i<=10; i++)	
				System.out.print(i + " "); //0부터 10까지의 정수를 공백으로 구분해서 출력
		};
		
		// Runnable 객체를 이용하여 스레드 생성 및 시작
		new Thread(task).start(); // task를 실행하는 새로운 스레드를 생성하고 시작한다.
	}
}

//'Runnable task = () -> {'	: Runnable 인터페이스를 구현하는 task라는 람다식을 정의
//Runnable 인터페이스: 스레드를 실행할 수 있는 객체를 나타내는 인터페이스입니다. 
//람다식 '() -> { ... }'을 사용하여 run 메서드를 구현한 것처럼 동작합니다.
//new Thread(task).start();: 위에서 생성한 task를 실행하는 새로운 스레드를 생성하고 시작합니다. 
//start() 메서드를 호출하면 스레드가 task에 정의된 내용을 실행하게 됩니다.
