package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;

public class test{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 0, 576, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(37, 71, 483, 392);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¹öÆ°À» ´­·¯ÁÖ¼¼¿ä~~");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(173, 255, 47));
		lblNewLabel.setBackground(new Color(0, 206, 209));
		lblNewLabel.setBounds(58, 22, 387, 56);
		panel.add(lblNewLabel);
//		System.out.println(lblNewLabel.getText());
		
		JButton btnNewButton = new JButton("100");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(btnNewButton.getText());
				lblNewLabel.setText(btnNewButton.getText());
			}
		});
		btnNewButton.setBounds(57, 88, 84, 157);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("200");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(btnNewButton_1.getText());
				lblNewLabel.setText(btnNewButton_1.getText());
			}
		});
		btnNewButton_1.setBounds(198, 88, 84, 157);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("300");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(btnNewButton_2.getText());
				lblNewLabel.setText(btnNewButton_2.getText());
				
			}
		});
		btnNewButton_2.setBounds(339, 88, 84, 157);
		panel.add(btnNewButton_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(60, 10, 439, 51);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		

		JButton btnNewButton_3 = new JButton("¼û±è");
		btnNewButton_3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				if (panel.isVisible()) {
//					panel.setVisible(false);
//				}else {
//					panel.setVisible(true);
//				}
//				panel.setVisible(panel.isVisible() ? false : true);
				
				panel.setVisible(!panel.isVisible());
				lblNewLabel_1.setText("isvisible : "+panel.isVisible());
				
				btnNewButton_3.setText(panel.isVisible() ? "¼û±è" : "º¸ÀÓ");
				
			}
			
		});
		btnNewButton_3.setBounds(397, 521, 123, 46);
		frame.getContentPane().add(btnNewButton_3);
		
		
		
	}
}
