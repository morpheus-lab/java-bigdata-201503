package thread.flag;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() {
		// UI의 기본 속성 설정
		
		// 타이틀 바 텍스트 설정
		setTitle("타이틀~~~~~");
		
		// 종료버튼 클릭 시 프로그램 종료되도록 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컴포넌트를 수동으로 배치시키기 위해
		getContentPane().setLayout(null);
		
		// LabelMaker 객체에게 레이블을 추가해달라
		LabelMaker maker = new LabelMaker(getContentPane());
//		maker.makeLabel(getContentPane());	// 이 Window 객체가 갖고 있는 contentPane 객체를 maker 객체에게 전달
		maker.start();
		
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				maker.finish();
			}
		});
		
		// 윈도우 크기 설정
		setSize(400, 300);
		
		// 윈도우를 화면에 보이기
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Window();
	}
	
}
