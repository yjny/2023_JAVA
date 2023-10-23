package hw;
/*Week03_01*/

import java.awt.*;
import javax.swing.*;

public class SignUp extends JFrame {

    public SignUp() {
        JPanel panel = new JPanel(); // JPanel 생성!

        // JFrame에 JPanel 추가
        add(panel);

        // 레이블 및 텍스트 필드 생성
        JLabel label1 = new JLabel("이름");
        JTextField field1 = new JTextField(15); // 15 글자의 너비를 가진 텍스트 필드 생성

        JLabel label3 = new JLabel("이메일 주소");
        JTextField field3 = new JTextField(15);

        JLabel label4 = new JLabel("전화번호");
        JTextField field4 = new JTextField(15);

        // 버튼 생성
        JButton register = new JButton("등록하기");
        JButton cancel = new JButton("취소");

        // 패널의 레이아웃을 5x2 그리드 레이아웃으로 설정
        panel.setLayout(new GridLayout(5, 2));

        // 컴포넌트를 패널에 추가
        panel.add(label1);
        panel.add(field1);

        panel.add(new JLabel("패스워드")); // 패스워드 필드의 레이블
        panel.add(new JPasswordField(15)); // 패스워드를 입력하는 텍스트 필드 (비밀번호 표시)

        panel.add(label3);
        panel.add(field3);

        panel.add(label4);
        panel.add(field4);

        panel.add(register);
        panel.add(cancel);

        setSize(300, 150); // 프레임 크기 설정
        setTitle("회원 등록하기"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫을 때 프레임을 종료한다.
        setVisible(true); // 화면에 프레임을 표시하는 설정
    }

    public static void main(String[] args) { // 스윙 스레드, 즉 EDT에서 실행한다
        SwingUtilities.invokeLater(() -> { // EDT 실행 보장
            new SignUp(); // SignUp 클래스의 객체를 생성하여 GUI 실행
        });
    }
}
