package view;

import java.awt.Color;




import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import dto.CarDTO;
import dto.ChargeDTO;
import dto.CustomerDTO;
import dao.CarDAO;
import dao.ChargeDAO;
import dao.CustomerDAO;


public class Car_Detail {

	private JFrame frame;
	private static String car;
	private String size;
	
	List<CarDTO> enableCarList; 
	List<CarDTO> NewenableCarList; 

	public Car_Detail(String car) {
		this.car = car;
		initialize(car);
	}
	ChargeDTO chargeDTO = null;
	private void initialize(String car) {
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		CustomerDTO customerDTO = CustomerDTO.getInstance();
		CarDAO carDAO = CarDAO.getInstance();

		System.out.println(customerDTO.toString());
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uCF54\uB4DC\uC758 \u7F8E");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("차량 정보");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel.setBounds(327, 18, 300, 100);
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon image1;
		String url = String.format("./img/car_img/%s.png", car);
		image1 = new ImageIcon(url);
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(720, 360, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		
		JLabel img_Label = new JLabel(changIcon);
		img_Label.setHorizontalAlignment(SwingConstants.CENTER);
		img_Label.setBounds(117, 136, 720, 360);
		frame.getContentPane().add(img_Label);

		JPanel panel = new JPanel();
		panel.setBounds(12, 514, 930, 344);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 906, 324);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 5, 5));
		
		JLabel lb_1 = new JLabel("\uC81C\uC870\uC0AC :");
		lb_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_1);
		JTextField text_1 = new JTextField();
		text_1.setText("\uD604\uB300");
		text_1.setHorizontalAlignment(SwingConstants.CENTER);
		text_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_1);
		JLabel lb_2 = new JLabel("\uBAA8\uB378\uBA85 :");
		lb_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_2);
		JTextField text_2 = new JTextField();
		text_2.setText("\uC544\uBC18\uB5BC");
		text_2.setHorizontalAlignment(SwingConstants.CENTER);
		text_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_2);
		JLabel lb_3 = new JLabel("\uC720\uC885 :");
		lb_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_3);
		JTextField text_3 = new JTextField();
		text_3 = new JTextField();
		text_3.setText("\uD718\uBC1C\uC720");
		text_3.setHorizontalAlignment(SwingConstants.CENTER);
		text_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_3);
		JLabel lb_4 = new JLabel("\uC5F0\uBE44 :");
		lb_4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_4);
		JTextField text_4 = new JTextField();
		text_4 = new JTextField();
		text_4.setText("10.5 ~ 21.1");
		text_4.setHorizontalAlignment(SwingConstants.CENTER);
		text_4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_4);
		JLabel lb_5 = new JLabel("\uD3C9\uC810 :");
		lb_5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_5.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_5);
		JTextField text_5 = new JTextField();
		text_5 = new JTextField();
		text_5.setText("3.45");
		text_5.setHorizontalAlignment(SwingConstants.CENTER);
		text_5.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_5);
		JLabel lb_6 = new JLabel("\uC794\uC5EC \uC218\uB7C9 :");
		lb_6.setHorizontalAlignment(SwingConstants.CENTER);
		lb_6.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_6);
		JTextField text_6 = new JTextField();
		text_6 = new JTextField();
		text_6.setText("0");
		text_6.setHorizontalAlignment(SwingConstants.CENTER);
		text_6.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_6);

		JButton btn_Back = new JButton("뒤로");
		btn_Back.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car_Select select = new Car_Select();
				frame.dispose();
			}
		});
		btn_Back.setContentAreaFilled(false);
		btn_Back.setBorder(new RoundedBorder(60));
		btn_Back.setBounds(20, 876, 235, 72);
		frame.getContentPane().add(btn_Back);
		
		String cnt;
		switch (car) {
		case "hd_Abante":
			text_1.setText("현대");
			text_2.setText("아반떼");
			text_3.setText("휘발유");
			text_4.setText("10.5 ~ 21.1");
			text_5.setText("3.45");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "중형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "hd_Accent":
			text_1.setText("현대");
			text_2.setText("엑센트");
			text_3.setText("휘발유");
			text_4.setText("13.1 ~ 14.1");
			text_5.setText("4.50");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "소형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "hd_Grandeur":
			text_1.setText("현대");
			text_2.setText("그랜저");
			text_3.setText("휘발유");
			text_4.setText("7.4 ~ 16.2");
			text_5.setText("3.50");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "대형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "hd_Palisade":
			text_1.setText("현대");
			text_2.setText("펠리세이드");
			text_3.setText("경유");
			text_4.setText("8.9 ~ 12.6");
			text_5.setText("0.00");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "SUV";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "hd_Sonata":
			text_1.setText("현대");
			text_2.setText("소나타");
			text_3.setText("휘발유");
			text_4.setText("9.9 ~ 20.1");
			text_5.setText("2.60");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "중형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "hd_Tucson":
			text_1.setText("현대");
			text_2.setText("투싼");
			text_3.setText("경유");
			text_4.setText("11.0 ~ 16.2");
			text_5.setText("4.05");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "SUV";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "kia_K3":
			text_1.setText("기아");
			text_2.setText("K3");
			text_3.setText("휘발유");
			text_4.setText("14.1 ~ 15.2");
			text_5.setText("4.00");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "중형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "kia_K5":
			text_1.setText("기아");
			text_2.setText("K5");
			text_3.setText("휘발유");
			text_4.setText("9.8 ~ 20.1");
			text_5.setText("3.65");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "중형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "kia_K7":
			text_1.setText("기아");
			text_2.setText("K7");
			text_3.setText("휘발유");
			text_4.setText("7.1 ~ 14.6");
			text_5.setText("4.40");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "대형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "kia_K9":
			text_1.setText("기아");
			text_2.setText("K9");
			text_3.setText("휘발유");
			text_4.setText("7.5 ~ 9.0");
			text_5.setText("4.25");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "대형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "kia_Morning":
			text_1.setText("기아");
			text_2.setText("모닝");
			text_3.setText("휘발유");
			text_4.setText("14.7 ~ 15.7");
			text_5.setText("3.30");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "소형";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		case "kia_Sorento":
			text_1.setText("기아");
			text_2.setText("쏘렌토");
			text_3.setText("경유");
			text_4.setText("9.7 ~ 15.3");
			text_5.setText("3.10");
			cnt = isLentAble(text_2.getText());
			text_6.setText(cnt);
			size = "SUV";
			enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
			break;
		}
		
		JButton btnNewButton = new JButton("다음");
		btnNewButton.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int random_carNum = (int)Math.floor((Math.random())*enableCarList.size()); //가능한 차중 랜덤 배차
				customerDTO.setCar_Num(enableCarList.get(random_carNum).getCar_Num()); // 차량 번호 입력
				System.out.println("배정된 차량 번호 : "+enableCarList.get(random_carNum).getCar_Num());
				// customerDAO.SetCar(customerDTO);//DB 저장
				System.out.println(customerDTO.toString());//데이터 들어간거 확인용 콘솔 출력
				
				enableCarList = CarDAO.getInstance().SelectTable(text_2.getText());
				System.out.println("사용가능 한 "+text_2.getText()+" : ");
				for (CarDTO carDTO : enableCarList) {
					if(carDTO.getCar_Name().equals(text_2.getText())) {
					System.out.print(carDTO.getCar_Num()+" ");
					}
				}
				TimeSelect timeSelect;
				switch (size) {
				case "소형":
					setSize("small");
					timeSelect = new TimeSelect();
					frame.dispose();
					break;
				case "중형":
					setSize("medium");
					timeSelect = new TimeSelect();
					frame.dispose();
					break;
				case "대형":
					setSize("large");
					timeSelect = new TimeSelect();
					frame.dispose();
					break;
				case "SUV":
					setSize("suv");
					timeSelect = new TimeSelect();
					frame.dispose();
					break;
				}
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new RoundedBorder(60));
		btnNewButton.setBounds(360, 876, 235, 72);
		frame.getContentPane().add(btnNewButton);

		
	}
	
	int i=0;
	public void setSize(String size) {
		CarDAO carDAO = null;
		ChargeDAO chargeDAO = ChargeDAO.getInstance();
		
		List<ChargeDTO> chargeList = chargeDAO.select_One(size);
		
		chargeDTO = ChargeDTO.getInstance();
		chargeDTO.setCar_Size(chargeList.get(i).getCar_Size());
		chargeDTO.setTen_Min(chargeList.get(i).getTen_Min());
		chargeDTO.setOne_Hour(chargeList.get(i).getOne_Hour());
		chargeDTO.setThree_Hour(chargeList.get(i).getThree_Hour());
		chargeDTO.setSix_Hour(chargeList.get(i).getSix_Hour());
		chargeDTO.setOne_Day(chargeList.get(i).getOne_Day());
		chargeDTO.setThree_Day(chargeList.get(i).getThree_Day());
		
		i++;
	
	}
	
	public String isLentAble(String car_Name) {
		List<CarDTO> carList = CarDAO.getInstance().select_All();
		int lentAble = 0;
		for (CarDTO carDTO : carList) {
			if(carDTO.getCar_Name().equals(car_Name) && carDTO.isKey()) {
				lentAble++;
			}
		}
		return Integer.toString(lentAble); 
	}

}
