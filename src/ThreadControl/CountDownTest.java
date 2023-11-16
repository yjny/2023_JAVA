//예제16-4: 스레드 스케줄링 - Interrupted()의 사용법을 알아보는 간단한 예제
//앞에서 등장했던 그래픽 카운터 프로그램(예제16-2)을 수정
//옆의 '카운팅 중지'버튼을 누르면 0부터 10까지 세는 카운터가 중지되도록 한다.
package ThreadControl;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
	
	//CountDownTest 클래스
	public class CountDownTest extends JFrame {
		private JLabel label;
		Thread t; //추가
		
		// Counter 클래스 - for문을 이용해서 0~10까지의 텍스트를 출력하기
		class Counter extends Thread {
			public void run() {
				for (int i = 0; i <= 10; i++) {
	
					try {
						Thread.sleep(1000);
					}catch (InterruptedException e) {
						//여기서 리턴해서 스레드를 중지한다.
						return; 
					}
				
					label.setText(i+"");
				}
			}
		}
		
		//CounterTest 클래스의 생성자 정의
		public CountDownTest() {
			setTitle("카운트다운"); //프레임 제목
			setSize(400, 150); //프레임 크기
			getContentPane().setLayout(null); //절대위치배치관리자로 설정
			label = new JLabel("0"); //레이블을 텍스트 0으로 지정
			label.setBounds(0, 0, 384, 111); //텍스트 위치와 크기 
			label.setFont(new Font("Serif", Font.BOLD, 100)); //폰트
			getContentPane().add(label); //패널에 레이블 추가
			
			//버튼 추가하기
			JButton btnNewButton = new JButton("카운터 중지"); //버튼 생성
			btnNewButton.setBounds(247, 25, 125, 23); //버튼 위치와 크기
			
			//버튼을 누르면 스레드t가 중지되도록 함
			btnNewButton.addActionListener(e->t.interrupt()); 
			getContentPane().add(btnNewButton); 
			setVisible(true);
			t = new Counter(); //새로운 카운터 t 생성하기
			t.start(); //스레드 실행
			
			
		}
		
		public static void main(String[] args) {
			CountDownTest t = new CountDownTest();
		}
	}

//label.setBounds(int x, int y, int width, int height) 
	//x: 컴포넌트의 왼쪽 상단 모서리의 x 좌표를 나타냅니다.
	//y: 컴포넌트의 왼쪽 상단 모서리의 y 좌표를 나타냅니다.
	//width: 컴포넌트의 가로 크기를 픽셀 단위로 나타냅니다.
	//height: 컴포넌트의 세로 크기를 픽셀 단위로 나타냅니다.
