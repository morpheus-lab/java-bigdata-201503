package swing.api;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CheckBoxItemEventExam extends JFrame {
	
	JCheckBox[] checks = new JCheckBox[3];
	String[] names = {"사과", "배", "체리"};
	int[] prices = {500, 1000, 1500};
	JLabel sumLabel;
	int sum;
	
	public CheckBoxItemEventExam() {
		setTitle("체크 박스 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		String infoText = "";
		for (int i = 0; i < names.length; i++) {
			if (i > 0) infoText += ", ";
			infoText += names[i] + ": " + prices[i] + "원";
		}
		JLabel info = new JLabel(infoText);
		contentPane.add(info);
		
		for (int i = 0; i < checks.length; i++) {
			checks[i] = new JCheckBox(names[i]);
			checks[i].setBorderPainted(true);	// 경계선
			checks[i].addItemListener(new MyItemListener());	// 체크박스 선택상태 변경 이벤트 처리용
			contentPane.add(checks[i]);
		}
		
		sumLabel = new JLabel("합계: " + sum + "원입니다.");
		contentPane.add(sumLabel);
		
		setSize(250, 300);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Object item = e.getItem();
			if (item == checks[0]) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += prices[0];
				}
				else if (e.getStateChange() == ItemEvent.DESELECTED) {
					sum -= prices[0];
				}
			}
			else if (item == checks[1]) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += prices[1];
				}
				else if (e.getStateChange() == ItemEvent.DESELECTED) {
					sum -= prices[1];
				}
			}
			else if (item == checks[2]) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += prices[2];
				}
				else if (e.getStateChange() == ItemEvent.DESELECTED) {
					sum -= prices[2];
				}
			}
			
			sumLabel.setText("합계: " + sum + "원입니다.");
		}
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventExam();
	}
	
}
