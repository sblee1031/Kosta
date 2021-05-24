package day_05_04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ButtonEventTest implements ActionListener{

	public JTextField input = null;
	public String[] sa = new String[1];
	String oper = "";
	
	
	public ButtonEventTest() {
		
	}
	
	public ButtonEventTest(JTextField input) {
		
		
	}
	public ButtonEventTest(JTextField input, String[] s) {
		this.input = input;
		this.sa = s;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!input.getText().equals("0")) {
			if(sa[0]==null || sa[0].equals("")) {
				System.out.println("if");
				input.setText(input.getText()+e.getActionCommand());
			}else {
				System.out.println("else");
				sa[0]="";
				input.setText(e.getActionCommand());
			}
		}else {
			System.out.println("else1");
			input.setText(e.getActionCommand());
		}
		
		

//		if(!input.getText().equals("0")) {
//			//input.setText(input.getText()+e.getActionCommand());
//			if(sa[0]==null||sa[0].equals("")) {
//				input.setText(input.getText()+e.getActionCommand());
//			}else {
//				sa[0]="";
//				input.setText(e.getActionCommand());
//			}
//		}else {
//			input.setText(e.getActionCommand());
//		}
		//System.out.println(e.getActionCommand());
		//input.setText(e.getActionCommand());
	}
	
	

}
