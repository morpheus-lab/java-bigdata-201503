package swing.api;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxExam extends JFrame {
	
	Container contentPane;
	String[] fruits = {"사과", "배", "수박", "딸기", "파인애플", "체리", "포도"};
	String[] names = {"홍길동", "심청", "콩쥐", "셜록", "홈즈"};
	
	public ComboBoxExam() {
		setTitle("콤보 박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		// 콤보 박스 1 생성
		JComboBox<String> fCombo = new JComboBox<String>(fruits);
		contentPane.add(fCombo);
		
		// 콤보 박스 2 생성
		JComboBox<String> nCombo = new JComboBox<String>();	// 초기 데이터 지정 X
		for (int i = 0; i < names.length; i++) {
			nCombo.addItem(names[i]);	// 콤보 박스에 동적으로 아이템 추가
		}
		contentPane.add(nCombo);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComboBoxExam();
	}
	
}
