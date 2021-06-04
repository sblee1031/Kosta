package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.EtchedBorder;

import dao.CustomerDAO;
import dto.CustomerDTO;
import dao.MemberDAO;
import dto.MemberDTO;

import db.DBConnection;
import db.DBClose;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private JTextField tf_Id;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private int pw_check = 0; // 회원가입 패널의 검증 체크용 변수
	private int cnt = 0; // 대여&반납 시 테이블 체크용 변수
	
	private static MemberDAO memberDAO = MemberDAO.getInstance();
	private static MemberDTO memberDTO = MemberDTO.getInstance();
	private static CustomerDAO customerDAO = CustomerDAO.getInstance();
	private static CustomerDTO customerDTO = CustomerDTO.getInstance();
	
	private JPanel main_panel;    // 메인 패널
	private JPanel sign_Up_panel; // 회원가입 패널
	private JPanel member_panel;   // 로그인 패널
	private JPanel select_panel;  // 대여&반납 선택 패널
	
	private JTextField li_Num2;
	private JTextField li_Num3;
	private JTextField li_Num4;
	private JTextField li_Day;
	private JTextField ph_Num;
	private String li_Num;
	String[] local = {"서울(11)", "부산(12)", "경기(13)", "강원(14)", "충북(15)", "충남(16)", "전북(17)", "전남(18)", "경북(19)", "경남(20)", "제주(21)"};

	public static void main(String[] args) {
		// customerDAO.getConnection();
		DBConnection.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Main() {
		initialize();
	}
	
	public void initialize() {
		// 메인 프레임
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("코드의 美");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 팀 로고 이미지
		ImageIcon image1;
		image1 = new ImageIcon("./img/main_image.png");
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(330, 29, 410, 169);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel label_Logo = new JLabel(changIcon);
		label_Logo.setBounds(5, 5, 300, 150);
		panel.add(label_Logo);
		label_Logo.setVerticalTextPosition(JLabel.CENTER);
		label_Logo.setHorizontalTextPosition(JLabel.RIGHT);
		label_Logo.setVisible(true);
		System.out.println("메인로고"+label_Logo);
		
		// 메인 패널 (회원, 비회원 선택창)
		main_panel = new JPanel(); 
		main_panel.setBackground(new Color(230, 230, 250));
		main_panel.setBounds(79, 208, 795, 726);
		main_panel.setVisible(true);
		frame.getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		// 움짤 이미지
		ImageIcon image2 = new ImageIcon("./img/main_gif.gif");
		JLabel label_Img = new JLabel(image2);
		label_Img.setBounds(158, 44, 479, 381);
		label_Img.setVerticalTextPosition(JLabel.CENTER);
		label_Img.setHorizontalTextPosition(JLabel.RIGHT);
		label_Img.setVisible(true);
		main_panel.add(label_Img);
		
		// 회원 버튼
		JButton btn_Member = new JButton("회원");
		btn_Member.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);//비회원 선택시 main페널 비활성 및 비회원 창으로 전환
				login_panel(frame, main_panel);
			}
		});
		btn_Member.setBounds(17, 453, 357, 170);
		btn_Member.setContentAreaFilled(false);
		btn_Member.setBorder(new RoundedBorder(60));
		main_panel.add(btn_Member);
		
		// 비회원 버튼
		JButton btn_Non_member = new JButton("비회원");
		btn_Non_member.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Non_member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (memberDTO.getMember_Id() != null) {
					memberDTO.setMember_Id(null);
					memberDTO.setMember_Pw(null);
					memberDTO.setLi_num(null);
					memberDTO.setLi_Date(null);
					memberDTO.setPh_Num(null);
					memberDTO.setMileage(0);
				}
				main_panel.setVisible(false);//비회원 선택시 main페널 비활성 및 비회원 창으로 전환
				select_Panel(frame, main_panel);
			}
		});
		btn_Non_member.setBounds(426, 453, 357, 170);
		btn_Non_member.setContentAreaFilled(false);
		btn_Non_member.setBorder(new RoundedBorder(60));
		main_panel.add(btn_Non_member);
		
		// 회원가입 버튼
		JButton btn_Sign_up = new JButton("회원가입");
		btn_Sign_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_Up(frame, main_panel);
				main_panel.setVisible(false);
			}
		});
		btn_Sign_up.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Sign_up.setContentAreaFilled(false);
		btn_Sign_up.setBorder(new RoundedBorder(60));
		btn_Sign_up.setBounds(224, 633, 347, 71);
		main_panel.add(btn_Sign_up);  //메인패널 끝
	} // initialize 끝
	
	public Main(JFrame frame, JPanel main_panel) {
		main(local);

	}
	
	// 회원 가입 패널 생성 메소드
	private void sign_Up(JFrame frame, JPanel main_panel) {
		JPanel sign_Up_panel = new JPanel(); 
		sign_Up_panel.setBackground(new Color(230, 230, 250));
		sign_Up_panel.setBounds(79, 208, 795, 726);
		frame.getContentPane().add(sign_Up_panel);
		sign_Up_panel.setLayout(null);
		
		// 회원가입 세부 패널
		JPanel info_panel = new JPanel();
		info_panel.setBackground(new Color(230, 230, 250));
		info_panel.setBounds(47, 359, 577, 269);
		sign_Up_panel.add(info_panel);
		info_panel.setLayout(new GridLayout(6, 2, 5, 5));
		
		// 아이디
		JLabel label_Id = new JLabel("아이디 ");
		label_Id.setHorizontalAlignment(SwingConstants.CENTER);
		label_Id.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		info_panel.add(label_Id);
		
		tf_Id = new JTextField();
		tf_Id.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Id.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		info_panel.add(tf_Id);
		tf_Id.setColumns(10);
		
		// 비밀번호
		JLabel label_Pw = new JLabel("비밀번호");
		label_Pw.setHorizontalAlignment(SwingConstants.CENTER);
		label_Pw.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		info_panel.add(label_Pw);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		info_panel.add(passwordField_1);
		
		// 비밀번호 확인
		JLabel label_Pw_2 = new JLabel("비밀번호 확인");
		label_Pw_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_Pw_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		info_panel.add(label_Pw_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setHorizontalAlignment(SwingConstants.CENTER);
		info_panel.add(passwordField_2);

		JLabel label_Li_num = new JLabel("면허 번호");
		label_Li_num.setHorizontalAlignment(SwingConstants.CENTER);
		label_Li_num.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		info_panel.add(label_Li_num);
		
		// 잘못된 입력 경고 Label
		JLabel alert = new JLabel("");
		alert.setBounds(47, 659, 348, 56);
		alert.setForeground(new Color(153, 153, 255));
		alert.setBackground(new Color(135, 206, 235));
		alert.setHorizontalAlignment(SwingConstants.RIGHT);
		alert.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		sign_Up_panel.add(alert);

		// 동의 1
		JCheckBox chk_Agree = new JCheckBox("(필수) 동의합니다.");
		chk_Agree.setBounds(601, 305, 141, 23);
		chk_Agree.setHorizontalAlignment(SwingConstants.RIGHT);
		chk_Agree.setEnabled(false);	
		chk_Agree.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
		chk_Agree.setContentAreaFilled(false);
		sign_Up_panel.add(chk_Agree);
		
		// 동의 2
		JCheckBox chk_Agree_2 = new JCheckBox("(필수) 동의합니다.");
		chk_Agree_2.setBounds(601, 166, 141, 23);
		chk_Agree_2.setHorizontalAlignment(SwingConstants.RIGHT);
		chk_Agree_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
		chk_Agree_2.setContentAreaFilled(false);
		chk_Agree_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chk_Agree_2.isSelected()==true) {
					chk_Agree.setEnabled(true);	
				}else {
					chk_Agree.setEnabled(false);	
				}
			}
		});
		sign_Up_panel.add(chk_Agree_2);
		
		// 약관 동의
		JLabel textArea = new JLabel("약관 동의");
		textArea.setBounds(48, 10, 160, 46);
		textArea.setHorizontalAlignment(SwingConstants.LEFT);
		textArea.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		textArea.setBackground(new Color(230, 230, 250));
		sign_Up_panel.add(textArea);
		
		JTextArea jtextArea = new JTextArea();
		jtextArea.setBounds(58, 72, 679, 88);
		jtextArea.setEditable(false);
		jtextArea.setFont(new Font("한컴산뜻돋움", Font.BOLD, 16));
		jtextArea.setText("\uC57D\uAD00\uB0B4\uC6A9 1 \n\n 본 정보는 '코드의 美'의 귀속됩니다. "
				+ "\n 귀하의 개인정보 및 활용을 동의합니다.");
		sign_Up_panel.add(jtextArea);
		jtextArea.setColumns(10);
		
		JTextArea jtextArea_1 = new JTextArea();
		jtextArea_1.setBounds(58, 201, 679, 98);
		jtextArea_1.setEditable(false);
		jtextArea_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 16));
		jtextArea_1.setText("\uC57D\uAD00\uB0B4\uC6A9 2 \n\n 귀하는 교통도로법을 준수하여, 안전 운전을 약속합니다."
				+ " \n 사고 시 운전자 본인에게 귀책사유가 발생하며, 민,형사상 책임을 질 수 있습니다.");
		jtextArea_1.setColumns(10);
		sign_Up_panel.add(jtextArea_1);
		
		JPanel LicensePanel = new JPanel();
		LicensePanel.setBackground(new Color(230, 230, 250));
		LicensePanel.setBounds(254, 826, 273, 40);
		info_panel.add(LicensePanel);
		LicensePanel.setLayout(null);
		
		// 면허번호
		JComboBox li_Num1 = new JComboBox();
		li_Num1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
		li_Num1.setModel(new DefaultComboBoxModel(local));
		li_Num1.setBounds(0, 2, 73, 35);
		LicensePanel.add(li_Num1);
		
		JLabel slash1 = new JLabel("-");
		slash1.setHorizontalAlignment(SwingConstants.CENTER);
		slash1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		slash1.setBounds(72, 8, 17, 24);
		LicensePanel.add(slash1);
		
		li_Num2 = new JTextField();
		li_Num2.setHorizontalAlignment(SwingConstants.CENTER);
		li_Num2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 14));
		li_Num2.setFocusable(true);
		li_Num2.setBounds(90, 2, 38, 35);
		LicensePanel.add(li_Num2);
		
		li_Num3 = new JTextField();
		li_Num3.setHorizontalAlignment(SwingConstants.CENTER);
		li_Num3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 14));
		li_Num3.setDropMode(DropMode.INSERT);
		li_Num3.setBounds(144, 2, 86, 35);
		LicensePanel.add(li_Num3);
		
		JLabel slash3 = new JLabel("-");
		slash3.setHorizontalAlignment(SwingConstants.CENTER);
		slash3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		slash3.setBounds(129, 2, 17, 35);
		LicensePanel.add(slash3);
		
		JLabel slash4 = new JLabel("-");
		slash4.setHorizontalAlignment(SwingConstants.CENTER);
		slash4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		slash4.setBounds(229, 2, 17, 35);
		LicensePanel.add(slash4);
		
		li_Num4 = new JTextField();
		li_Num4.setHorizontalAlignment(SwingConstants.CENTER);
		li_Num4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 14));
		li_Num4.setDropMode(DropMode.INSERT);
		li_Num4.setBounds(244, 2, 38, 35);
		LicensePanel.add(li_Num4);
		
		// 발급 일자
		JLabel label_Day = new JLabel("발급 일자");
		label_Day.setHorizontalAlignment(SwingConstants.CENTER);
		label_Day.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		info_panel.add(label_Day);
		
		li_Day = new JTextField();
		li_Day.setHorizontalAlignment(SwingConstants.CENTER);
		li_Day.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		li_Day.setDocument(new JTextFieldLimit(8,alert));
		info_panel.add(li_Day);
		li_Day.setColumns(10);
		
		// 전화 번호
		JLabel label_Phone = new JLabel("전화 번호");
		label_Phone.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phone.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		info_panel.add(label_Phone);
		
		ph_Num = new JTextField();
		ph_Num.setHorizontalAlignment(SwingConstants.CENTER);
		ph_Num.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		ph_Num.setDocument(new JTextFieldLimit(11,alert));
		info_panel.add(ph_Num);
		ph_Num.setColumns(10);
		
		// 비밀번호 검증 버튼
		JButton btnPw = new JButton("PW 검증");
		btnPw.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btnPw.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw = ""; //패스워드 String 변수
				String pw2 = ""; //패스워드확인 String 변수
				char[] secret_pw = passwordField_1.getPassword();
				char[] secret_pw2 = passwordField_2.getPassword();
				for(char cha : secret_pw){ //char 패스워드 String으로 for문으로 가져오기
					Character.toString(cha); 
					pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				for(char cha : secret_pw2){ //char 패스워드 String으로 for문으로 가져오기
					Character.toString(cha); 
					pw2 += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				if(pw.equals(pw2)) {
					JOptionPane jOptionPane = new JOptionPane();
		            jOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.","" , JOptionPane.INFORMATION_MESSAGE);
		            pw_check = 2;
		            
				}else {
					JOptionPane jOptionPane = new JOptionPane();
		            jOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.","" , JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnPw.setBackground(new Color(255, 240, 245));
		btnPw.setContentAreaFilled(false);
		btnPw.setBounds(648, 451, 89, 43);
		sign_Up_panel.add(btnPw);
		
		// 가입하기 버튼
		JButton btnPw_1 = new JButton("가입하기");
		btnPw_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jOptionPane = new JOptionPane();
				String check= "(\\d{3})(\\d{3,4})(\\d{4})";
				String str=ph_Num.getText().replaceAll(check,"$1-$2-$3");
				li_Num = li_Num1.getSelectedItem()+"-"+li_Num2.getText()+"-"+li_Num3.getText()+"-"+li_Num4.getText();

				if(pw_check==0) {
		            jOptionPane.showMessageDialog(null, "ID 검증하기 버튼을 눌러주세요.","" , JOptionPane.INFORMATION_MESSAGE);
				}else if(pw_check==1) {
		            jOptionPane.showMessageDialog(null, "PW 검증하기 버튼을 눌러주세요.","" , JOptionPane.INFORMATION_MESSAGE);
				}else if(pw_check==2) {
		            jOptionPane.showMessageDialog(null, "검증하기 버튼을 눌러주세요.","" , JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(tf_Id.getText().length()!=0 && passwordField_2.getPassword().length !=0 
							&& li_Day.getText().length()!=0 && ph_Num.getText().length()!=0) {//빈칸이 여부 검증 조건문
						String pw = ""; //패스워드 String 변수
						char[] secret_pw = passwordField_1.getPassword();
						for(char cha : secret_pw){ //char 패스워드 String으로 for문으로 가져오기
							Character.toString(cha); 
							pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
					}
					// DB의 Member 테이블에 INSERT 
					memberDTO.setMember_Id(tf_Id.getText());
					memberDTO.setMember_Pw(pw);
					memberDTO.setLi_num(li_Num);
					memberDTO.setLi_Date(li_Day.getText());
					memberDTO.setPh_Num(ph_Num.getText());		
					memberDTO.setMileage(0);
					memberDAO.member_Add();
					
					memberDTO.setMember_Id(null);
					memberDTO.setMember_Pw(null);
					memberDTO.setLi_num(null);
					memberDTO.setLi_Date(null);
					memberDTO.setPh_Num(null);
					memberDTO.setMileage(0);
					
					sign_Up_panel.setVisible(false);
					main_panel.setVisible(true);
					}else {
			            jOptionPane.showMessageDialog(null, "빈칸을 입력해주세요.","" , JOptionPane.INFORMATION_MESSAGE); 
					}
				}
			}
		});
		btnPw_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btnPw_1.setBorder(new RoundedBorder(60));
		btnPw_1.setBackground(new Color(230, 230, 250));
		btnPw_1.setBounds(601, 659, 182, 57);
		sign_Up_panel.add(btnPw_1);
		
		// 뒤로가기 버튼
		JButton btn_Back = new JButton("뒤로가기");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_Up_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		btn_Back.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btn_Back.setBorder(new RoundedBorder(60));
		btn_Back.setBackground(new Color(230, 230, 250));
		btn_Back.setBounds(407, 659, 182, 57);
		sign_Up_panel.add(btn_Back);
		
		JButton btn_id_check = new JButton("ID 검증");
		btn_id_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jOptionPane = new JOptionPane();
				memberDTO.setMember_Id(tf_Id.getText());
				if(memberDAO.member_Id_Check(memberDTO.getMember_Id()) == false) {
		            jOptionPane.showMessageDialog(null, "사용할 수 있는 아이디 입니다.","" , JOptionPane.INFORMATION_MESSAGE);
		            pw_check = 1;
				}else {
		            jOptionPane.showMessageDialog(null, "사용할 수 없는 아이디 입니다.\n 다른 아이디를 입력해주세요.","" , JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_id_check.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btn_id_check.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_id_check.setBackground(new Color(230, 230, 250));
		btn_id_check.setContentAreaFilled(false);
		btn_id_check.setBounds(648, 359, 89, 43);
		sign_Up_panel.add(btn_id_check);
		
		// 약관동의 & 발급일자 & 전화번호 검증 버튼
		JButton btn_Auth = new JButton("검증하기");
		btn_Auth.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btn_Auth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jOptionPane = new JOptionPane();
				String phCheck="^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})(\\d{4})$";
				System.out.println("면허번호 : "+li_Num1.getSelectedItem() +" - "+li_Num2.getText()+" - "+li_Num3.getText()+" - "+li_Num4.getText());
				 if((chk_Agree.isSelected()==false)||(chk_Agree_2.isSelected()==false))
		         {
		            jOptionPane.showMessageDialog(null, "약관 동의를 체크해주세요.","" , JOptionPane.INFORMATION_MESSAGE);
		         }
				 else if(dateCheck(li_Day.getText(),"yyyyMMdd")==false&&li_Day.getText().length()!=0){//날짜 형식 검증
			         jOptionPane.showMessageDialog(null, "유효하지 않은 날짜입니다.","" , JOptionPane.INFORMATION_MESSAGE);
		         }
				 else if(Pattern.matches(phCheck, ph_Num.getText())==false&&li_Day.getText().length()!=0){//전화번호 형식 검증
			         jOptionPane.showMessageDialog(null, "전화번호가 올바른 형식이 아닙니다.","" , JOptionPane.INFORMATION_MESSAGE);
		         }else{
			         jOptionPane.showMessageDialog(null, "정상적으로 입력되었습니다.","" , JOptionPane.INFORMATION_MESSAGE);
		        	 btnPw_1.setVisible(true);
		        	 pw_check = 3;
		         }
			}
		});
		btn_Auth.setContentAreaFilled(false);
		btn_Auth.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_Auth.setBackground(new Color(255, 240, 245));
		btn_Auth.setBounds(648, 585, 89, 43);
		sign_Up_panel.add(btn_Auth);
		
		li_Num2.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); 
		li_Num3.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); 
		li_Num4.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num));
		li_Day.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); 
		ph_Num.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); 

		li_Num2.requestFocus();
	}
	
	// 로그인 버튼 처리 메서드
	private void login_Check(JPanel member_panel, String id, String pw) {
		ArrayList<String> login_info = memberDAO.MemberMatch(id, pw); // DB접속하여 해당 login ID 정보 검색
		JOptionPane jOptionPane = new JOptionPane();
		if(login_info.size() == 0) {
            jOptionPane.showMessageDialog(null, "등록되지 않은 아이디 입니다.","" , JOptionPane.INFORMATION_MESSAGE);
		}else if(login_info.size() == 1) {
            jOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.","" , JOptionPane.INFORMATION_MESSAGE);
		}else {
			
			String sentence = String.format("환영합니다. %s 님", login_info.get(0));
//			JLabel welcome_Label = new JLabel(sentence);
//			welcome_Label.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
			jOptionPane.showMessageDialog(null, sentence, "", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("=====정상 로그인=====");
			System.out.println("login_info"+login_info.toString());
			textField.setText("");// 아이디 비번 필드 초기화
			passwordField.setText("");

			customerDTO.setAgree(true); 
			customerDTO.setLi_num(login_info.get(2));
			customerDTO.setLi_Date(login_info.get(3));
			customerDTO.setPh_Num(login_info.get(4));
			
			memberDTO.setMember_Id(login_info.get(0));
			memberDTO.setMember_Pw(login_info.get(1));
			memberDTO.setLi_num(login_info.get(2));
			memberDTO.setLi_Date(login_info.get(3));
			memberDTO.setPh_Num(login_info.get(4));
			memberDTO.setMileage(Integer.parseInt(login_info.get(5)));
			System.out.println(memberDTO.toString());

			member_panel.setVisible(false);
			select_Panel(frame, member_panel);
		}
	}
	
	// 회원 클릭시 활성화 메서드
	private void login_panel(JFrame frame, JPanel main_panel) {
		JPanel member_panel = new JPanel(); // 회원인 경우 패널 (회원, 비회원 선택창)
		member_panel.setBackground(new Color(230, 230, 250));
		member_panel.setBounds(79, 208, 795, 726);
		frame.getContentPane().add(member_panel);
		member_panel.setLayout(null);
		
		ImageIcon image2 = new ImageIcon("./img/main_gif.gif");
		JLabel lblNewLabel2 = new JLabel(image2);
		lblNewLabel2.setBounds(158, 44, 479, 381);
		lblNewLabel2.setVerticalTextPosition(JLabel.CENTER);
		lblNewLabel2.setHorizontalTextPosition(JLabel.RIGHT);
		lblNewLabel2.setVisible(true);
		member_panel.add(lblNewLabel2);
		
		JLabel label_id = new JLabel("아이디");
		label_id.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		label_id.setHorizontalAlignment(SwingConstants.CENTER);
		label_id.setBounds(102, 453, 131, 53); // 532 453 79
		member_panel.add(label_id);
		
		JLabel label_pw = new JLabel("비밀번호");
		label_pw.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		label_pw.setHorizontalAlignment(SwingConstants.CENTER);
		label_pw.setBounds(102, 519, 131, 53); 
		member_panel.add(label_pw);
		
		textField = new JTextField(); //아이디 텍스트 필드
		textField.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(293, 453, 215, 53);
		member_panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField(); //패스워드 필드
		passwordField.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(293, 519, 215, 53);
		member_panel.add(passwordField);
		
		JButton button_login = new JButton("로그인");
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw = ""; //패스워드 String 변수
				char[] secret_pw = passwordField.getPassword();
				for(char cha : secret_pw){ //char 패스워드 String으로 for문으로 가져오기
					Character.toString(cha); 
					pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				login_Check(member_panel,textField.getText(), pw); //로그인 DB체크 메서드
			}
		});
		button_login.setBackground(new Color(230, 230, 250));
		button_login.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		button_login.setBounds(541, 453, 190, 53);
		button_login.setBorder(new RoundedBorder(60));
		member_panel.add(button_login);
		
		JButton button_login_1 = new JButton("뒤로");
		button_login_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		button_login_1.setBorder(new RoundedBorder(60));
		button_login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (memberDTO.getMember_Id() != null) {
					memberDTO.setMember_Id(null);
					memberDTO.setMember_Pw(null);
					memberDTO.setLi_num(null);
					memberDTO.setLi_Date(null);
					memberDTO.setPh_Num(null);
					memberDTO.setMileage(0);
				}
				customerDTO.setAgree(false); 
				customerDTO.setLi_num(null);
				customerDTO.setLi_Date(null);
				customerDTO.setPh_Num(null);
				
				member_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		button_login_1.setBackground(new Color(230, 230, 250));
		button_login_1.setBounds(541, 519, 190, 53);
		member_panel.add(button_login_1);
	}
	
	//비회원 클릭시 활성화 창
	// 대여&반납 선택 패널 활성화 메소드
	public void select_Panel(JFrame frame, JPanel main_panel) {
		JPanel select_Panel = new JPanel(); //비회원인 경우 패널 (회원, 비회원 선택창)
		select_Panel.setBackground(new Color(230, 230, 250));
		select_Panel.setBounds(79, 208, 795, 726);
		frame.getContentPane().add(select_Panel);
		select_Panel.setLayout(null);
		
		ImageIcon image2 = new ImageIcon("./img/main_gif.gif");//메인 이미지
		JLabel lblNewLabel2 = new JLabel(image2);
		lblNewLabel2.setBounds(158, 44, 479, 381);
		lblNewLabel2.setVerticalTextPosition(JLabel.CENTER);
		lblNewLabel2.setHorizontalTextPosition(JLabel.RIGHT);
		lblNewLabel2.setVisible(true);
		select_Panel.add(lblNewLabel2);

		JButton btnNewButton = new JButton("반납");
		btnNewButton.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lisence_Num = memberDTO.getLi_num();
				List<CustomerDTO> customer_All = customerDAO.select_All();
				cnt = 0;

				for (CustomerDTO select : customer_All) { 
					if(select.getLi_num().equals(lisence_Num) && select.isKey()) {
						cnt += 1;
					}
				}
				if (lisence_Num != null && cnt == 0 ) {	
					JOptionPane jOptionPane = new JOptionPane();
		            jOptionPane.showMessageDialog(null, "반납할 차량이 없습니다.\n 대여를 먼저 진행해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					Return_Car return_car = new Return_Car();
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(426, 453, 357, 170);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new RoundedBorder(60));
		select_Panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("대여");
		btnNewButton_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lisence_Num = memberDTO.getLi_num();
				List<CustomerDTO> customer_All = customerDAO.select_All();
				cnt = 0;

				for (CustomerDTO select : customer_All) { 
					if(select.getLi_num().equals(lisence_Num) && select.isKey()) {
						cnt += 1;
					}
				}
				if (lisence_Num != null && cnt > 0 ) {	
					JOptionPane jOptionPane = new JOptionPane();
		            jOptionPane.showMessageDialog(null, "현재 대여중인 차량이 존재합니다.\n 반납을 먼저 진행해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if (customerDTO.isAgree() == true) {
						Car_Select select = new Car_Select();
						frame.dispose();
					}
					else {
						Agreement agree = new Agreement();
						frame.dispose();
					}
				}
			}
		});
		btnNewButton_1.setBounds(17, 453, 357, 170);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(new RoundedBorder(60));
		select_Panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("뒤로");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (memberDTO.getMember_Id() != null) {
					memberDTO.setMember_Id(null);
					memberDTO.setMember_Pw(null);
					memberDTO.setLi_num(null);
					memberDTO.setLi_Date(null);
					memberDTO.setPh_Num(null);
					memberDTO.setMileage(0);
				}
				customerDTO.setAgree(false); 
				customerDTO.setLi_num(null);
				customerDTO.setLi_Date(null);
				customerDTO.setPh_Num(null);
				select_Panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(new RoundedBorder(60));
		btnNewButton_2.setBounds(224, 633, 347, 71);
		select_Panel.add(btnNewButton_2);
	}
	
	public static boolean dateCheck(String date, String format) {
	    SimpleDateFormat dateFormatParser = new SimpleDateFormat(format, Locale.KOREA);
	    dateFormatParser.setLenient(false);
	    try {
	        dateFormatParser.parse(date);
	        return true;
	    } catch (Exception Ex) {
	        return false;
	    }
	}
	
	class JTextFieldLimit extends PlainDocument implements KeyListener{//글자수 제한 클래스
		private int limit;
		private JLabel alert;
		private JTextField text;
		private JTextField text2;
		private JTextField text3;
		private JTextField li_Day;
		private JTextField ph_Num;
		
		public JTextFieldLimit(int limit, JLabel alert, JTextField text,JTextField text2, JTextField text3, JTextField li_Day, JTextField ph_Num) {
			this.limit = limit;
			this.alert = alert;
			this.text = text;
			this.text2 = text2;
			this.text3 = text3;
			this.li_Day = li_Day;
			this.ph_Num = ph_Num;
		}
		
		public JTextFieldLimit(int limit, JLabel alert) { //글자수 제한 메서드
			super();
			this.limit = limit;
			this.alert = alert;

		}
		
		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
		{
			if(str == null)
				return;
			if(getLength() + str.length()<=limit)
				super.insertString(offset, str, attr);
		}
		@Override 
		public void keyTyped(KeyEvent e) { 
			char c = e.getKeyChar();
			  if(!Character.isDigit(c)) {
				  e.consume();
				  alert.setText("숫자를 입력해주세요.");
			  }else if(Character.isDigit(c)) {
				  if(text.getText().length()==1) {text2.requestFocus();}
				  if(text2.getText().length()==5) {text3.requestFocus();} 
				  if(text3.getText().length()==1||li_Day.hasFocus()==true) {li_Day.requestFocus(); alert.setText("yyyymmdd 형식으로 입력해주세요.");}
				  if(li_Day.getText().length()==7||ph_Num.hasFocus()==true) {ph_Num.requestFocus(); alert.setText("-을 빼고 숫자만 입력해주세요.");}
			  }else {
				  alert.setText("");
			  }
			  return;
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}//클래스



