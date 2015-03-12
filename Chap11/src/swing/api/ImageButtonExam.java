package swing.api;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ImageButtonExam extends JFrame {
	
	public ImageButtonExam() {
		setTitle("버튼 이미지 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
//		contentPane.setLayout(new FlowLayout());
		
		// ImageIcon 객체 3개 준비 (평상시, 마우스오버, 클릭)
		ImageIcon iconInit = new ImageIcon("D:\\tel.png");
		ImageIcon iconOver = new ImageIcon("D:\\tel1.png");
		ImageIcon iconClick = new ImageIcon("D:\\tel2.jpg");
		
		// JButton 객체 생성
		JButton button = new JButton("콜미~!", iconInit);	// 초기 상태 이미지 설정
		button.setRolloverIcon(iconOver);	// 마우스 커서가 버튼에 올라가 있는 동안 출력될 이미지 설정
		button.setPressedIcon(iconClick);	// 버튼이 눌러진 동안 출력될 이미지 설정
		
		// 수평 정렬
//		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setHorizontalAlignment(SwingConstants.CENTER);	// 기본값
//		button.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// 수직 정렬
//		button.setVerticalAlignment(SwingConstants.TOP);
		button.setVerticalAlignment(SwingConstants.CENTER);	// 기본값
//		button.setVerticalAlignment(SwingConstants.BOTTOMs);
		
		contentPane.add(button);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageButtonExam();
	}
	
}
