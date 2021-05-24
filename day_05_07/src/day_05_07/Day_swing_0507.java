package day_05_07;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Day_swing_0507 {

	private JFrame frame;
	private JTextField textField;
	private JButton btn_0;
	private boolean[] is_op = {true};
	private boolean oper_is=true;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Day_swing_0507 window = new Day_swing_0507();
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
	public Day_swing_0507() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	JPanel[] arrayPanel;
	JPanel currentPanel;
	
	public void bool(JPanel panel, Boolean bool,JPanel panel2,JPanel panel3) {
		
		panel.setVisible(bool);
		panel2.setVisible(!bool);
		panel3.setVisible(!bool);
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("05_07");
		frame.setBounds(100, 100, 537, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		cal_panel();
//		createNumButton(panel);
//		createNumOp(panel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(6, 6, 503, 642);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel Menu_A = new JPanel();
		Menu_A.setBackground(Color.PINK);
		Menu_A.setBounds(6, 6, 500, 500);
		mainPanel.add(Menu_A);
		Menu_A.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Menu_A");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 23, 460, 346);
		Menu_A.add(lblNewLabel);
		
		JPanel Menu_B= new JPanel();
		Menu_B.setBackground(Color.ORANGE);
		Menu_B.setBounds(6, 6, 500, 500);
		mainPanel.add(Menu_B);
		Menu_B.setLayout(null);
		
		JLabel lblNewLabel2 = new JLabel("Menu_B");
		lblNewLabel2.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel2.setBackground(Color.PINK);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(12, 23, 460, 346);
		Menu_B.add(lblNewLabel2);
		
		JPanel Menu_C = new JPanel();
		Menu_C.setBackground(Color.CYAN);
		Menu_C.setBounds(6, 6, 500, 500);
		mainPanel.add(Menu_C);
		Menu_C.setLayout(null);
		
		JLabel lblNewLabel3 = new JLabel("Menu_C");
		lblNewLabel3.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel3.setBackground(Color.PINK);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3.setBounds(12, 23, 460, 346);
		Menu_C.add(lblNewLabel3);
		
		JButton btnA = new JButton("btn_A");
		btnA.setFont(new Font("굴림", Font.BOLD, 20));
		btnA.setBounds(62, 564, 116, 52);
		mainPanel.add(btnA);
		
		JButton btnB = new JButton("btn_B");
		btnB.setFont(new Font("굴림", Font.BOLD, 20));
		btnB.setBounds(190, 564, 116, 52);
		mainPanel.add(btnB);
		
		JButton btnC = new JButton("btn_C");
		btnC.setFont(new Font("굴림", Font.BOLD, 20));
		btnC.setBounds(317, 564, 116, 52);
		mainPanel.add(btnC);
		

		
		arrayPanel = new JPanel[] {Menu_A,Menu_B,Menu_C};
		
		Menu_A.setVisible(false);
		Menu_B.setVisible(true);
		Menu_C.setVisible(false);
		
		currentPanel = Menu_B;
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cal_panel();
//				for (int i = 0; i < arrayPanel.length; i++) {
//					if(arrayPanel[i].isVisible()) {
//						arrayPanel[i].setVisible(!arrayPanel[i].isVisible());
//						System.out.println(arrayPanel[i].isVisible());
//						break;
//					}
//					
//					System.out.println(arrayPanel[i].isVisible());
//				}
			}
		});
		btnNewButton.setBounds(12, 586, 67, 46);
		mainPanel.add(btnNewButton);
		
		
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentPanel.setVisible(!currentPanel.isVisible());
				currentPanel = Menu_B;
				Menu_A.setVisible(!Menu_A.isVisible());
				
				

//				bool(Menu_A,true,Menu_B,Menu_C);
				
//				for (int i = 0; i < arrayPanel.length; i++) {
//					if(arrayPanel[i].isVisible()) {
//						arrayPanel[i].setVisible(!arrayPanel[i].isVisible());
//						Menu_A.setVisible(!Menu_A.isVisible());
//						break;
//					}
//				}
			}
		});
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentPanel.setVisible(!currentPanel.isVisible());
				currentPanel = Menu_C;
				Menu_B.setVisible(!Menu_B.isVisible());
				
