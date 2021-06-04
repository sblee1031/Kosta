package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.CarDAO;
import dto.CarDTO;

public class Car_Select_kia {

	private JFrame frame;
	private ButtonGroup toggle_group = new ButtonGroup();
	
	public Car_Select_kia() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("코드의 美");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(230, 230, 250));
		mainPanel.setBounds(0, 0, 954, 961);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("기아 차량 선택");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel.setBounds(311, 18, 291, 92);
		mainPanel.add(lblNewLabel);
		
		//소형 패널 시작.
		JPanel panel_Small = new JPanel();
		panel_Small.setBackground(new Color(230, 230, 250));
		panel_Small.setForeground(Color.BLACK);
		panel_Small.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_Small.setBounds(26, 258, 902, 623);
		panel_Small.setLayout(null);
		panel_Small.setVisible(false);
		mainPanel.add(panel_Small);
		

		JButton btn_kia_morning_img = new JButton(img_Button("./img/car_img/kia_Morning.png",280,150));
		btn_kia_morning_img.setForeground(Color.DARK_GRAY);
		btn_kia_morning_img.setBounds(12, 10, 284, 200);
		btn_kia_morning_img.setContentAreaFilled(false);
		btn_kia_morning_img.setBorder(new RoundedBorder(10));
		btn_kia_morning_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "kia_Morning";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Small.add(btn_kia_morning_img);
		
		JLabel Label_morning = new JLabel("모닝");
		Label_morning.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_morning.setHorizontalAlignment(SwingConstants.CENTER);
		Label_morning.setBounds(12, 220, 284, 37);
		panel_Small.add(Label_morning);
		
		JLabel morning_isLent = new JLabel("대여 가능");
		morning_isLent.setForeground(new Color(0, 0, 255));
		morning_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		morning_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		morning_isLent.setBounds(12, 257, 284, 37);
		panel_Small.add(morning_isLent);
		isLentAble(btn_kia_morning_img, Label_morning, morning_isLent);
		//소형 패널 끝.

		//중형 패널 시작.
		JPanel panel_Mid = new JPanel();
		panel_Mid.setLayout(null);
		panel_Mid.setForeground(Color.WHITE);
		panel_Mid.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_Mid.setBackground(new Color(230, 230, 250));
		panel_Mid.setBounds(26, 258, 902, 623);
		panel_Mid.setVisible(false);
		mainPanel.add(panel_Mid);
		
		JButton btn_kia_k3_img = new JButton(img_Button("./img/car_img/kia_K3.png",280,150));
		
		btn_kia_k3_img.setForeground(new Color(0, 0, 0));
		btn_kia_k3_img.setBounds(12, 10, 284, 200);
		btn_kia_k3_img.setContentAreaFilled(false);
		btn_kia_k3_img.setBorder(new RoundedBorder(10));
		btn_kia_k3_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "kia_K3";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Mid.add(btn_kia_k3_img);
		
		JLabel Label_k3 = new JLabel("K3");
		Label_k3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_k3.setHorizontalAlignment(SwingConstants.CENTER);
		Label_k3.setBounds(12, 220, 284, 37);
		panel_Mid.add(Label_k3);
		
		JLabel k3_isLent = new JLabel("대여 가능");
		k3_isLent.setForeground(new Color(0, 0, 255));
		k3_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		k3_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		k3_isLent.setBounds(12, 257, 284, 37);
		panel_Mid.add(k3_isLent);
		isLentAble(btn_kia_k3_img, Label_k3, k3_isLent);

		
		JButton btn_kia_k5_img = new JButton(img_Button("./img/car_img/kia_K5.png",280,150));
		btn_kia_k5_img.setForeground(new Color(0, 0, 0));
		btn_kia_k5_img.setBounds(308, 10, 284, 200);
		btn_kia_k5_img.setContentAreaFilled(false);
		btn_kia_k5_img.setBorder(new RoundedBorder(10));
		btn_kia_k5_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "kia_K5";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Mid.add(btn_kia_k5_img);
		
		JLabel Label_K5 = new JLabel("K5");
		Label_K5.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_K5.setHorizontalAlignment(SwingConstants.CENTER);
		Label_K5.setBounds(308, 220, 284, 37);
		panel_Mid.add(Label_K5);
		
		JLabel K5_isLent = new JLabel("대여 가능");
		K5_isLent.setForeground(new Color(0, 0, 255));
		K5_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		K5_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		K5_isLent.setBounds(308, 257, 284, 37);
		panel_Mid.add(K5_isLent);
		isLentAble(btn_kia_k5_img, Label_K5, K5_isLent);
		//중형 패널 끝.
		
		//대형 패널 시작.
		JPanel panel_Large = new JPanel();
		panel_Large.setLayout(null);
		panel_Large.setForeground(Color.WHITE);
		panel_Large.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_Large.setBackground(new Color(230, 230, 250));
		panel_Large.setBounds(26, 258, 902, 623);
		panel_Large.setVisible(false);
		mainPanel.add(panel_Large);
		
		JButton btn_kia_k7_img = new JButton(img_Button("./img/car_img/kia_K7.png",280,140));
		btn_kia_k7_img.setForeground(new Color(0, 0, 0));
		btn_kia_k7_img.setBounds(12, 10, 284, 200);
		btn_kia_k7_img.setContentAreaFilled(false);
		btn_kia_k7_img.setBorder(new RoundedBorder(10));
		btn_kia_k7_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "kia_K7";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Large.add(btn_kia_k7_img);
		
		JLabel Label_K7 = new JLabel("K7");
		Label_K7.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_K7.setHorizontalAlignment(SwingConstants.CENTER);
		Label_K7.setBounds(12, 220, 284, 37);
		panel_Large.add(Label_K7);
		
		JLabel K7_isLent = new JLabel("대여 가능");
		K7_isLent.setForeground(new Color(0, 0, 255));
		K7_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		K7_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		K7_isLent.setBounds(12, 257, 284, 37);
		panel_Large.add(K7_isLent);
		isLentAble(btn_kia_k7_img, Label_K7, K7_isLent);

		JButton btn_kia_k9_img = new JButton(img_Button("./img/car_img/kia_K9.png",280,150));
		btn_kia_k9_img.setForeground(new Color(0, 0, 0));
		btn_kia_k9_img.setBounds(308, 10, 284, 200);
		btn_kia_k9_img.setContentAreaFilled(false);
		btn_kia_k9_img.setBorder(new RoundedBorder(10));
		btn_kia_k9_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "kia_K9";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Large.add(btn_kia_k9_img);
		
		JLabel Label_k9 = new JLabel("K9");
		Label_k9.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_k9.setHorizontalAlignment(SwingConstants.CENTER);
		Label_k9.setBounds(308, 220, 284, 37);
		panel_Large.add(Label_k9);
		
		JLabel k9_isLent = new JLabel("대여 가능");
		k9_isLent.setForeground(new Color(0, 0, 255));
		k9_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		k9_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		k9_isLent.setBounds(308, 257, 284, 37);
		panel_Large.add(k9_isLent);
		isLentAble(btn_kia_k9_img, Label_k9, k9_isLent);

		JButton btn_kia_sorento_img = new JButton(img_Button("./img/car_img/kia_Sorento.png",280,150));
		btn_kia_sorento_img.setForeground(new Color(0, 0, 0));
		btn_kia_sorento_img.setBounds(604, 10, 284, 200);
		btn_kia_sorento_img.setContentAreaFilled(false);
		btn_kia_sorento_img.setBorder(new RoundedBorder(10));
		btn_kia_sorento_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "kia_Sorento";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Large.add(btn_kia_sorento_img);
		
		JLabel Label_sorento = new JLabel("쏘렌토");
		Label_sorento.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_sorento.setHorizontalAlignment(SwingConstants.CENTER);
		Label_sorento.setBounds(604, 220, 284, 37);
		panel_Large.add(Label_sorento);
		
		JLabel sorento_isLent = new JLabel("대여 가능");
		sorento_isLent.setForeground(new Color(0, 0, 255));
		sorento_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		sorento_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		sorento_isLent.setBounds(604, 257, 284, 37);
		panel_Large.add(sorento_isLent);
		isLentAble(btn_kia_sorento_img, Label_sorento, sorento_isLent);
		//대형 패널 끝.
		
		ImageIcon image1;
		image1 = new ImageIcon("./img/main_image.png");
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(220, 100, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		JLabel lblNewLabel_logo = new JLabel(changIcon);
		lblNewLabel_logo.setBounds(703, 6, 239, 106);
		lblNewLabel_logo.setVerticalTextPosition(JLabel.CENTER);
		lblNewLabel_logo.setHorizontalTextPosition(JLabel.RIGHT);
		lblNewLabel_logo.setVisible(true);
		mainPanel.add(lblNewLabel_logo);
		
		JButton btn_back = new JButton("뒤로");
		btn_back.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_back.setToolTipText("");
		btn_back.setContentAreaFilled(false);
		btn_back.setBorder(new RoundedBorder(60));
		btn_back.setBounds(12, 28, 188, 53);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car_Select carselect = new Car_Select();
				frame.dispose();
			}
		});
		mainPanel.add(btn_back);
		
		JToggleButton ToggleButton_Small = new JToggleButton("소형");
		ToggleButton_Small.setBackground(new Color(230, 230, 250));
		ToggleButton_Small.setBounds(26, 148, 300, 100);
		ToggleButton_Small.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		ToggleButton_Small.setBorder(new LineBorder(Color.black,3,true));
		ToggleButton_Small.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Small.setVisible(true);
				panel_Mid.setVisible(false);
				panel_Large.setVisible(false);
				String text = "소형 차량";
				lblNewLabel.setText(text);
			}
		});
		mainPanel.add(ToggleButton_Small);
		
		JToggleButton ToggleButton_Mid = new JToggleButton("중형");
		ToggleButton_Mid.setBackground(new Color(230, 230, 250));
		ToggleButton_Mid.setBounds(327, 148, 300, 100);
		ToggleButton_Mid.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		ToggleButton_Mid.setBorder(new LineBorder(Color.black,3,true));
		ToggleButton_Mid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Small.setVisible(false);
				panel_Mid.setVisible(true);
				panel_Large.setVisible(false);
				String text = "중형 차량";
				lblNewLabel.setText(text);
			}
		});
		mainPanel.add(ToggleButton_Mid);
		
		JToggleButton ToggleButton_Large = new JToggleButton("대형");
		ToggleButton_Large.setSelectedIcon(null);
		ToggleButton_Large.setBackground(new Color(230, 230, 250));
		ToggleButton_Large.setBounds(628, 148, 300, 100);
		ToggleButton_Large.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		ToggleButton_Large.setBorder(new LineBorder(Color.black,3,true));
		ToggleButton_Large.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Small.setVisible(false);
				panel_Mid.setVisible(false);
				panel_Large.setVisible(true);
				String text = "대형 차량";
				lblNewLabel.setText(text);
			}
		});
		mainPanel.add(ToggleButton_Large);
		
		//토글버튼 그룹핑
		toggle_group.add(ToggleButton_Large); 
		toggle_group.add(ToggleButton_Mid);
		toggle_group.add(ToggleButton_Small);

	}
	void isLentAble(JButton button, JLabel car_Name, JLabel label ) {
		List<CarDTO> carList;
		carList = CarDAO.getInstance().select_All();
		int lentAble = 0;
		for (CarDTO carDTO : carList) {
			if(carDTO.getCar_Name().equals(car_Name.getText()) && carDTO.isKey()) {
				lentAble++;
			}
		}
		if(lentAble == 0) {label.setText("대여 불가"); label.setForeground(Color.RED); button.setEnabled(false);}
		if(lentAble > 0) {label.setText("잔여 차량 : "+ lentAble+" 대"); label.setForeground(Color.BLUE); button.setEnabled(true);}
	}
	
	public ImageIcon img_Button(String path, int x, int y) {
		ImageIcon icon_img;
		icon_img = new ImageIcon(path);
		Image img = icon_img.getImage();
		Image changImg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		return changIcon;
	}
}
