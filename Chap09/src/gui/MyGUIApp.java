package gui;

import java.awt.*;

import javax.swing.*;

public class MyGUIApp {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("첫 번째 GUI 프로그램");
		frame.setSize(300, 300);
		frame.setVisible(true);	// 윈도우가 화면에 나타남
		
		// 윈도우를 닫을 때 프로그램 전체를 종료하려면
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		// ContentPane 알아내기
		Container content = frame.getContentPane();
		
		// 붙여넣을 컴포넌트 생성
		JButton button = new JButton("OK");
		
		// 컨테이너에 컴포넌트 붙이기
		content.add(button);
		*/
		
		// 컨테이너 새로 생성
		JPanel p = new JPanel();
		p.setBackground(Color.ORANGE);	// 컨테이너 배경색 설정
		
		p.setLayout(new FlowLayout());	// 레이아웃 매니저 설정
//		p.setLayout(new BorderLayout());
		
		// 붙여넣을 컴포넌트 생성
		JButton button = new JButton("OK");
		
		// 컨테이너에 컴포넌트 추가
		p.add(button);
		
		p.add(new JButton("Cancel"));
		p.add(new JButton("Ignore"));
		
		// 위 새로만든 컨테이너를 Frame의 ContentPane으로 지정
		frame.setContentPane(p);
	}
	
}
