package swing.api;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxExam extends JFrame {
	
	public CheckBoxExam() {
		setTitle("체크 박스 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JCheckBox check1 = new JCheckBox("사과");	// 선택되지 않은 상태의 체크박스
		JCheckBox check2 = new JCheckBox("배", true);	// 선택된 상태의 체크박스
		
		ImageIcon icon1 = new ImageIcon("D:\\tel.png");
		ImageIcon icon2 = new ImageIcon("D:\\tel1.png");
		
		JCheckBox check3 = new JCheckBox("전화", icon1);	// 이미지 체크박스
		check3.setBorderPainted(true);	// 경계선 그리기 설정
		check3.setSelectedIcon(icon2);	// 선택된 상태 이미지 설정
		
		contentPane.add(check1);
		contentPane.add(check2);
		contentPane.add(check3);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxExam();
	}
	
}
