import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
//ch12.그래픽
public class TriCircle extends JFrame {
    public TriCircle() {
        super("삼색원"); // JFrame의 생성자 호출, 창 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료 설정
        setContentPane(new MyPanel()); // 창의 내용을 MyPanel로 설정
        setSize(120, 150); // 창의 크기 설정 (가로 120, 세로 150)
        setVisible(true); // 창을 화면에 표시
    }

    // 사용자 정의 패널 클래스 MyPanel
    class MyPanel extends JPanel {
        // 패널의 그리기 메서드를 오버라이드
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // JPanel의 그리기 메서드 호출

            // RED 원 그리기
            g.setColor(Color.RED); // 그래픽 색상을 빨강으로 설정
            g.fillArc(10, 10, 100, 100, 90, 120); // 호를 그리는 메서드로 빨간 원 그리기

            // BLUE 원 그리기
            g.setColor(Color.BLUE); // 그래픽 색상을 파랑으로 설정
            g.fillArc(10, 10, 100, 100, 210, 120); // 호를 그리는 메서드로 파랑 원 그리기

            // YELLOW 원 그리기
            g.setColor(Color.YELLOW); // 그래픽 색상을 노랑으로 설정
            g.fillArc(10, 10, 100, 100, 330, 120); // 호를 그리는 메서드로 노랑 원 그리기
        }
    }

    public static void main(String[] args) {
        new TriCircle(); // TriCircle 객체 생성하여 GUI 창 표시
    }
}

//밑에 있는 예제 두개 더 작성하기 (수업활동)
//Week04_01 수준으로 시험 출제, 1 3 2 순서대로 풀고 제출