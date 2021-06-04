package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

import view.RoundedBorder;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.CustomerDAO;
import dto.CustomerDTO;

public class Agreement extends JFrame{
	
	private JFrame frame;
	private JTextArea jtextArea;
	private JTextArea jtextArea_1;
	private ImageIcon image1;
	
	private JTextField li_Num2;
	private JTextField li_Num3;
	private JTextField li_Num4;
	private JTextField li_Day;
	private JTextField ph_Num;

	private String li_Num;
	String[] local = {"서울(11)", "부산(12)", "경기(13)", "강원(14)", "충북(15)", "충남(16)", "전북(17)", "전남(18)", "경북(19)", "경남(20)", "제주(21)"};

	public Agreement() {
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		CustomerDTO customerDTO = CustomerDTO.getInstance();
		
		System.out.println(customerDTO.toString());
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uCF54\uB4DC\uC758 \u7F8E");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chk_Agree = new JCheckBox("(필수) 동의합니다.");
		chk_Agree.setEnabled(false);	
		chk_Agree.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
		chk_Agree.setBounds(589, 479, 141, 23);
		chk_Agree.setContentAreaFilled(false);
		frame.getContentPane().add(chk_Agree);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("(필수) 동의합니다.");
		chckbxNewCheckBox.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
		chckbxNewCheckBox.setBounds(589, 336, 141, 23);
		chckbxNewCheckBox.setContentAreaFilled(false);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(chckbxNewCheckBox.isSelected()==true) {
					chk_Agree.setEnabled(true);	
				}else {
					chk_Agree.setEnabled(false);	
				}
			}
		});
		frame.getContentPane().add(chckbxNewCheckBox);
		
		jtextArea = new JTextArea();
		jtextArea.setEditable(false);
		jtextArea.setFont(new Font("한컴산뜻돋움", Font.BOLD, 16));
		jtextArea.setText("\uC57D\uAD00\uB0B4\uC6A9 1 \n\n 본 정보는 '코드의 美'의 귀속됩니다. "
				+ "\n 귀하의 개인정보 및 활용을 동의합니다.");
		jtextArea.setBounds(160, 238, 577, 88);
		frame.getContentPane().add(jtextArea);
		jtextArea.setColumns(10);
		
		jtextArea_1 = new JTextArea();
		jtextArea_1.setEditable(false);
		jtextArea_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 16));
		jtextArea_1.setText("\uC57D\uAD00\uB0B4\uC6A9 2 \n\n 귀하는 교통도로법을 준수하여, 안전 운전을 약속합니다."
				+ " \n 사고 시 운전자 본인에게 귀책사유가 발생하며, 민,형사상 책임을 질 수 있습니다.");
		jtextArea_1.setColumns(10);
		jtextArea_1.setBounds(160, 365, 577, 98);
		frame.getContentPane().add(jtextArea_1);

		JLabel textArea = new JLabel("\uC774\uC6A9 \uD544\uC218 \uB3D9\uC758");
		textArea.setHorizontalAlignment(SwingConstants.CENTER);
		textArea.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		textArea.setBackground(new Color(230, 230, 250));
		textArea.setBounds(144, 182, 160, 46);
		frame.getContentPane().add(textArea);

		JLabel Label_li_Num;
		Label_li_Num = new JLabel("\uBA74\uD5C8 \uBC88\uD638");
		Label_li_Num.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		Label_li_Num.setBounds(160, 516, 81, 24);
		frame.getContentPane().add(Label_li_Num);
		
		JLabel label_li_Day = new JLabel("\uBC1C\uAE09 \uC77C\uC790");
		label_li_Day.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		label_li_Day.setBounds(160, 575, 81, 24);
		frame.getContentPane().add(label_li_Day);

		image1 = new ImageIcon(".\\img\\main_image.png");
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		JLabel lblNewLabel = new JLabel(changIcon);
		
		lblNewLabel.setBounds(295, 10, 300, 150);
		lblNewLabel.setVerticalTextPosition(JLabel.CENTER);
		lblNewLabel.setHorizontalTextPosition(JLabel.RIGHT);
		lblNewLabel.setVisible(true);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_ph_Num = new JLabel("휴 대 폰");
		label_ph_Num.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		label_ph_Num.setBounds(160, 632, 81, 24);
		frame.getContentPane().add(label_ph_Num);

		JLabel alert = new JLabel(""); // 문자 입력시 경고 라벨
		alert.setBounds(160, 710, 423, 56);
		alert.setForeground(new Color(153, 153, 255));
		alert.setBackground(new Color(135, 206, 235));
		alert.setHorizontalAlignment(SwingConstants.LEFT);
		alert.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		frame.getContentPane().add(alert);
		
		li_Day = new JTextField();
		li_Day.setHorizontalAlignment(SwingConstants.CENTER);
		li_Day.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		li_Day.setBounds(256, 575, 199, 35);
		li_Day.setDocument(new JTextFieldLimit(8,alert));
		frame.getContentPane().add(li_Day);
		
		ph_Num = new JTextField();
		ph_Num.setHorizontalAlignment(SwingConstants.CENTER);
		ph_Num.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		ph_Num.setBounds(256, 632, 199, 35);
		ph_Num.setDocument(new JTextFieldLimit(11,alert));
		frame.getContentPane().add(ph_Num);
		
		li_Num2 = new JTextField();
		li_Num2.setHorizontalAlignment(SwingConstants.CENTER);
		li_Num2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 14));
		li_Num2.setBounds(346, 514, 38, 35);
		li_Num2.setDocument(new JTextFieldLimit(2,alert)); //Text상자 글자수 제한
		li_Num2.setFocusable(true); //시작시 커서 깜빡임
		frame.getContentPane().add(li_Num2);

		li_Num3 = new JTextField();
		li_Num3.setHorizontalAlignment(SwingConstants.CENTER);
		li_Num3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 14));
		li_Num3.setDropMode(DropMode.INSERT);
		li_Num3.setDocument(new JTextFieldLimit(6,alert)); //Text상자 글자수 제한
		li_Num3.setBounds(401, 514, 73, 35);
		frame.getContentPane().add(li_Num3);
		
		li_Num4 = new JTextField();
		li_Num4.setHorizontalAlignment(SwingConstants.CENTER);
		li_Num4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 14));
		li_Num4.setDropMode(DropMode.INSERT);
		li_Num4.setDocument(new JTextFieldLimit(2,alert)); //Text상자 글자수 제한
		li_Num4.setBounds(491, 514, 38, 35);
		frame.getContentPane().add(li_Num4);

		JComboBox li_Num1 = new JComboBox();
		li_Num1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
		li_Num1.setModel(new DefaultComboBoxModel(local));
		li_Num1.setBounds(256, 514, 73, 35);
		frame.getContentPane().add(li_Num1);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(329, 514, 17, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(384, 514, 17, 35);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("-");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(474, 514, 17, 35);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1 = new JButton("다음");
		btnNewButton_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String check= "(\\d{3})(\\d{3,4})(\\d{4})";
				String str=ph_Num.getText().replaceAll(check,"$1-$2-$3");
				li_Num = li_Num1.getSelectedItem()+"-"+li_Num2.getText()+"-"+li_Num3.getText()+"-"+li_Num4.getText();//찐 라이센스 번호
				customerDTO.setAgree(chk_Agree.isSelected());
				customerDTO.setLi_num(li_Num);
				customerDTO.setLi_Date(li_Day.getText());
				customerDTO.setPh_Num(ph_Num.getText());
				System.out.println(customerDTO.toString());
				Car_Select select = new Car_Select();
				frame.dispose();			
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(new RoundedBorder(60));
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(550, 879, 208, 56);
		frame.getContentPane().add(btnNewButton_1);
	
		li_Num2.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); //Text상자 커서이동
		li_Num3.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); //TText상자 커서이동
		li_Num4.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); //Text상자 커서이동
		li_Day.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); //Text상자 커서이동
		ph_Num.addKeyListener(new JTextFieldLimit(2,alert,li_Num2,li_Num3,li_Num4, li_Day, ph_Num)); //Text상자 커서이동
	
		li_Num2.requestFocus();//시작시 커서 포커스 포인터;
	
		JButton btnNewButton = new JButton("검증하기");
		btnNewButton.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String phCheck="^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})(\\d{4})$";
				JOptionPane jOptionPane = new JOptionPane();
				System.out.println("면허번호 : "+li_Num1.getSelectedItem() +" - "+li_Num2.getText()+" - "+li_Num3.getText()+" - "+li_Num4.getText());
	
				if((chckbxNewCheckBox.isSelected()==false)||(chk_Agree.isSelected()==false))
		        {
					jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "약관 동의를 확인하세요","" , JOptionPane.INFORMATION_MESSAGE);
				} else if((li_Num2.getText().length()==0||li_Num3.getText().length()==0||li_Num4.getText().length()==0)|| li_Day.getText().length()==0&&ph_Num.getText().length()==0) {
		        	 jOptionPane = new JOptionPane();
					 jOptionPane.showMessageDialog(null, "빈칸을 입력해주세요.","" , JOptionPane.INFORMATION_MESSAGE);
		        } else if(dateCheck(li_Day.getText(),"yyyyMMdd")==false&&li_Day.getText().length()!=0){//날짜 형식 검증
					 jOptionPane = new JOptionPane();
					 jOptionPane.showMessageDialog(null, "유효하지 않은 날짜입니다.","" , JOptionPane.INFORMATION_MESSAGE);
		        }
				 else if(Pattern.matches(phCheck, ph_Num.getText())==false&&ph_Num.getText().length()!=0){//전화번호 형식 검증
					 jOptionPane = new JOptionPane();
					 jOptionPane.showMessageDialog(null, "번호 형식이 아닙니다.","" , JOptionPane.INFORMATION_MESSAGE);
		         }else {
		        	btnNewButton_1.setVisible(true);//약관 동의 시 다음 버튼 활성화
		         }
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new RoundedBorder(60));
		btnNewButton.setBounds(613, 600, 188, 56);
		frame.getContentPane().add(btnNewButton);
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
		public void keyTyped(KeyEvent e) { //숫자만 입력 받는 메서드 override
			// TODO Auto-generated method stub
			char c = e.getKeyChar();
			  if(!Character.isDigit(c)) {
				  e.consume();
				  alert.setText("숫자를 입력해주세요.");
			  }else if(Character.isDigit(c)) {
				  alert.setText("정상");
				  if(text.getText().length()==1) text2.requestFocus(); //li_Num2 자리수 채워지면 커서가 넘어감
				  if(text2.getText().length()==5) text3.requestFocus(); //li_Num3 자리수 채워지면 커서가 넘어감
				  if(text3.getText().length()==1||li_Day.hasFocus()==true) {li_Day.requestFocus(); alert.setText("yyyymmdd 형식으로 입력해주세요.");} //li_Num4 자리수 채워지면 커서가 넘어감
				  if(li_Day.getText().length()==7||ph_Num.hasFocus()==true) {ph_Num.requestFocus(); alert.setText("-을 빼고 숫자만 입력해주세요.");} //li_Day 자리수 채워지면 커서가 넘어감
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
	
}
	
