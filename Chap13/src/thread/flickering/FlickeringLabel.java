package thread.flickering;

import java.awt.Color;

import javax.swing.JLabel;

public class FlickeringLabel extends JLabel
implements Runnable {
	
	public FlickeringLabel(String text) {
		super(text);
		
		setOpaque(true);	// �������ϰ� �����ؾ�
							// ������ ���̰� ��
		
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		int state = 0;
		while (true) {
			if (state == 0) {
				setBackground(Color.YELLOW);
				state = 1;
			} else {
				setBackground(Color.GREEN);
				state = 0;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
	
}
