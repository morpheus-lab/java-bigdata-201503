package swing.api;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderExam extends JFrame {

	Container contentPane;
	
	public SliderExam() {
		setTitle("콤보 박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		/*
		// JSlider 객체 생성
//		JSlider slider = new JSlider();
//		JSlider slider = new JSlider(0, 200, 100);
//		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
		
		// 슬라이더의 각종 속성 변경
		slider.setPaintLabels(true);
//		slider.setPaintLabels(false);
		
		slider.setPaintTicks(true);
//		slider.setPaintTicks(false);
		
		slider.setPaintTrack(true);
//		slider.setPaintTrack(false);
		
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(10);
		
		contentPane.add(slider);
		*/
		
		JSlider sliderR = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		sliderR.setPaintLabels(true);
		sliderR.setPaintTicks(true);
		sliderR.setMajorTickSpacing(50);
		sliderR.setMinorTickSpacing(10);
		
		JSlider sliderG = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		sliderG.setPaintLabels(true);
		sliderG.setPaintTicks(true);
		sliderG.setMajorTickSpacing(50);
		sliderG.setMinorTickSpacing(10);
		
		JSlider sliderB = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		sliderB.setPaintLabels(true);
		sliderB.setPaintTicks(true);
		sliderB.setMajorTickSpacing(50);
		sliderB.setMinorTickSpacing(10);
		
		contentPane.add(sliderR);
		contentPane.add(sliderG);
		contentPane.add(sliderB);
		
//		JPanel colorPanel = new JPanel();
//		colorPanel.setSize(120, 80);
//		contentPane.add(colorPanel);
		
		JLabel colorLabel = new JLabel("RGB 조합 색상");
		colorLabel.setOpaque(true);
		contentPane.add(colorLabel);
		
		ChangeListener cl = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int r = sliderR.getValue();
				int g = sliderG.getValue();
				int b = sliderB.getValue();
				
				Color color = new Color(r, g, b);
				
				colorLabel.setBackground(color);
			}
		};
		
		sliderR.addChangeListener(cl);
		sliderG.addChangeListener(cl);
		sliderB.addChangeListener(cl);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SliderExam();
	}

}
