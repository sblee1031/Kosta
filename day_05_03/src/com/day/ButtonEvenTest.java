package com.day;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ButtonEvenTest implements ActionListener{

	
	public String b ;
	JTextField input;
	String oper = "";
	
	public ButtonEvenTest(String a, JTextField input) {
			b = a;
			this.input=input;
	}
	public ButtonEvenTest(JTextField input) {
		this.input=input;
	}
	
	public ButtonEvenTest(String oper) {
		this.oper = oper;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String n = e.getActionCommand();
		System.out.println("==="+oper);
		if(oper!=null) {
			System.out.println(oper);
//			System.out.println("e : "+e.getActionCommand());
			input.setText(e.getActionCommand());
		}else if (!input.getText().equals("0")) {
			System.out.println("intput : ");
			input.setText(input.getText()+n);
		}else {
			input.setText(n);
		}
		

		
		//input.setText(e.getActionCommand());
		
		
	}

}
