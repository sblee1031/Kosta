package view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;

import dto.CustomerDTO;
import dao.CustomerDAO;

public class Return_Car extends JFrame{
	private JFrame frame;
	private JTextField textField;
	
	List<CustomerDTO> return_select_car;
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	CustomerDTO customerDTO = CustomerDTO.getInstance();
	
	String four_Num; // 차량번호 4자리
	
	public Return_Car() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uCF54\uB4DC\uC758 \u7F8E");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(26, 47, 916, 887);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		ImageIcon image1;
		image1 = new ImageIcon("./img/main_image.png");
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(220, 100, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		JLabel lblNewLabel_logo = new JLabel(changIcon);
		lblNewLabel_logo.setBounds(672, 10, 239, 106);
		lblNewLabel_logo.setVerticalTextPosition(JLabel.CENTER);
		lblNewLabel_logo.setHorizontalTextPosition(JLabel.RIGHT);
		lblNewLabel_logo.setVisible(true);
		panel.add(lblNewLabel_logo);
		
		JLabel lblNewLabel = new JLabel("차량 반납");
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(288, 51, 296, 80);
		panel.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("한컴산뜻돋움", Font.BOLD, 40));
		textField.setBounds(288, 201, 339, 85);
		textField.setDocument(new JTextFieldLimit(4));
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(265, 349, 110, 100);
		btn_Border(btnNewButton);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setBounds(395, 349, 110, 100);
		btn_Border(btnNewButton_1);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setBounds(522, 349, 110, 100);
		btn_Border(btnNewButton_2);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setBounds(265, 477, 110, 100);
		btn_Border(btnNewButton_3);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("5");
		btnNewButton_1_1.setBounds(395, 477, 110, 100);
		btn_Border(btnNewButton_1_1);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("6");
		btnNewButton_2_1.setBounds(522, 477, 110, 100);
		btn_Border(btnNewButton_2_1);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_4 = new JButton("1");
		btnNewButton_4.setBounds(265, 606, 110, 100);
		btn_Border(btnNewButton_4);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_1_2 = new JButton("2");
		btnNewButton_1_2.setBounds(395, 606, 110, 100);
		btn_Border(btnNewButton_1_2);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_2 = new JButton("3");
		btnNewButton_2_2.setBounds(522, 606, 110, 100);
		btn_Border(btnNewButton_2_2);
		panel.add(btnNewButton_2_2);
		
		JButton btnNewButton_5 = new JButton("0");
		btnNewButton_5.setBounds(265, 727, 240, 100);
		btn_Border(btnNewButton_5);
		panel.add(btnNewButton_5);

		JButton btnNewButton_2_3 = new JButton("<-");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = textField.getText().length();
				if(t>0) {
					String a = textField.getText().substring(0, t - 1);
					textField.setText(a);
				}
			}
		});
		btnNewButton_2_3.setBounds(522, 727, 110, 100);
		btnNewButton_2_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btnNewButton_2_3.setContentAreaFilled(false);
		btnNewButton_2_3.setBorder(new RoundedBorder(10));
		
		panel.add(btnNewButton_2_3);

		JLabel lblNewLabel_1 = new JLabel("차량번호 네자리 입력");
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 201, 257, 80);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("뒤로가기");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				// main.main(null);
				frame.dispose();
			}
		});
		btnNewButton_6.setBounds(12, 20, 151, 70);
		btn_Border(btnNewButton_6);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_1_3 = new JButton("확인");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				four_Num = textField.getText(); // 입력한 차량 번호 4자리
				if(textField.getText().length()==4) {
					return_select_car = customerDAO.select_One(four_Num);//반납할 차량 정보 조회
					if(return_select_car.size()!=0) { // DB에 값이 존재할 경우
						customerDTO.setCar_Num(four_Num);
						Return_Detail detail = new Return_Detail();
						textField.setText("");//반납화면 이동시 기존 textfield 초기화
						frame.dispose();
					}else {
						JOptionPane jOptionPane = new JOptionPane();
			            jOptionPane.showMessageDialog(null, textField.getText()+"차량이 없습니다. 다시 입력 바랍니다.","" , JOptionPane.INFORMATION_MESSAGE);
			            textField.setText("");
					}
				}else {
					JOptionPane jOptionPane = new JOptionPane();
		            jOptionPane.showMessageDialog(null, "차량번호 4자리를 입력해주세요.","" , JOptionPane.INFORMATION_MESSAGE);
		            textField.setText("");
				}
			}
		});
		btnNewButton_1_3.setBounds(672, 201, 110, 85);
		btnNewButton_1_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btnNewButton_1_3.setContentAreaFilled(false);
		btnNewButton_1_3.setBorder(new RoundedBorder(10));
		panel.add(btnNewButton_1_3);
	}
	
	public void btn_Border(JButton btn) {
		btn.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn.setContentAreaFilled(false);
		btn.setBorder(new RoundedBorder(10));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+btn.getText());
			}
		});
	}
}

//글자수 제한 클래스
class JTextFieldLimit extends PlainDocument implements KeyListener{
	private int limit;
	
	public JTextFieldLimit(int limit) { //글자수 제한 메서드
		super();
		this.limit = limit;

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
