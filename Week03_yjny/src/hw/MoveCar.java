package hw;
/*Week03_03*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveCar extends JFrame {
    int img_x = 150, img_y = 150; // 자동차 이미지의 초기 위치 변수

    JButton leftButton, rightButton; // 왼쪽과 오른쪽 버튼을 나타내는 JButton 변수 선언

    public MoveCar() {
        setSize(600, 300); // 프레임 크기 설정

        leftButton = new JButton("왼쪽"); // "왼쪽" 버튼 생성
        rightButton = new JButton("오른쪽"); // "오른쪽" 버튼 생성

        leftButton.setBounds(50, 220, 100, 30); // "왼쪽" 버튼의 위치와 크기 설정
        rightButton.setBounds(350, 220, 100, 30); // "오른쪽" 버튼의 위치와 크기 설정

        JPanel panel = new JPanel();
        panel.setLayout(null); // 레이아웃 매니저를 null로 설정하여 수동으로 컴포넌트 위치 및 크기 제어

        JButton button = new JButton(""); // 이미지를 표시할 버튼 생성
        ImageIcon icon = new ImageIcon("C:\\car.png"); // 자동차 이미지를 불러와 아이콘으로 설정
        button.setIcon(icon);
        button.setBounds(img_x, img_y, 200, 100); // 버튼의 위치와 크기 설정

        // "왼쪽" 버튼 클릭 시 실행되는 ActionListener
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x -= 20; // 왼쪽으로 이동할 때 x 좌표를 감소시켜 왼쪽으로 이동
                button.setBounds(img_x, img_y, 200, 100); // 버튼의 위치 업데이트
            }
        });

        // "오른쪽" 버튼 클릭 시 실행되는 ActionListener
        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x += 20; // 오른쪽으로 이동할 때 x 좌표를 증가시켜 오른쪽으로 이동
                button.setBounds(img_x, img_y, 200, 100); // 버튼의 위치 업데이트
            }
        });

        panel.add(leftButton); // "왼쪽" 버튼을 패널에 추가
        panel.add(rightButton); // "오른쪽" 버튼을 패널에 추가
        panel.add(button); // 이미지 버튼을 패널에 추가

        add(panel); // 패널을 프레임에 추가
        setVisible(true); // 프레임을 화면에 표시
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료 설정
    }

    public static void main(String[] args) {
        MoveCar f = new MoveCar(); // MoveCar 클래스의 객체를 생성하여 GUI 실행
    }
}
