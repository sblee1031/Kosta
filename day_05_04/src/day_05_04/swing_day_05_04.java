package day_05_04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class swing_day_05_04 {

	private JFrame frame;
	private JTextField textField;
	String o ="";
	String[] oa = new String[1];
	 String p ="0";
	String t = "test";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing_day_05_04 window = new swing_day_05_04();
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
	public swing_day_05_04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 791);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(40, 26, 540, 701);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("±¼¸²", Font.BOLD, 30));
		textField.setBounds(61, 20, 437, 75);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btn_7 = new JButton("7");
		btn_7.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_7.setBounds(27, 152, 109, 106);
		panel.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_8.setBounds(148, 152, 109, 106);
		panel.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_9.setBounds(269, 152, 109, 106);
		panel.add(btn_9);
		
		JButton btn_m = new JButton("*");
		btn_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(o!=null) {
					calcurator();
					p = "";
					o = btn_m.getText();
				}
				o = btn_m.getText();
				operationTest(o);
				p = textField.getText();
				System.out.println(o);
			}
		});
		btn_m.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_m.setBounds(389, 152, 109, 106);
		panel.add(btn_m);
		
		JButton btn_4 = new JButton("4");
		btn_4.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_4.setBounds(27, 268, 109, 106);
		panel.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_5.setBounds(148, 268, 109, 106);
		panel.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_6.setBounds(269, 268, 109, 106);
		panel.add(btn_6);
		
		JButton btn_d = new JButton("/");
		btn_d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(o!=null) {
					calcurator();
					p = "";
					o = btn_d.getText();
				}
				o = btn_d.getText();
				operationTest(o);
				p = textField.getText();
				System.out.println(o);
			}
		});
		btn_d.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_d.setBounds(389, 268, 109, 106);
		panel.add(btn_d);
		
		JButton btn_1 = new JButton("1");

		btn_1.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_1.setBounds(27, 390, 109, 106);
		panel.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_2.setBounds(148, 390, 109, 106);
		panel.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_3.setBounds(269, 390, 109, 106);
		panel.add(btn_3);
		
		JButton btn_ma = new JButton("-");
		btn_ma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(o!=null) {
					calcurator();
					p = "";
					o = btn_ma.getText();
				}
				o = btn_ma.getText();
				operationTest(o);
				p = textField.getText();
				System.out.println(o);
			}
		});
		btn_ma.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_ma.setBounds(389, 390, 109, 106);
		panel.add(btn_ma);
		
		JButton btn_0 = new JButton("0");
		btn_0.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_0.setBounds(27, 512, 109, 106);
		panel.add(btn_0);
		
		JButton btn_c = new JButton("C");
		btn_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
			}
		});
		btn_c.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_c.setBounds(148, 512, 109, 106);
		panel.add(btn_c);
		
		JButton btn_e = new JButton("=");
		btn_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("0")||textField.getText().equals("")
						||textField.getText().equals(null))
					return;
				calcurator();
			}
		});
		btn_e.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_e.setBounds(269, 512, 109, 106);
		panel.add(btn_e);
		
		JButton btn_p = new JButton("+");
		btn_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(o!=null) {
					calcurator();
					p = "";
					o = btn_p.getText();
				}
				o = btn_p.getText();
				operationTest(o);
				p = textField.getText();
				System.out.println(o);
				//test(t);
			}
		});
		btn_p.setFont(new Font("±¼¸²", Font.BOLD, 29));
		btn_p.setBounds(389, 512, 109, 106);
		panel.add(btn_p);
		
		
		ButtonEventTest button = new ButtonEventTest(textField, oa);
		btn_1.addActionListener(button);
		btn_2.addActionListener(button);
		btn_0.addActionListener(button);
		btn_3.addActionListener(button);
		btn_4.addActionListener(button);
		btn_5.addActionListener(button);
		btn_6.addActionListener(button);
		btn_7.addActionListener(button);
		btn_8.addActionListener(button);
		btn_9.addActionListener(button);
		
	}

	void operationTest(String os) {
		oa[0] = os;
		o = os;
		p= textField.getText();
		
	}
	
	void calcurator() {
		switch(o) {
			case "+":
				int n = Integer.parseInt(p)	+ Integer.parseInt(textField.getText());
				textField.setText(n+"");
				System.out.println(n);
			break;
			case "-":
				int n2 = Integer.parseInt(p) - Integer.parseInt(textField.getText());
				textField.setText(n2+"");
				System.out.println(n2);
			break;
			case "*":
				int n3 = Integer.parseInt(p) * Integer.parseInt(textField.getText());
				textField.setText(n3+"");
				System.out.println(n3);
			break;
			case "/":
				int n4 = Integer.parseInt(p) / Integer.parseInt(textField.getText());
				textField.setText(n4+"");
				System.out.println(n4);
			break;
		}
	}
}
