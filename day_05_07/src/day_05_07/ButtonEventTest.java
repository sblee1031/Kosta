package day_05_07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ButtonEventTest implements ActionListener{

	public JTextField input = null;
	public String[] sa = new String[1];
	String oper = "";
	boolean[] is_op = {true};
	boolean oper_is ;
	
	public ButtonEventTest() {
		
	}
	public ButtonEventTest(JTextField input) {
		this.input = input;
		
	}
	public ButtonEventTest(JTextField input, String[] s) {
		this.input = input;
		this.sa = s;
	}
	
	public ButtonEventTest(JTextField input, boolean[] is_op, boolean oper_is) {
		this.input = input;
		this.is_op = is_op;
		this.oper_is = oper_is;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(!input.getText().equals("0")) {
			if(is_op[0] == true) {
				input.setText(input.getText()+e.getActionCommand());
			}else {
				is_op[0] = true;
				input.setText(e.getActionCommand());
			}
			
		}else {
			input.setText(e.getActionCommand());
		}
		
	}
	
	

}
