package hw;
/*Week03_02*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Converter {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("Mile->Km"); // GUI 창의 제목 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료 설정
        frame.setSize(400, 100); // GUI 창 크기 설정

        // JPanel 생성 및 레이아웃 설정
        JPanel panel = new JPanel(new GridBagLayout());

        // GridBagLayout을 사용하여 컴포넌트의 위치와 크기를 관리

        // GridBagConstraints를 사용하여 컴포넌트 배치 제어
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 컴포넌트 크기를 가득 채우도록 설정
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        // "마일을 입력하시오" 라벨 생성 및 패널에 추가
        JLabel inputLabel = new JLabel("마일을 입력하시오:");
        panel.add(inputLabel, constraints);

        // 마일 입력 필드 생성 및 패널에 추가
        JTextField mileField = new JTextField();
        constraints.gridx = 1;
        constraints.weightx = 2.0;
        panel.add(mileField, constraints);

        constraints.gridx = 2;
        constraints.weightx = 0.0;
        // "->" 라벨 생성 및 패널에 추가
        JLabel resultLabel = new JLabel("->");
        panel.add(resultLabel, constraints);

        constraints.gridx = 3;
        constraints.weightx = 2.0;
        // 킬로미터 출력 필드 생성 및 패널에 추가
        JTextField kilometerField = new JTextField();
        kilometerField.setEditable(false); // 출력 필드를 편집 불가능하게 설정
        kilometerField.setBackground(Color.WHITE); // 출력 필드 배경색 설정 (흰색)
        panel.add(kilometerField, constraints);

        constraints.gridx = 4;
        constraints.weightx = 1.0;
        // "변환" 버튼 생성 및 패널에 추가
        JButton convertButton = new JButton("변환");
        panel.add(convertButton, constraints);

        // "변환" 버튼 클릭 이벤트 리스너 추가
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 입력된 마일 값을 가져와서 변환
                    double miles = Double.parseDouble(mileField.getText());
                    double kilometers = miles * 1.609344;
                    
                    // 결과를 소수점 여섯 자리까지 표시하고 " km"를 붙여서 출력 필드에 표시
                    DecimalFormat df = new DecimalFormat("#.######");
                    kilometerField.setText(df.format(kilometers) + " km");
                } catch (NumberFormatException ex) {
                    // 유효하지 않은 입력 처리
                    kilometerField.setText("유효하지 않은 입력입니다.");
                }
            }
        });

        // 패널을 프레임에 추가하고 화면에 표시
        frame.add(panel);
        frame.setVisible(true);
    }
}
//Swing 라이브러리, JFrame, JPanel, GridBagConstraints,
//JLabel, JTextField, JButton 등 스윙컴포넌트, 
//ActionListener, NumberFormat, DecimalFormat 등의 개념 사용됨