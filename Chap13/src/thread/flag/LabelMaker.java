package thread.flag;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelMaker extends Thread {
	
	Container contentPane;
	
	boolean finishRequested = false;
	
	// 이 객체가 생성이 되면
	// 자동으로 레이블을 만들고,
	// 대상 컨테이너에 레이블을 배치시키는 작업을
	// 계속 반복 수행하는 녀석으로 만들어보자...
	public LabelMaker(Container c) {
		contentPane = c;
	}
	
	@Override
	public void run() {
		while (!finishRequested) {	// finishRequested가 true가 되면 while문 반복 끝
			makeLabel(contentPane);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		contentPane.removeAll();
		JLabel label = new JLabel("FINISH");
		label.setForeground(Color.RED);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(180, 160, 80, 30);
		contentPane.add(label);
		contentPane.repaint();
	}
	
	public void finish() {
		finishRequested = true;
	}
	
	// 레이블 컴포넌트를 만들고
	// 외부에서 알려주는 곳에 컴포넌트 배치시키기
	public void makeLabel(Container c) {
		int x = (int) (Math.random() * c.getWidth());
		int y = (int) (Math.random() * c.getHeight());
		
		JLabel label = new JLabel("Java");
		label.setSize(80, 30);
		label.setLocation(x, y);
		c.add(label);
		c.repaint();
	}
	
}
