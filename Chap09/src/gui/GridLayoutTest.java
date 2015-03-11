package gui;

import java.awt.*;

import javax.swing.*;

public class GridLayoutTest extends JFrame {
	
	public GridLayoutTest() {
		this("GridLayout 예제");
	}
	
	public GridLayoutTest(String windowTitle) {
		setTitle(windowTitle);
		
		// 컨테이너 객체 조회
		Container c = getContentPane();
		
		// 레이아웃 매니저 설정
		GridLayout layout = new GridLayout(4, 2);
		layout.setVgap(5);
		c.setLayout(layout);
		
		// 컴포넌트 추가
		c.add(new JLabel("이름"));
		c.add(new JTextField("홍길동"));
		c.add(new JLabel("학번"));
		c.add(new JTextField("101"));
		c.add(new JLabel("학과"));
		c.add(new JTextField("컴공"));
		c.add(new JLabel("과목"));
		c.add(new JTextField("자바"));
		
		setSize(400, 250);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GridLayoutTest();
	}
	
}
