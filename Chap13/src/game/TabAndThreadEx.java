package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

class MyLabel extends JLabel {
	
	int barSize;
	int maxBarSize;
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.MAGENTA);
		
		int width = (int) (((double) getWidth()) / maxBarSize * barSize);
		if (width == 0)
			return;
		g.fillRect(0, 0, width, getHeight());
	}
	
	synchronized void fill() {
		if (barSize == maxBarSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint();
		notify();
	}
	
	synchronized void consume() {
		if (barSize == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint();
		notify();
	}
	
}

class ConsumerThread extends Thread {
	
	MyLabel bar;
	
	public ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				sleep(200);
			} catch (InterruptedException e) {
				break;
			}
			bar.consume();
		}
	}
	
}

public class TabAndThreadEx extends JFrame {
	
	public TabAndThreadEx() {
		setTitle("Hi");
		
		
		
		setSize(600, 450);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TabAndThreadEx();
	}
	
}