//				for (int i = 0; i < arrayPanel.length; i++) {
//					if(arrayPanel[i].isVisible()) {
//						arrayPanel[i].setVisible(!arrayPanel[i].isVisible());
//						Menu_B.setVisible(!Menu_B.isVisible());
//						break;
//					}
//				}
				
			}
		});
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentPanel.setVisible(!currentPanel.isVisible());
				currentPanel = Menu_A;
				Menu_A.setVisible(!Menu_A.isVisible());
				

//				for (int i = 0; i < arrayPanel.length; i++) {
//					if(arrayPanel[i].isVisible()) {
//						arrayPanel[i].setVisible(!arrayPanel[i].isVisible());
//						Menu_C.setVisible(!Menu_C.isVisible());
//						break;
//					}
//				}
			}
		});
		
		
		
	}
	
	
	public void cal_panel() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(12, 27, 476, 612);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	}
	
	String op = "";
	int p = 0;
	public int getP() {
		return p;
	}

	public void setP(int p) {//이전 숫자 저장 메서드
		this.p = p;
	}

	String getOp() {
		System.out.println(getP());
		System.out.println(op);
		return op;
	}
	void setOp(String op) {// 사칙연산자 저장 메서드
//		if(getOp()!=null && getP()!=0) {
//			calcurator();
//			setP(0);
//		}
		
			if(getOp()!=null && getP()!=0 &&oper_is == true) {
				calcurator();
				setP(Integer.parseInt(textField.getText()));
			}
		setP(Integer.parseInt(textField.getText()));
		is_op[0] = false;
		this.op = op;
		
	}
	void calcurator() { // '='시 연산되는 함수
		

		switch(getOp()) {
			case "*":
				int n2 = getP() *Integer.parseInt(textField.getText());
				textField.setText(n2+"");
				break;
			case "-":
				int n3 = getP() -Integer.parseInt(textField.getText());
				textField.setText(n3+"");
				break;
			case "+":
				int n = getP() +Integer.parseInt(textField.getText());
				textField.setText(n+"");
				break;
			case "/":
				int n4 = getP() /Integer.parseInt(textField.getText());
				textField.setText(n4+"");
				break;
		}
		
		
	}
	
	void createNumOp(JPanel panel) {
		String[] op = {"*","/","-","+","=","C"};
		for (int i = 0; i < 6; i++) {
			JButton btt_7 = new JButton(op[i]);

			btt_7.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			if(i ==4) { // = 버튼 호출
				System.out.println(btt_7.getText());
				btt_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						calcurator();
						oper_is = false;
					}
				});
				btt_7.setBounds(245, 450, 100, 100);
			}
			else if (i==5) {  // C버튼 호출
				btt_7.setBounds(135, 450, 100, 100);
				btt_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setOp("");
						textField.setText("0");
						p=0;
						oper_is = false;
					}
				});
			}
			else {  //사칙연산 버튼 클릭 호출
				btt_7.setBounds(355, 120+(110*i), 100, 100);
				
				btt_7.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setOp(e.getActionCommand());
						oper_is = false;
					}
				});
			}
			panel.add(btt_7);
		}
			
	}
	
	void createNumButton(JPanel panel) { // 숫자 번호 판 생성
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("굴림", Font.BOLD, 27));
		textField.setBounds(25, 10, 407, 68);
		panel.add(textField);
		textField.setColumns(10);
		
		ButtonEventTest button = new ButtonEventTest(textField, is_op, oper_is);
		
		btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(e.getActionCommand());
				oper_is = true;
			}
		});
		btn_0.setBounds(25, 450, 100, 100);
		btn_0.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panel.add(btn_0);
		
		int[] nums = {7,8,9,4,5,6,1,2,3};
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				JButton btn_7 = new JButton(nums[(i)+(j*3)]+"");
				btn_7.addActionListener(button);
				btn_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						oper_is = true;
					}
				});
				btn_7.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
				btn_7.setBounds(25+(110*i), 120+(110*j), 100, 100);
				panel.add(btn_7);
				
			}
			
		}
		
	}
}
