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

public class Car_Select_hyundai {

	private JFrame frame;
	private ButtonGroup toggle_group = new ButtonGroup();
	
	public Car_Select_hyundai() {
		// TODO Auto-generated constructor stub
		
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
		
		JLabel lblNewLabel = new JLabel("현대 차량 선택");
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
		

		JButton btn_hd_Accent_img = new JButton(img_Button("./img/car_img/hd_Accent.png",280,150));
		btn_hd_Accent_img.setForeground(Color.DARK_GRAY);
		btn_hd_Accent_img.setBounds(12, 10, 284, 200);
		btn_hd_Accent_img.setContentAreaFilled(false);
		btn_hd_Accent_img.setBorder(new RoundedBorder(10));
		btn_hd_Accent_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "hd_Accent";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Small.add(btn_hd_Accent_img);
		
		JLabel Label_Accent = new JLabel("엑센트");
		Label_Accent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_Accent.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Accent.setBounds(12, 220, 284, 37);
		panel_Small.add(Label_Accent);
		
		JLabel Accent_isLent = new JLabel();
		Accent_isLent.setForeground(new Color(0, 0, 255));
		Accent_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		Accent_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		Accent_isLent.setBounds(12, 257, 284, 37);
		panel_Small.add(Accent_isLent);
		isLentAble(btn_hd_Accent_img, Label_Accent, Accent_isLent);
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
		
		JButton btn_hd_Abante_img = new JButton(img_Button("./img/car_img/hd_Abante.png",280,150));
		btn_hd_Abante_img.setForeground(new Color(0, 0, 0));
		btn_hd_Abante_img.setBounds(12, 10, 284, 200);
		btn_hd_Abante_img.setContentAreaFilled(false);
		btn_hd_Abante_img.setBorder(new RoundedBorder(10));
		btn_hd_Abante_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "hd_Abante";
				Car_Detail detail = new Car_Detail(car);
				// Hd_Abante abante = new Hd_Abante();
				frame.dispose();
			}
		});
		panel_Mid.add(btn_hd_Abante_img);
		
		JLabel Label_abante = new JLabel("아반떼");
		Label_abante.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_abante.setHorizontalAlignment(SwingConstants.CENTER);
		Label_abante.setBounds(12, 220, 284, 37);
		panel_Mid.add(Label_abante);
		
		JLabel abante_isLent = new JLabel("대여 가능");
		abante_isLent.setForeground(new Color(0, 0, 255));
		abante_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		abante_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		abante_isLent.setBounds(12, 257, 284, 37);
		panel_Mid.add(abante_isLent);
		isLentAble(btn_hd_Abante_img, Label_abante, abante_isLent);
		
		JButton btn_hd_Sonata_img = new JButton(img_Button("./img/car_img/hd_Sonata.png",280,150));
		btn_hd_Sonata_img.setForeground(new Color(0, 0, 0));
		btn_hd_Sonata_img.setBounds(308, 10, 284, 200);
		btn_hd_Sonata_img.setContentAreaFilled(false);
		btn_hd_Sonata_img.setBorder(new RoundedBorder(10));
		btn_hd_Sonata_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "hd_Sonata";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Mid.add(btn_hd_Sonata_img);
		
		JLabel Label_sonata = new JLabel("소나타");
		Label_sonata.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_sonata.setHorizontalAlignment(SwingConstants.CENTER);
		Label_sonata.setBounds(308, 220, 284, 37);
		panel_Mid.add(Label_sonata);
		
		JLabel sonata_isLent = new JLabel("대여 가능");
		sonata_isLent.setForeground(new Color(0, 0, 255));
		sonata_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		sonata_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		sonata_isLent.setBounds(308, 257, 284, 37);
		panel_Mid.add(sonata_isLent);
		isLentAble(btn_hd_Sonata_img, Label_sonata, sonata_isLent);
		
		JButton btn_hd_Tucson_img = new JButton(img_Button("./img/car_img/hd_Tucson.png",280,150));
		btn_hd_Tucson_img.setForeground(new Color(0, 0, 0));
		btn_hd_Tucson_img.setBounds(604, 10, 284, 200);
		btn_hd_Tucson_img.setContentAreaFilled(false);
		btn_hd_Tucson_img.setBorder(new RoundedBorder(10));
		btn_hd_Tucson_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "hd_Tucson";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Mid.add(btn_hd_Tucson_img);
		
		JLabel Label_Tucson = new JLabel("투싼");
		Label_Tucson.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_Tucson.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Tucson.setBounds(604, 220, 284, 37);
		panel_Mid.add(Label_Tucson);
		
		JLabel Tucson_isLent = new JLabel("대여 가능");
		Tucson_isLent.setForeground(new Color(0, 0, 255));
		Tucson_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		Tucson_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		Tucson_isLent.setBounds(604, 257, 284, 37);
		panel_Mid.add(Tucson_isLent);
		isLentAble(btn_hd_Tucson_img, Label_Tucson, Tucson_isLent);
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
		
		JButton btn_hd_Grandeur_img = new JButton(img_Button("./img/car_img/hd_Grandeur.png",280,150));
		btn_hd_Grandeur_img.setForeground(new Color(0, 0, 0));
		btn_hd_Grandeur_img.setBounds(12, 10, 284, 200);
		btn_hd_Grandeur_img.setContentAreaFilled(false);
		btn_hd_Grandeur_img.setBorder(new RoundedBorder(10));
		btn_hd_Grandeur_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "hd_Grandeur";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Large.add(btn_hd_Grandeur_img);
		
		JLabel Label_Grandeur = new JLabel("그랜저");
		Label_Grandeur.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_Grandeur.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Grandeur.setBounds(12, 220, 284, 37);
		panel_Large.add(Label_Grandeur);
		
		JLabel Grandeur_isLent = new JLabel("대여 가능");
		Grandeur_isLent.setForeground(new Color(0, 0, 255));
		Grandeur_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		Grandeur_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		Grandeur_isLent.setBounds(12, 257, 284, 37);
		panel_Large.add(Grandeur_isLent);
		isLentAble(btn_hd_Grandeur_img, Label_Grandeur, Grandeur_isLent);

		
		JButton btn_hd_Palisade_img = new JButton(img_Button("./img/car_img/hd_Palisade.png",280,150));
		btn_hd_Palisade_img.setForeground(new Color(0, 0, 0));
		btn_hd_Palisade_img.setBounds(308, 10, 284, 200);
		btn_hd_Palisade_img.setContentAreaFilled(false);
		btn_hd_Palisade_img.setBorder(new RoundedBorder(10));
		btn_hd_Palisade_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = "hd_Palisade";
				Car_Detail detail = new Car_Detail(car);
				frame.dispose();
			}
		});
		panel_Large.add(btn_hd_Palisade_img);
		
		JLabel Label_Palisade = new JLabel("펠리세이드");
		Label_Palisade.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Label_Palisade.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Palisade.setBounds(308, 220, 284, 37);
		panel_Large.add(Label_Palisade);
		
		JLabel Palisade_isLent = new JLabel("대여 가능");
		Palisade_isLent.setForeground(new Color(0, 0, 255));
		Palisade_isLent.setHorizontalAlignment(SwingConstants.CENTER);
		Palisade_isLent.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		Palisade_isLent.setBounds(308, 257, 284, 37);
		panel_Large.add(Palisade_isLent);
		isLentAble(btn_hd_Palisade_img, Label_Palisade, Palisade_isLent);
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
