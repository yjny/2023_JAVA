//Lab: 자동차 경주 게임 만들기 (3대의 자동차를 각각 무작위로 이동시키는 프로그램) 
//3대의 자동차는 이미지를 나타내는 3개의 레이블로 구현된다.
//스레드를 사용해서 0.1초에 한번씩 난수값만큼 자동차의 위치를 변경해보자.
package cargame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class CarGame extends JFrame{
	// 내부 클래스 MyThread를 정의, 각각의 스레드가 하나의 자동차를 나타냄
	class MyThread extends Thread{		//하나의 스레드가 하나의 자동차를 나타냄!
		private JLabel label;
		private int x, y; 
		
		// MyThread 클래스의 생성자: 이미지 파일 경로와 초기 위치를 받아서 레이블을 생성함
		public MyThread(String fname, int x, int y) {
			this.x = x; //x = 자동차 이미지 왼쪽 상단 모서리의 x좌표
			this.y = y; //y = 자동차 이미지 왼쪽 상단 모서리의 y좌표
			label = new JLabel(); //레이블 생성
			label.setIcon(new ImageIcon(fname)); 
			label.setBounds(x, y, 100, 100); // 레이블의 위치 업데이트 및 크기 설정
			add(label); // 레이블을 프레임에 추가
		}
		
		// 스레드 실행 메서드
		public void run() {
			for (int i = 0; i < 200; i++) {
				x += 10 * Math.random(); //난수를 이용하여 자동차의 위치 변경
				label.setBounds(x, y, 100, 100); //레이블의 위치 업데이트
				repaint(); // 화면 다시 그리기 요청
				try {
					Thread.sleep(100); // 0.1초 동안 잠자기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//CarGame클래스의 생성자
	public CarGame(){
		setTitle("CarRace"); //프레임의 제목 설정
		setSize(600, 200); // 프레임의 크기 설정
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임을 닫을 때 해당 애플리케이션을 종료하게 함
		setLayout(null); //배치 관리자를 절대 위치 배치 관리자로 한다.
		
		// 세 대의 자동차를 생성하고 각각의 스레드를 시작함
		(new MyThread("C:/car1.gif", 100, 0)).start(); 
		(new MyThread("C:/car2.gif", 100, 50)).start();
		(new MyThread("C:/car3.gif", 100, 100)).start();
		
		setVisible(true); // 프레임을 표시
	}
	
	//메인 메소드 - 프로그램이 실행되는 부분(진입점)
	public static void main(String[] args) {
		CarGame t = new CarGame(); // CarGame 객체 생성 및 시작
	}
}

//Math.random(): Math.random()은 0 이상 1 미만의 난수를 생성하는 메서드입니다.
//이 메서드는 0 이상이고 1 미만인 임의의 부동 소수점 숫자를 반환합니다.

//10 * Math.random(): Math.random()이 생성한 난수를 10배로 곱합니다. 
//이렇게 하면 0 이상 10 미만의 임의의 부동 소수점 숫자를 얻게 됩니다.

//x += 10 * Math.random();: 이 부분은 현재의 x 값을 10 이상 10 미만의 임의의 수 단위로 증가시킵니다.
//x는 자동차의 가로 위치를 나타내며, 
//이 수식을 사용하면 자동차가 매 반복에서 0 이상 10 미만의 거리를 무작위로 이동하게 됩니다. 
//이것은 자동차의 위치를 갱신하여 자동차가 화면 상에서 이동하는 것을 시뮬레이트하는 데 사용됩니다.


//"절대 위치 배치 관리자"는  컴포넌트의 위치를 정확한 좌표로 지정하는 방식을 사용합니다. 
//자동으로 컴포넌트를 배치하려면 다른 배치 관리자(layout manager)를 사용 -  아래 예시
//FlowLayout: 컴포넌트를 왼쪽에서 오른쪽으로, 위에서 아래로 흐르게 배치합니다. -> 행과 열을 따라 순서대로 배치됨
//BorderLayout: 컴포넌트를 동, 서, 남, 북, 중앙의 다섯 영역으로 나누어 배치합니다.
//GridLayout: 컴포넌트를 격자 형태로 배치합니다. 행과 열의 개수를 지정할 수 있습니다.
//GridBagLayout: 복잡한 레이아웃을 구현할 수 있는 고급 배치 관리자로, 컴포넌트의 위치와 크기를 상세하게 제어할 수 있습니다.
//BoxLayout: 컴포넌트를 수평 또는 수직으로 일렬로 배치합니다.
