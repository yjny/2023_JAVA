package hw;
import java.awt.*;
import javax.swing.*; //Week04_03

class BusinessCard extends JPanel {
	private ImageIcon imageIcon;
	
	public BusinessCard(){
	   // 이미지 파일을 로드. 이미지 파일의 경로를 정확하게 지정
       imageIcon = new ImageIcon("C:/car.png"); 
//       setOpaque(false); //배경 투명하게 지정
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imageIcon.getImage(), 20, 20, 80, 80, this);		
		g.drawString("조유진", 150, 40);
		g.drawString("사이버보안전공", 150, 60);
		g.drawString("덕성여자대학교", 150, 80);
	}
}

class MyFrame extends JFrame{
	public MyFrame(){
		setSize(600,180);
		setTitle("BusinessCard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new BusinessCard());
		setVisible(true);
	}
}

public class Card {
	public static void main(String[] arge){
		MyFrame F = new MyFrame();
	}
}