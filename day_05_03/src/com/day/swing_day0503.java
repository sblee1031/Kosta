package com.day;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class swing_day0503 {

	private JFrame frame;
	private JTextField textField;
	String temp = "";
	String new_s = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing_day0503 window = new swing_day0503();
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
	public swing_day0503() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(12, 25, 570, 618);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("");
		textField.setBounds(35, 28, 505, 55);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btn_7 = new JButton("7");
		btn_7.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_7.setBounds(28, 131, 107, 84);
		panel.add(btn_7);
		btn_7.addActionListener(new ButtonEvenTest(btn_7.getText(),textField));

		
		JButton btn_8 = new JButton("8");
		btn_8.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_8.setBounds(163, 131, 107, 84);
		panel.add(btn_8);
		btn_8.addActionListener(new ButtonEvenTest(btn_8.getText(),textField));

		
		JButton btn_9 = new JButton("9");
		btn_9.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_9.setBounds(298, 131, 107, 84);
		panel.add(btn_9);
		btn_9.addActionListener(new ButtonEvenTest(btn_9.getText(),textField));

		
		JButton btnNewButton_1_2 = new JButton("*");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = e.getActionCommand();
				new_s = textField.getText();
				new ButtonEvenTest(temp);
			}
		});
		btnNewButton_1_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(433, 131, 107, 84);
		panel.add(btnNewButton_1_2);
		
		JButton btn_4 = new JButton("4");
		btn_4.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_4.setBounds(28, 231, 107, 84);
		panel.add(btn_4);
		btn_4.addActionListener(new ButtonEvenTest(btn_4.getText(),textField));

		
		JButton btn_5 = new JButton("5");
		btn_5.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_5.setBounds(163, 231, 107, 84);
		panel.add(btn_5);
		btn_5.addActionListener(new ButtonEvenTest(btn_5.getText(),textField));
		
		JButton btn_6 = new JButton("6");
		btn_6.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_6.setBounds(298, 231, 107, 84);
		panel.add(btn_6);
		btn_6.addActionListener(new ButtonEvenTest(btn_6.getText(),textField));

		
		JButton btnNewButton_1_2_1 = new JButton("/");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = e.getActionCommand();
				new_s = textField.getText();
				new ButtonEvenTest(temp);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1_2_1.setBounds(433, 231, 107, 84);
		panel.add(btnNewButton_1_2_1);
		
		JButton btn_1 = new JButton("1");
//		btn_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				num(btn_1.getText());
//				
//			}
//		});
		
		btn_1.addActionListener(new ButtonEvenTest(btn_1.getText(),textField));
		btn_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_1.setBounds(28, 325, 107, 84);
		panel.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_2.setBounds(163, 328, 107, 84);
		panel.add(btn_2);
		btn_2.addActionListener(new ButtonEvenTest(btn_2.getText(),textField) {
		});
		
		
		JButton btn_3 = new JButton("3");
		btn_3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_3.setBounds(298, 328, 107, 84);
		panel.add(btn_3);
		btn_3.addActionListener(new ButtonEvenTest(btn_3.getText(),textField)
				);
		
		JButton btnNewButton_1_2_2 = new JButton("-");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = e.getActionCommand();
				new_s = textField.getText();
				new ButtonEvenTest(temp);
			}
		});
		btnNewButton_1_2_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1_2_2.setBounds(433, 328, 107, 84);
		panel.add(btnNewButton_1_2_2);
		
		JButton btn_0 = new JButton("0");
		btn_0.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btn_0.setBounds(28, 429, 107, 84);
		panel.add(btn_0);
		btn_0.addActionListener(new ButtonEvenTest(btn_0.getText(),textField));

		
		JButton btnNewButton_1_5 = new JButton("C");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
			}
		});
		btnNewButton_1_5.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1_5.setBounds(163, 429, 107, 84);
		panel.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_1_3 = new JButton("=");
		btnNewButton_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				calculator(temp);
			}
		});
		btnNewButton_1_1_3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1_1_3.setBounds(298, 429, 107, 84);
		panel.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_2_3 = new JButton("+");
		btnNewButton_1_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				temp = btnNewButton_1_2_3.getText();
				new_s = textField.getText();
				new ButtonEvenTest(temp);
				
				//textField.setText("");
				
			}
		});
		btnNewButton_1_2_3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1_2_3.setBounds(433, 429, 107, 84);
		panel.add(btnNewButton_1_2_3);
	}
	void calculator(String s) {
		
		switch(s)	{
			case "+":
				
				int c = Integer.parseInt(new_s)+Integer.parseInt(textField.getText());
				textField.setText(c+"");
				
				System.out.println(temp);
				break;
				
				
			case "-":
				int d = Integer.parseInt(new_s)-Integer.parseInt(textField.getText());
				textField.setText(d+"");
				
				System.out.println(temp);
				break;
				
			case "*":
				int e = Integer.parseInt(new_s)*Integer.parseInt(textField.getText());
				textField.setText(e+"");
				
				System.out.println(e);
				break;
			case "/":
				int f = Integer.parseInt(new_s)*Integer.parseInt(textField.getText());
				textField.setText(f+"");
				
				System.out.println(f);
				break;
		}
	}
	void num(String s) {
		textField.setText(s);
	}
}
