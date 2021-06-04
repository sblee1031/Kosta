package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import dao.CustomerDAO;
import dto.CustomerDTO;
import dto.MemberDTO;

public class Car_Select extends JFrame{
	
	private JFrame frame;
	private int back=0;
	
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	CustomerDTO customerDTO = CustomerDTO.getInstance();
	MemberDTO memberDTO = MemberDTO.getInstance();

	public Car_Select() {
		
		System.out.println(customerDTO.toString());
		System.out.println(memberDTO.toString());
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("코드의 美");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon image1;
		image1 = new ImageIcon(".\\img\\main_image.png");
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(200, 80, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		JLabel lblNewLabel_logo = new JLabel(changIcon);
		lblNewLabel_logo.setBounds(727, 18, 215, 82);
		lblNewLabel_logo.setVerticalTextPosition(JLabel.CENTER);
		lblNewLabel_logo.setHorizontalTextPosition(JLabel.RIGHT);
		lblNewLabel_logo.setVisible(true);
		frame.getContentPane().add(lblNewLabel_logo);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uC870\uC0AC\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 40));
		lblNewLabel.setBounds(267, 22, 438, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(12, 110, 930, 756);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		//panel.setVisible(true);
		
		JPanel panel_hyundai = new JPanel();
		panel_hyundai.setBackground(new Color(100, 149, 237));
		panel_hyundai.setBounds(12, 110, 930, 756);
		frame.getContentPane().add(panel_hyundai);
		panel_hyundai.setLayout(null);
		panel_hyundai.setVisible(false);
		
		JPanel panel_kia = new JPanel();
		panel_kia.setBackground(new Color(165, 42, 42));
		panel_kia.setBounds(12, 110, 930, 756);
		frame.getContentPane().add(panel_kia);
		panel_kia.setLayout(null);
		panel_kia.setVisible(false);
	
		
		ImageIcon hyndai_img;
		hyndai_img = new ImageIcon(".\\img\\hyundai_logo.jpg");
		Image h_img = hyndai_img.getImage();
		Image h_changImg = h_img.getScaledInstance(500, 350, Image.SCALE_SMOOTH);
		ImageIcon h_changIcon = new ImageIcon(h_changImg);
		JButton btnNewButton_1 = new JButton(h_changIcon);
		
		btnNewButton_1.addMouseListener(new MouseListener() { // 기아 마우스 기능 추가
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnNewButton_1.setIcon(h_changIcon);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon hy_blue;
				hy_blue = new ImageIcon(".\\img\\hyundai_blue.PNG");
				Image hb_img = hy_blue.getImage();
				Image hb_changImg = hb_img.getScaledInstance(430, 230, Image.SCALE_SMOOTH);
				ImageIcon hb_changIcon = new ImageIcon(hb_changImg);
				btnNewButton_1.setIcon(hb_changIcon);
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton btnNewButton_3 = new JButton(changIcon);
				btnNewButton_3.setBounds(27, 10, 426, 234);
				panel.add(btnNewButton_3);
				// TODO Auto-generated method stub
				
			}
		});
		
