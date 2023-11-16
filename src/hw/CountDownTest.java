//Week09_01 카운트다운 프로그램 작성하기
//카운트 중지 버튼을 클릭하면 카운트가 멈춘다
//카운트 다시 시작 버튼을 클릭하면 카운트가 다시 시작된다
package hw;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class CountDownTest extends JFrame {
	private JLabel label;
	Thread t;
	class Counter extends Thread {
		public void run() {
		
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				return;
			}
			label.setText(i+"");
			}
		}
	}
	//여기
	public CountDownTest() {
		setTitle("카운트다운!");
		setSize(400, 150);
		getContentPane().setLayout(null);
		
		label = new JLabel("0");
		label.setBounds(0,0,384,111);
		label.setFont(new Font("Serif", Font.BOLD, 100));
		getContentPane().add(label);
		
		
		//버튼 추가하기
		JButton InterruptButton = new JButton("카운터 중지"); //버튼 생성
		InterruptButton.setBounds(247, 25, 125, 23); //버튼 위치와 크기
	
		//버튼을 누르면 스레드t가 중지되도록 함
		InterruptButton.addActionListener(e->t.interrupt()); 
		getContentPane().add(InterruptButton); 
		setVisible(true);
		
	
		//버튼 추가하기
		JButton ContinueButton = new JButton("카운트 다시 시작"); //버튼 생성
		ContinueButton.setBounds(247, 50, 125, 23); //버튼 위치와 크기
			
        // "카운트 다시 시작" 버튼을 누르면 기존 스레드를 재개하도록 함
        
		ContinueButton.addActionListener(e->{
			if(t.isAlive()) {
				t.interrupt();
			}
			t = new Counter();
			t.start();
		});
        getContentPane().add(ContinueButton); 
		setVisible(true);
		
		t = new Counter(); //새로운 카운터 t 생성하기
		t.start(); //스레드 실행
		
		
}

public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
	}
}
