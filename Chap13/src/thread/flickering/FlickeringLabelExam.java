package thread.flickering;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickeringLabelExam extends JFrame {
	
	public FlickeringLabelExam() {
		setTitle("±ôºýÀÌ´Â ·¹ÀÌºí");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		FlickeringLabel l1 = new FlickeringLabel("Hello");
		c.add(l1);
		
		JLabel l2 = new JLabel("ÀÏ¹Ý ·¹ÀÌºí");
		c.add(l2);
		
		FlickeringLabel l3 = new FlickeringLabel("¹ÝÂ¦¹ÝÂ¦");
		c.add(l3);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlickeringLabelExam();
	}
	
}
