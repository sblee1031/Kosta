package day_05_06;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Swing_0506 {

	private JFrame frame;
	private JTextField textField;
	private JButton btn_0;
	private boolean[] is_op = {true};
	private boolean oper_is=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing_0506 window = new Swing_0506();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing_0506() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 699);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 183, 107));
		panel.setBounds(12, 27, 476, 612);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		createNumButton(panel);
		createNumOp(panel);

		
	}
	
	
	String op = "";
	int p = 0;
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	String getOp() {
		System.out.println(getP());
		System.out.println(op);
		return op;
	}
	void setOp(String op) {
//		if(getOp()!=null && getP()!=0) {
//			calcurator();
//			setP(0);
//		}
		
			if(getOp()!=null && getP()!=0 &&oper_is == true) {
				calcurator();
				setP(Integer.parseInt(textField.getText()));
			}
		setP(Integer.parseInt(textField.getText()));
		is_op[0] = false;
		this.op = op;
		
	}
	void calcurator() {
		

		switch(getOp()) {
			case "*":
				int n2 = getP() *Integer.parseInt(textField.getText());
				textField.setText(n2+"");
				break;
			case "-":
				int n3 = getP() -Integer.parseInt(textField.getText());
				textField.setText(n3+"");
				break;
			case "+":
				int n = getP() +Integer.parseInt(textField.getText());
				textField.setText(n+"");
				break;
			case "/":
				int n4 = getP() /Integer.parseInt(textField.getText());
				textField.setText(n4+"");
				break;
		}
		
		
	}
	
	void createNumOp(JPanel panel) {
		String[] op = {"*","/","-","+","=","C"};
		for (int i = 0; i < 6; i++) {
			JButton btt_7 = new JButton(op[i]);

			btt_7.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			if(i ==4) {
				System.out.println(btt_7.getText());
				btt_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						calcurator();
						oper_is = false;
					}
				});
				btt_7.setBounds(245, 450, 100, 100);
			}
			else if (i==5) {
				btt_7.setBounds(135, 450, 100, 100);
				btt_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setOp("");
						textField.setText("0");
						p=0;
						oper_is = false;
					}
				});
			}
			else {
				btt_7.setBounds(355, 120+(110*i), 100, 100);
				
				btt_7.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setOp(e.getActionCommand());
						oper_is = false;
					}
				});
			}
			panel.add(btt_7);
		}
			
	}
	
	void createNumButton(JPanel panel) {
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("±¼¸²", Font.BOLD, 27));
		textField.setBounds(25, 10, 407, 68);
		panel.add(textField);
		textField.setColumns(10);
		
		ButtonEventTest button = new ButtonEventTest(textField, is_op, oper_is);
		
		btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(e.getActionCommand());
				oper_is = true;
			}
		});
		btn_0.setBounds(25, 450, 100, 100);
		btn_0.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panel.add(btn_0);
		
		int[] nums = {7,8,9,4,5,6,1,2,3};
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				JButton btn_7 = new JButton(nums[(i)+(j*3)]+"");
				btn_7.addActionListener(button);
				btn_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						oper_is = true;
					}
				});
				btn_7.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
				btn_7.setBounds(25+(110*i), 120+(110*j), 100, 100);
				panel.add(btn_7);
				
			}
			
		}
		
	}
}
