package com.day;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Swing_day_0430_test {

	private JFrame frame;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing_day_0430_test window = new Swing_day_0430_test();
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
	public Swing_day_0430_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel menu1_panel = new JPanel();
		menu1_panel.setBackground(new Color(119, 136, 153));
		menu1_panel.setBounds(34, 52, 446, 569);
		frame.getContentPane().add(menu1_panel);
		menu1_panel.setLayout(null);
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setBounds(12, 10, 402, 61);
		menu1_panel.add(lblNewLabel);
		
		JButton num_7 = new JButton("7");
		num_7.setBackground(new Color(255, 255, 255));
		num_7.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_7.setForeground(SystemColor.desktop);
		num_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_7.getText());
			}
		});
		num_7.setBounds(12, 108, 96, 96);
		menu1_panel.add(num_7);
		
		JButton num_8 = new JButton("8");
		num_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_8.getText());
			}
		});
		num_8.setForeground(Color.BLACK);
		num_8.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_8.setBackground(Color.WHITE);
		num_8.setBounds(119, 108, 96, 96);
		menu1_panel.add(num_8);
		
		JButton num_9 = new JButton("9");
		num_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_9.getText());
			}
		});
		num_9.setForeground(Color.BLACK);
		num_9.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_9.setBackground(Color.WHITE);
		num_9.setBounds(226, 108, 96, 96);
		menu1_panel.add(num_9);
		
		JButton num_d = new JButton("/");
		num_d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_clauar(num_d.getText());
			}
		});
		num_d.setForeground(Color.BLACK);
		num_d.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_d.setBackground(Color.WHITE);
		num_d.setBounds(333, 108, 96, 96);
		menu1_panel.add(num_d);
		
		JButton num_4 = new JButton("4");
		num_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_4.getText());
			}
		});
		num_4.setForeground(Color.BLACK);
		num_4.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_4.setBackground(Color.WHITE);
		num_4.setBounds(12, 214, 96, 96);
		menu1_panel.add(num_4);
		
		JButton num_5 = new JButton("5");
		num_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_5.getText());
			}
		});
		num_5.setForeground(Color.BLACK);
		num_5.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_5.setBackground(Color.WHITE);
		num_5.setBounds(119, 214, 96, 96);
		menu1_panel.add(num_5);
		
		JButton num_6 = new JButton("6");
		num_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_6.getText());
			}
		});
		num_6.setForeground(Color.BLACK);
		num_6.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_6.setBackground(Color.WHITE);
		num_6.setBounds(226, 214, 96, 96);
		menu1_panel.add(num_6);
		
		JButton num_mt = new JButton("*");
		num_mt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_clauar(num_mt.getText());
			}
		});
		num_mt.setForeground(Color.BLACK);
		num_mt.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_mt.setBackground(Color.WHITE);
		num_mt.setBounds(333, 214, 96, 96);
		menu1_panel.add(num_mt);
		
		JButton num_1 = new JButton("1");
		num_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_1.getText());
			}
		});
		num_1.setForeground(Color.BLACK);
		num_1.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_1.setBackground(Color.WHITE);
		num_1.setBounds(12, 320, 96, 96);
		menu1_panel.add(num_1);
		
		JButton num_2 = new JButton("2");
		num_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_2.getText());
			}
		});
		num_2.setForeground(Color.BLACK);
		num_2.setFont(new Font("±¼¸²", Font.BOLD, 32));
		num_2.setBackground(Color.WHITE);
		num_2.setBounds(119, 320, 96, 96);
		menu1_panel.add(num_2);
		
		JButton num_3 = new JButton("3");
		num_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_3.getText());
			}
		});
		num_3.setForeground(Color.BLACK);
		num_3.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_3.setBackground(Color.WHITE);
		num_3.setBounds(226, 320, 96, 96);
		menu1_panel.add(num_3);
		
		JButton num_m = new JButton("-");
		num_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_clauar(num_m.getText());
			}
		});
		num_m.setForeground(Color.BLACK);
		num_m.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_m.setBackground(Color.WHITE);
		num_m.setBounds(333, 320, 96, 96);
		menu1_panel.add(num_m);
		
		JButton num_0 = new JButton("0");
		num_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_event(num_0.getText());
			}
		});
		num_0.setForeground(Color.BLACK);
		num_0.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_0.setBackground(Color.WHITE);
		num_0.setBounds(12, 426, 96, 96);
		menu1_panel.add(num_0);
		
		JButton num_e = new JButton("=");
		num_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_clauar(num_e.getText());
			}
		});
		num_e.setForeground(Color.BLACK);
		num_e.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_e.setBackground(Color.WHITE);
		num_e.setBounds(226, 426, 93, 96);
		menu1_panel.add(num_e);
		
		JButton num_p = new JButton("+");
		num_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_clauar(num_p.getText());
			}
		});
		num_p.setForeground(Color.BLACK);
		num_p.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_p.setBackground(Color.WHITE);
		num_p.setBounds(333, 426, 96, 96);
		menu1_panel.add(num_p);
		
		JButton num_C = new JButton("C");
		num_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_clauar(num_C.getText());
			}
		});
		num_C.setForeground(Color.BLACK);
		num_C.setFont(new Font("±¼¸²", Font.BOLD, 23));
		num_C.setBackground(Color.WHITE);
		num_C.setBounds(122, 426, 93, 96);
		menu1_panel.add(num_C);
	}
	
	void btn_event(String text) {
		if(!lblNewLabel.getText().equals("0")) {
			lblNewLabel.setText(lblNewLabel.getText()+text);
			
			//System.out.println(lblNewLabel.getText());
		}else {
			lblNewLabel.setText(text);
		}
		
		String t = lblNewLabel.getText().replace(",", "");
		long num = Long.parseLong(t);
		String p = String.format("%,d", num);
		lblNewLabel.setText(p);
		System.out.println(p);
		//text = lblNewLabel.getText() + text;
		
		//System.out.println(lblNewLabel.get);
	}
	
	String temp = "";
	String cal = "";
	void btn_clauar(String text) {
		switch(text) {
		
		case "C":
			System.out.println(text);
			lblNewLabel.setText("0");
			break;
		case "=":
			equal_operation(cal);
			break;
		case "-":
			btn_operation(text);
			break;
		case "+":
			btn_operation(text);
			break;
		case "*":
			btn_operation(text);
			break;
		case "/":
			btn_operation(text);
			break;
		}
	}
	
	void btn_operation(String text) {
		temp = lblNewLabel.getText().replace(",", "");
		cal = text;
		lblNewLabel.setText("0");
		System.out.println(temp+cal);
	}
	
	long result;
	void equal_operation(String cal) {
		long temp_num = Long.parseLong(temp);
		String temp2 = lblNewLabel.getText().replace(",", "");
		long temp_num2 = Long.parseLong(temp2);
		
			if(cal == "+") {
			result = temp_num + temp_num2;
			}else if(cal == "-"){
			result = temp_num - temp_num2;
			}else if(cal == "*") {
			result = temp_num * temp_num2;
			}else if(cal == "/") {
			result = temp_num / temp_num2;
			}
		System.out.println(result);
		String p = String.format("%,d", result);
		lblNewLabel.setText(p);
	}
	
	
	
	
}
