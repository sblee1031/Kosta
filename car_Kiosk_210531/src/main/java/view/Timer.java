package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Timer extends JFrame implements Runnable{
	private JFrame frame;
	private JLabel label;
	
	public Timer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		label = new JLabel();
		label.setFont(new Font("TimesRoman", Font.ITALIC, 50));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, BorderLayout.CENTER);
		setSize(300, 200);
		Thread t1 = new Thread(this);
		t1.start();
		
		setVisible(true);
	}
	
	@Override
	public void run() {
		int sec = 10;
		while (sec!=0) {
			try {
				String time = sec + "초 후 종료";
				Thread.sleep(1000);
				label.setText(time);
				sec = sec-1;
				System.out.println("sec : "+sec);
//				Main main = new Main();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("타이머종료");
		Main main = new Main();
	}
	
//	public String getCurrentTime() {
//		Calendar c = Calendar.getInstance();
//		int hour = c.get(Calendar.HOUR_OF_DAY);
//		int min = c.get(Calendar.MINUTE);
//		int sec = c.get(Calendar.SECOND);
//		
//		String time = sec+"초 후 종료";
//		return time;
//	}
	
	public static void main(String[] args) {
		new Timer();
	}

}

