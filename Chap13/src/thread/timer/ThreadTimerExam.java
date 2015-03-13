package thread.timer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimerExam extends JFrame {
	
	JLabel timerLabel;
	
	public ThreadTimerExam() {
		setTitle("Thread Å×½ºÆ®");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TimerThread tt = new TimerThread();
		
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 100));
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(timerLabel, BorderLayout.CENTER);
		
		JButton stopBtn = new JButton("Stop");
		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tt.interrupt();	// TimerThread¿¡ InterruptExceptionÀÌ ¹ß»ýµÊ
			}
		});
		getContentPane().add(stopBtn, BorderLayout.SOUTH);
		
		setSize(300, 200);
		setVisible(true);
		
		tt.start();
	}
	
	class TimerThread extends Thread {
		
		int n;
		
		@Override
		public void run() {
			while (true) {
				timerLabel.setText("" + n++);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
//					return;
					break;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ThreadTimerExam();
	}
	
}
