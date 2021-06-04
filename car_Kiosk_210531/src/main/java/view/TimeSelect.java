package view;

import java.awt.Color;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dto.CarDTO;
import dto.ChargeDTO;
import dto.CustomerDTO;
import dao.CarDAO;
import dao.CustomerDAO;


//숫자 콤바 함수 적용, 이용시간 미선택시 메시지 출력, 초기화버튼 및 결제 버튼 코드추가.
//대형차 금액 페이지
public class TimeSelect {

	private JFrame frame;
	
	private JTextField tf_lend_Time;
	private JTextField tf_pay_Money;
	
	private int lend_Time=0;//이용시간
	private int pay_Money=0;//이용금액
	
	private int min=0,hour=0,day=0;
	
	private JButton btn_MinTime;
	private JButton btn_HourTime1;
	private JButton btn_HourTime2; 
	private JButton btn_HourTime3;
	private JButton btn_DayTime1;
	private JButton btn_DayTime2;
	
	private int tmp_Money=0;
	/**
	 * Create the application.
	 */
	public TimeSelect() {
		
		String[] chargeBtn= {"ten_Min","one_Hour","three_Hour","six_Hour","one_Day","three_Day"};
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		CarDAO carDAO = CarDAO.getInstance();
		CustomerDTO customerDTO = CustomerDTO.getInstance();
		ChargeDTO chargeDTO = ChargeDTO.getInstance();
		DecimalFormat df = new DecimalFormat("#,###");// 콤마 전환 메서드
		
		System.out.println(customerDTO.toString());
		
		frame = new JFrame();
		frame.setBackground(new Color(230, 230, 250));
		frame.setResizable(false);
		frame.setTitle("\uCF54\uB4DC\uC758 \u7F8E");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon image1;
		image1 = new ImageIcon("./img/main_image.png");
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		
		JLabel lblNewLabel = new JLabel(changIcon);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(322, 10, 300, 150);
		frame.getContentPane().add(lblNewLabel);
		System.out.println(chargeBtn[0]);
		//10분 버튼
		btn_MinTime = new JButton("<HTML><body style='text-align:center;'>10분<br><h1>"+df.format(chargeDTO.getTen_Min())+"원</h1></body></html>");
		btn_MinTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CalcDay(btn_MinTime);
				tf_lend_Time.setText(Integer.toString(day)+"일 "+Integer.toString(hour)+"시 "+Integer.toString(min)+"분 ");
				pay_Money+=chargeDTO.getTen_Min();
				tf_pay_Money.setText(df.format(pay_Money)+" 원");

			}
		});
		btn_MinTime.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_MinTime.setContentAreaFilled(false);
		btn_MinTime.setBackground(Color.WHITE);
		btn_MinTime.setForeground(Color.BLACK);
		btn_MinTime.setBorder(new RoundedBorder(60));
		btn_MinTime.setBounds(46, 191, 253, 142);
		frame.getContentPane().add(btn_MinTime);
		
		//1시간 버튼
		btn_HourTime1 = new JButton("<HTML><body style='text-align:center;'>1시간<br><h1>"+df.format(chargeDTO.getOne_Hour())+"원</h1></body></html>");
		btn_HourTime1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcDay(btn_HourTime1);
				tf_lend_Time.setText(Integer.toString(day)+"일 "+Integer.toString(hour)+"시 "+Integer.toString(min)+"분 ");
				pay_Money+=chargeDTO.getOne_Hour();
				tf_pay_Money.setText(df.format(pay_Money)+" 원");
			}
		});
		btn_HourTime1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_HourTime1.setContentAreaFilled(false);
		btn_HourTime1.setBackground(Color.WHITE);
		btn_HourTime1.setForeground(Color.BLACK);
		btn_HourTime1.setBorder(new RoundedBorder(60));
		btn_HourTime1.setBounds(345, 191, 253, 142);
		frame.getContentPane().add(btn_HourTime1);
		
		//3시간 버튼
	    btn_HourTime2 = new JButton("<HTML><body style='text-align:center;'>3시간<br><h1>"+df.format(chargeDTO.getThree_Hour())+"원</h1></body></html>");
		btn_HourTime2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcDay(btn_HourTime2);
				tf_lend_Time.setText(Integer.toString(day)+"일 "+Integer.toString(hour)+"시 "+Integer.toString(min)+"분 ");
				pay_Money+=chargeDTO.getThree_Hour();
				tf_pay_Money.setText(df.format(pay_Money)+" 원");
			}
		});
		btn_HourTime2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_HourTime2.setContentAreaFilled(false);
		btn_HourTime2.setBackground(Color.WHITE);
		btn_HourTime2.setForeground(Color.BLACK);
		btn_HourTime2.setBorder(new RoundedBorder(60));
		btn_HourTime2.setBounds(644, 191, 253, 142);
		frame.getContentPane().add(btn_HourTime2);
		
		//6시간 버튼
		btn_HourTime3 = new JButton("<HTML><body style='text-align:center;'>6시간<br><h1>"+df.format(chargeDTO.getSix_Hour())+"원</h1></body></html>");
		btn_HourTime3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcDay(btn_HourTime3);
				tf_lend_Time.setText(Integer.toString(day)+"일 "+Integer.toString(hour)+"시 "+Integer.toString(min)+"분 ");
				pay_Money+=chargeDTO.getSix_Hour();
				tf_pay_Money.setText(df.format(pay_Money)+" 원");
			}
		});
		btn_HourTime3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_HourTime3.setContentAreaFilled(false);
		btn_HourTime3.setBackground(Color.WHITE);
		btn_HourTime3.setForeground(Color.BLACK);
		btn_HourTime3.setBorder(new RoundedBorder(60));
		btn_HourTime3.setBounds(46, 375, 253, 142);
		frame.getContentPane().add(btn_HourTime3);
		
		//1일 버튼
		btn_DayTime1 = new JButton("<HTML><body style='text-align:center;'>1일<br><h1>"+df.format(chargeDTO.getOne_Day())+"원</h1></body></html>");
		btn_DayTime1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcDay(btn_DayTime1);
				tf_lend_Time.setText(Integer.toString(day)+"일 "+Integer.toString(hour)+"시 "+Integer.toString(min)+"분 ");
				pay_Money+=chargeDTO.getOne_Day();
				tf_pay_Money.setText(df.format(pay_Money)+" 원");
			}
		});
		btn_DayTime1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_DayTime1.setContentAreaFilled(false);
		btn_DayTime1.setBackground(Color.WHITE);
		btn_DayTime1.setForeground(Color.BLACK);
		btn_DayTime1.setBorder(new RoundedBorder(60));
		btn_DayTime1.setBounds(345, 375, 253, 142);
		frame.getContentPane().add(btn_DayTime1);
		
		//3일 버튼
		btn_DayTime2 = new JButton("<HTML><body style='text-align:center;'>3일<br><h1>"+df.format(chargeDTO.getThree_Day())+"원</h1></body></html>");
		btn_DayTime2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcDay(btn_DayTime2);
				tf_lend_Time.setText(Integer.toString(day)+"일 "+Integer.toString(hour)+"시 "+Integer.toString(min)+"분 ");
				pay_Money+=chargeDTO.getThree_Day();
				tf_pay_Money.setText(df.format(pay_Money)+" 원");
			}
		});
		btn_DayTime2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_DayTime2.setContentAreaFilled(false);
		btn_DayTime2.setBackground(Color.WHITE);
		btn_DayTime2.setForeground(Color.BLACK);
		btn_DayTime2.setBorder(new RoundedBorder(60));
		btn_DayTime2.setBounds(644, 375, 253, 142);
		frame.getContentPane().add(btn_DayTime2);
		
		//이용시간 라벨
		JLabel lblNewLabel_1 = new JLabel("이용 시간 :");
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 35));
		lblNewLabel_1.setBounds(92, 603, 213, 80);
		frame.getContentPane().add(lblNewLabel_1);
		
		//이용시간 텍스트필드
		tf_lend_Time = new JTextField();
		tf_lend_Time.setBackground(new Color(230, 230, 250));
		tf_lend_Time.setBorder(new LineBorder(Color.black,2,true));
		tf_lend_Time.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		tf_lend_Time.setBounds(320, 603, 541, 80);
		tf_lend_Time.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(tf_lend_Time);
		tf_lend_Time.setColumns(10);
		
		//총금액 라벨
		JLabel lblNewLabel_1_1 = new JLabel("   총 금액 :");
		lblNewLabel_1_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 35));
		lblNewLabel_1_1.setBounds(95, 705, 213, 80);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		//총금액 텍스트필드
		tf_pay_Money = new JTextField();
		tf_pay_Money.setBackground(new Color(230, 230, 250));
		tf_pay_Money.setBorder(new LineBorder(Color.black,2,true));
		tf_pay_Money.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		tf_pay_Money.setColumns(10);
		tf_pay_Money.setBounds(320, 705, 541, 80);
		tf_pay_Money.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(tf_pay_Money);
		
		//초기화 버튼
		JButton btn_Reset = new JButton("초기화");
		btn_Reset.setContentAreaFilled(false);
		btn_Reset.setBorder(new LineBorder(Color.black,3,true));
		btn_Reset.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day=0; hour=0; min=0;
				tf_lend_Time.setText(""); //이용시간 미선택시 결제 방지를 위한 공란
				pay_Money=0;
				tf_pay_Money.setText(""); //이용시간 미선택시 결제 방지를 위한 공란
			}
		});
		btn_Reset.setBounds(246, 835, 220, 75);
		frame.getContentPane().add(btn_Reset);
		
		//결제 버튼
		JButton btn_Pay = new JButton("결제");
		btn_Pay.setContentAreaFilled(false);
		btn_Pay.setBorder(new LineBorder(Color.black,3,true));
		btn_Pay.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				// 이용시간 미선택시 결재 불가
				if(tf_lend_Time.getText().equals("")) {
					JOptionPane jOptionPane = new JOptionPane();
		            jOptionPane.showMessageDialog(null, "이용시간을 선택해주세요.","" , JOptionPane.INFORMATION_MESSAGE);
				}
				else {			
					customerDTO.setLent_Time(tf_lend_Time.getText());
					customerDTO.setPay_Money(pay_Money);
					System.out.println(customerDTO.toString());
					Pay pay = new Pay();
					frame.dispose();
				}
			}
		});
		btn_Pay.setBounds(502, 835, 220, 75);
		frame.getContentPane().add(btn_Pay);
	
		//뒤로가기 버튼
		JButton btnNewButton_6 = new JButton("뒤로가기");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorder(new LineBorder(Color.black,2,true));
		btnNewButton_6.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car_Select carSelect = new Car_Select();
				frame.dispose();
			}
		});
		btnNewButton_6.setBounds(27, 47, 115, 47);
		frame.getContentPane().add(btnNewButton_6);

	}
	

	//이용시간 계산 함수
	private void CalcDay(JButton b) {
		int temp;
		if(b==btn_MinTime) {
			min+=10;
			if(min%60==0) {
				min=0;
				hour+=1;
			}	
		}
	
		if(b==btn_HourTime1) {
			hour+=1;
			if(hour%24==0) {
				hour=0;
				day+=1;
			}else if(24<hour){
				temp = hour-24;
				hour=temp;
				day+=1;
			}		
		}
		if(b==btn_HourTime2) {
			hour+=3;
			if(hour%24==0) {
				hour=0;
				day+=3;
			}else if(24<hour){
				temp = hour-24;
				hour=temp;
				day+=1;
			}		
		}
		if(b==btn_HourTime3) {
			hour+=6;
			if(hour%24==0) {
				hour=0;
				day+=6;
			}else if(24<hour){
				temp = hour-24;
				hour=temp;
				day+=1;		
			}	
		}
		if(b==btn_DayTime1) {
			day+=1;
		}
		if(b==btn_DayTime2) {
			day+=3;
		}	
	}
}

