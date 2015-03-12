package swing.api;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonExam extends JFrame {
	
	public RadioButtonExam() {
		setTitle("라디오 버튼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(4, 1));	// 4열 1행
		
		JLabel l1 = new JLabel("좋아하는 과일?");
		contentPane.add(l1);
		
		JPanel p = new JPanel();
		
		JRadioButton b1 = new JRadioButton("사과");
		JRadioButton b2 = new JRadioButton("배");
		JRadioButton b3 = new JRadioButton("체리");
		p.add(b1);
		p.add(b2);
		p.add(b3);
		
		contentPane.add(p);
		
		ButtonGroup g1 = new ButtonGroup();
		g1.add(b1);
		g1.add(b2);
		g1.add(b3);
		
		//--------------------------
		JLabel l2 = new JLabel("좋아하는 차?");
		contentPane.add(l2);
		
		JPanel p2 = new JPanel();
		
		JRadioButton b4 = new JRadioButton("커피");
		JRadioButton b5 = new JRadioButton("녹차");
		JRadioButton b6 = new JRadioButton("홍차");
		JRadioButton b7 = new JRadioButton("둥글레");
		
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		
		contentPane.add(p2);
		
		ButtonGroup g2 = new ButtonGroup();
		g2.add(b4);
		g2.add(b5);
		g2.add(b6);
		g2.add(b7);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RadioButtonExam();
	}
}
