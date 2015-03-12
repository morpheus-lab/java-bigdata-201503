package swing.api;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListExam extends JFrame {
	
	public ListExam() {
		setTitle("리스트 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] items = {"사과", "배", "체리", "포도", "수박", "딸기"};
		
		JList list = new JList(items);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e);
			}
		});
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(list);
		
		setSize(300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListExam();
	}
	
}
