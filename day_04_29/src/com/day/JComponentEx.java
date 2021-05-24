package com.day;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComponentEx extends JFrame {
	JComponentEx() {
		super("ÄÚµåÀÇ Ú¸");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton(" Disabled Button ");
		JButton b3 = new JButton("getX(), getY()");
		JLabel l1 = new JLabel();
		l1.(C:\Users\admin\Desktop\11.jpg);
		b1.setBackground(Color.YELLOW); 
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); 
		b2.setEnabled(false); 
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				setTitle(b.getX() + "," + b.getY()); 
			}
		});
		c.add(b1); c.add(b2); c.add(b3);
		setSize(1920,1080); setVisible(true);
	}
	public static void main(String[] args) {
		new JComponentEx();
	}
}
