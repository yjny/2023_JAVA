package hw;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*Week04_01*/
public class AddressBook extends JFrame {
	private JButton button;
	private JTextField name, number;
	
	public AddressBook() {
		setSize(300, 150);
		setTitle("Address Book");
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("이름 "));
		name = new JTextField(15);
		panel.add(name);
		
		panel.add(new JLabel("전화번호 "));
		number = new JTextField(15);
		panel.add(number);
		
		button = new JButton("저장");
		panel.add(button);
		add(panel);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformend(ActionEvent e) {
			if (e.getSource()==button|| e.getSource()==name) {
				name.getText();
				
			}
		}
	}
	
	public static void main(String[] args) {
		new AddressBook();
	}
	
}
