package com.day;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyEx03 extends JFrame{
	
	public MyEx03() {
		Container mct = getContentPane();
		mct.setLayout(new BorderLayout(1, 10));
		mct.add(new JButton("Right"), BorderLayout.EAST);
		mct.add(new JButton("Left"), BorderLayout.WEST);
		mct.add(new JButton("top"), BorderLayout.NORTH);
		mct.add(new JButton("bottom"), BorderLayout.SOUTH);
		mct.add(new JButton("center"), "Center");
		mct.add(new JButton("Exit"));
		mct.add(new JButton("Exit2"));
	}
	public static void main(String[] args) {
		MyEx03 my = new MyEx03();
		my.setTitle("test");
		my.setSize(500,500);
		my.setVisible(true);
		my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

