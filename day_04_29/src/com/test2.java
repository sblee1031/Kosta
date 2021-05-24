package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class test2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 window = new test2();
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
	public test2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uCF54\uB4DC\uC758 \u7F8E");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("검증하기");
		btnNewButton.setBackground(new Color(255, 250, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("검증하기 버튼~");
			}
		});
		btnNewButton.setBounds(1007, 510, 93, 24);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("다음으로...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("다음으로 버튼~");
				System.out.println(btnNewButton_1.getText());
				btnNewButton_1.setText("이전으로");
				
			}
		});
		btnNewButton_1.setBounds(1047, 609, 151, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setText("\uC57D\uAD00\uB0B4\uC6A9 1");
		textField.setBounds(618, 70, 577, 124);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("\uC57D\uAD00\uB0B4\uC6A9 2");
		textField_1.setColumns(10);
		textField_1.setBounds(618, 261, 577, 124);
		frame.getContentPane().add(textField_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("(\uD544\uC218)\uB3D9\uC758\uD569\uB2C8\uB2E4.");
		chckbxNewCheckBox.setBounds(1047, 211, 141, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("(\uD544\uC218)\uB3D9\uC758\uD569\uB2C8\uB2E4.");
		chckbxNewCheckBox_1.setBounds(1047, 402, 141, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea.setBackground(Color.ORANGE);
		textArea.setText("\uC774\uC6A9 \uD544\uC218 \uB3D9\uC758");
		textArea.setBounds(618, 24, 120, 24);
		frame.getContentPane().add(textArea);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(759, 449, 199, 24);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(759, 510, 199, 24);
		frame.getContentPane().add(textPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("\uBA74\uD5C8 \uBC88\uD638");
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1.setBackground(Color.ORANGE);
		textArea_1.setBounds(657, 449, 81, 24);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setText("\uBC1C\uAE09 \uC77C\uC790");
		textArea_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1_1.setBackground(Color.ORANGE);
		textArea_1_1.setBounds(657, 510, 81, 24);
		frame.getContentPane().add(textArea_1_1);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
