//예제16-2: 그래픽 버전 카운터 만들어보기 (0부터 10까지 1초 단위로 카운트하는 애플리케이션)
//Thread 클래스가 가지고 있는 정적 메소드 sleep(millisec) : 밀리초 단위의 시간만큼 현재 스레드의 실행을 잠재운다.
//스윙 컴포넌트를 사용하여 그래픽 모드로 작성하자.
package thread;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

//CountDownTest 클래스 정의
public class CountDownTest extends JFrame {
	private JLabel label;
	
	//Thread를 상속받는 내부클래스 MyThread 정의
	class MyThread extends Thread {
		public void run() {
			for (int i = 0; i <= 10; i++) {
				//1부터 10까지 반복
				//sleep(): 도중에 예외 InterruptedException 이 발생할 수 있다. try-catch 블록으로 처리!
				try {
					Thread.sleep(1000); //스레드 실행을 1초간 멈춘다
				}catch (InterruptedException e) {
					e.printStackTrace(); //예외가 발생하면 스택 트레이스 정보를 출력해주는 메소드
				}
				label.setText(i+""); //1초가 지나가면 레이블의 텍스트를 변경한다.
			}
		}
	}
	
	//CountDownTest 클래스의 생성자
	public CountDownTest() {
		setTitle("카운트다운"); //프레임 제목 설정
		setSize(400, 150); //프레임 크기 설정
		label = new JLabel("start"); //텍스트를 띄우는 레이블 
		label.setFont(new Font("Serif", Font.BOLD, 100)); //폰트, 굵게, 글자크기 지정
		add(label); //레이블 추가
		setVisible(true); //화면에 보이게 함
		(new MyThread()).start(); //MyThread 클래스의 객체를 생성하고 스레드를 실행한다.
		
	}
	
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest(); //CountDownTest 클래스의 객체 생성->t라는 변수에 할당
	}
}
//결과적으로, CountDownTest 클래스의 객체가 생성되고, 이 객체를 t라는 변수에 할당합니다. 
//이렇게 하면 t 변수를 통해 객체에 접근하고 객체의 메서드를 호출하거나 속성에 접근할 수 있게 됩니다.