		btnNewButton_1.setBounds(478, 10, 426, 234);
		btnNewButton_1.setVerticalTextPosition(JLabel.CENTER);
		btnNewButton_1.setHorizontalTextPosition(JLabel.RIGHT);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car_Select_hyundai car_select_hyundai = new Car_Select_hyundai();
				frame.dispose();
			}
		});
		btnNewButton_1.setVisible(true);
		panel.add(btnNewButton_1);

		
		ImageIcon kia_img;
		kia_img = new ImageIcon(".\\img\\kia_logo.jpg");
		Image k_img = kia_img.getImage();
		Image k_changImg = k_img.getScaledInstance(430, 230, Image.SCALE_SMOOTH);
		ImageIcon k_changIcon = new ImageIcon(k_changImg);
		JButton btnNewButton_2 = new JButton(k_changIcon);
		
		btnNewButton_2.addMouseListener(new MouseListener() { // 기아 마우스 기능 추가
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnNewButton_2.setIcon(k_changIcon);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon kia_red;
				kia_red = new ImageIcon(".\\img\\kia_red.PNG");
				Image kr_img = kia_red.getImage();
				Image kr_changImg = kr_img.getScaledInstance(430, 230, Image.SCALE_SMOOTH);
				ImageIcon kr_changIcon = new ImageIcon(kr_changImg);
				btnNewButton_2.setIcon(kr_changIcon);
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car_Select_kia car_select_kia = new Car_Select_kia();
				frame.dispose();
				back = 1; //페이지 카운트 변수
			}
		});
		
		btnNewButton_2.setBounds(27, 10, 426, 234);
		btnNewButton_2.setVerticalTextPosition(JLabel.CENTER);
		btnNewButton_2.setHorizontalTextPosition(JLabel.RIGHT);
		btnNewButton_2.setVisible(true);
		panel.add(btnNewButton_2);

		JButton btnNewButton = new JButton("종료하기");
		btnNewButton.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new RoundedBorder(60));
		btnNewButton.setBounds(310, 876, 235, 72);
		frame.getContentPane().add(btnNewButton);

		JButton btn_back = new JButton("뒤로");
		btn_back.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_back.setToolTipText("");
		btn_back.setContentAreaFilled(false);
		btn_back.setBorder(new RoundedBorder(60));
		btn_back.setBounds(12, 28, 243, 53);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그인 상태
				if(memberDTO.getMember_Id() != null) {
					customerDTO.setLi_num(null);
					customerDTO.setLi_Date(null);
					customerDTO.setPh_Num(null);
					customerDTO.setAgree(false);
					
					Main main = new Main();
					frame.dispose();
				}
				// 비로그인 상태
				else {
					Agreement agree = new Agreement();
					frame.dispose();
				}
//				if(back == 0) {
//					Agreement agree = new Agreement();
//					frame.dispose();
//				}
//				panel.setVisible(true);
//				panel_hyundai.setVisible(false);
//				panel_kia.setVisible(false);
//				String text = "\uC81C\uC870\uC0AC\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694.";
//				lblNewLabel.setText(text);
//				back = 0;//약관동의 뒤로가기 화면 변수
			}
		});
		frame.getContentPane().add(btn_back);

		JButton btnNewButton_4 = new JButton("\uC544\uBC18\uB5BC");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(37, 254, 143, 102);
		panel_hyundai.add(btnNewButton_4);
		
		JButton btnNewButton_4_1_1 = new JButton("\uADF8\uB79C\uC800");
		btnNewButton_4_1_1.setBounds(365, 254, 143, 102);
		panel_hyundai.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_4_1 = new JButton("\uC3D8\uB098\uD0C0");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4_1.setBounds(200, 254, 143, 102);
		panel_hyundai.add(btnNewButton_4_1);
		

		JTextPane k3_textPane = new JTextPane();
		k3_textPane.setText("k3 차량 정보 입니다.");
		k3_textPane.setBounds(150, 400, 563, 308);
		k3_textPane.setVisible(false);
		panel_kia.add(k3_textPane);
		
		JButton btnNewButton_4_2 = new JButton("K3");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				k3_textPane.setVisible(true);
				
				
			}
		});
		btnNewButton_4_2.setBounds(37, 254, 143, 102);
		panel_kia.add(btnNewButton_4_2);
		

		
		JButton btnNewButton_4_1_1_1 = new JButton("K5");
		btnNewButton_4_1_1_1.setBounds(365, 254, 143, 102);
		panel_kia.add(btnNewButton_4_1_1_1);
		
		JButton btnNewButton_4_1_2 = new JButton("K7");
		btnNewButton_4_1_2.setBounds(200, 254, 143, 102);
		panel_kia.add(btnNewButton_4_1_2);
		
		//
		
		JButton btn_pay = new JButton("결제하기");
		btn_pay.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pay pay = new Pay();
				frame.dispose();
			}
		});
		btn_pay.setContentAreaFilled(false);
		btn_pay.setBorder(new RoundedBorder(60));
		btn_pay.setBounds(638, 876, 258, 72);
		frame.getContentPane().add(btn_pay);

	}

}
