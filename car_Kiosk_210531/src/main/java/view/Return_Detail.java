package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dto.CustomerDTO;
import dto.CarDTO;
import dto.ChargeDTO;
import dao.CustomerDAO;
import dao.CarDAO;
import dao.ChargeDAO;

//차량 url이미지 경로 설정, 차종 설정, 
public class Return_Detail extends JFrame{

	private JFrame frame;
	private int extra_Charge;
	List<CustomerDTO> return_select_car;
	List<CarDTO> return_Car;
	CarDAO carDAO = CarDAO.getInstance();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	CustomerDTO customerDTO = CustomerDTO.getInstance();
	ChargeDAO chargeDAO = ChargeDAO.getInstance();
	
	public Return_Detail() {
		List<CustomerDTO> dto = customerDAO.select_One(customerDTO.getCar_Num());
		// 고객 DTO의 lent_Time이 null일 경우 DB의 값을 넣는 구문 
		if (customerDTO.getLent_Time() == null) {
			customerDTO.setLi_num(dto.get(0).getLi_num());
			customerDTO.setLi_Date(dto.get(0).getLi_Date());
			customerDTO.setPh_Num(dto.get(0).getPh_Num());
			customerDTO.setCar_Num(dto.get(0).getCar_Num());
			customerDTO.setAgree(dto.get(0).isAgree());
			customerDTO.setLent_Time(dto.get(0).getLent_Time());
			customerDTO.setPay_Method(dto.get(0).getPay_Method());
			customerDTO.setPay_Money(dto.get(0).getPay_Money());
			customerDTO.setKey(dto.get(0).isKey());
			customerDTO.setStart_Time(dto.get(0).getStart_Time());
		}
		// DTO의 car_Num가 4자리일 경우 전체 번호로 set
		if (customerDTO.getCar_Num().length() == 4) {
			customerDTO.setCar_Num(dto.get(0).getCar_Num());
		}
		return_select_car = customerDAO.select_One(customerDTO.getCar_Num());// 반납할 차량 정보 조회
		return_Car = carDAO.select_All(); // 전체 차량
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uCF54\uB4DC\uC758 \u7F8E");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("반납 정보");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel.setBounds(327, 18, 300, 100);
		frame.getContentPane().add(lblNewLabel);

		String url = String.format(return_car_url(customerDTO.getCar_Num()));
		System.out.println("url : " + url);
		ImageIcon image1 = new ImageIcon(url);
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(720, 360, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		
		JLabel img_Label = new JLabel(changIcon);
		img_Label.setHorizontalAlignment(SwingConstants.CENTER);
		img_Label.setBounds(114, 121, 720, 360);
		frame.getContentPane().add(img_Label);

		JPanel panel = new JPanel();
		panel.setBounds(12, 491, 930, 367);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 906, 350);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(7, 2, 5, 5));
		
		JLabel lb_1 = new JLabel("차종 :");
		lb_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_1);
		JTextField text_1 = new JTextField();
		text_1.setText(return_car_size(customerDTO.getCar_Num()));
		text_1.setHorizontalAlignment(SwingConstants.CENTER);
		text_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_1);
		
		JLabel lb_2 = new JLabel("차량 번호 :");
		lb_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_2);
		JTextField text_2 = new JTextField();
		text_2.setText(customerDTO.getCar_Num());
		text_2.setHorizontalAlignment(SwingConstants.CENTER);
		text_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_2);
		
		JLabel lb_3 = new JLabel("서비스 시작 시간 :");
		lb_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_3);
		JTextField text_3 = new JTextField();
		// text_3.setText(return_select_car.get(0).getStart_Time());
		text_3.setText(customerDTO.getStart_Time());
		text_3.setHorizontalAlignment(SwingConstants.CENTER);
		text_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_3);
		
		JLabel lb_3_1 = new JLabel("서비스 종료 시간 :");
		lb_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_3_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_3_1);
		
		textField_retunTime = new JTextField();
		textField_retunTime.setText((String) null);
		textField_retunTime.setHorizontalAlignment(SwingConstants.CENTER);
		textField_retunTime.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		Calendar cal = Calendar.getInstance(); // 시간 캘린더 메서드
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm"); // 연/월/일 시:분
		String date = format.format(cal.getTime()); //시간 String 변환
		textField_retunTime.setText(date);
		panel_1.add(textField_retunTime);
		
		JLabel lb_4 = new JLabel("이용 시간 :");
		lb_4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_4);
		JTextField text_4 = new JTextField();
		text_4 = new JTextField();
		text_4.setText(customerDAO.date_Diff(customerDTO.getCar_Num()));
		text_4.setHorizontalAlignment(SwingConstants.CENTER);
		text_4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_4);
		
		JLabel lb_5 = new JLabel("선불 요금 :");
		lb_5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_5.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_5);
		JTextField text_5 = new JTextField();
		text_5 = new JTextField();
		text_5.setText(com_Money(customerDTO.getPay_Money()));
		text_5.setHorizontalAlignment(SwingConstants.CENTER);
		text_5.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_5);
		
		JLabel lb_6 = new JLabel("추가 요금 :");
		lb_6.setHorizontalAlignment(SwingConstants.CENTER);
		lb_6.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(lb_6);
		
		JTextField text_6 = new JTextField();
		text_6 = new JTextField();
		if (customerDTO.getOverpay_Money() == null) {
			extra_Charge = ex_Charge(customerDAO.date_Diff(customerDTO.getCar_Num()), customerDTO.getLent_Time()); // 10일 8시 4분, 0일 9시 0분
			text_6.setText(com_Money(extra_Charge));
		}
		else {
			extra_Charge = 0;
			text_6.setText(extra_Charge + " 원");
		} 
		// text_6.setText("0 원");
		text_6.setHorizontalAlignment(SwingConstants.CENTER);
		text_6.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel_1.add(text_6);
		
		JButton btn_Pay = new JButton("결제");
		btn_Pay.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDTO.setReturn_Time(textField_retunTime.getText());
				customerDTO.setOverpay_Money(Integer.toString(extra_Charge));
				Return_Paymethod method = new Return_Paymethod();
				frame.dispose();
			}
		});
		btn_Pay.setContentAreaFilled(false);
		btn_Pay.setBounds(360, 876, 235, 72);
		frame.getContentPane().add(btn_Pay);
		
		JButton btn_Return = new JButton("반납");
		btn_Return.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		btn_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customerDTO.getReturn_Time() == null) {
					customerDTO.setReturn_Time(textField_retunTime.getText());
					customerDTO.setOverpay_Method("없음");
					customerDTO.setOverpay_Money("0");
				}
				customerDTO.setKey(false);
				carDAO.update_Key(customerDTO.getCar_Num(), 1);  // UPDATE Car isKey -> 1
				customerDAO.update_Table(customerDTO); // UPDATE customer isKey, return_Time, overpay_Method, overpay_Money
				Return_Check check = new Return_Check();
				frame.dispose();
			}
		});
		btn_Return.setContentAreaFilled(false);
		btn_Return.setBounds(360, 876, 235, 72);
		frame.getContentPane().add(btn_Return);

		if (text_6.getText().equals("0 원")) {
			btn_Pay.setVisible(false);
		}
		else {
			btn_Return.setVisible(false);	
		}
	}
	
	//차량 url 가져오는 메소드
	private String return_car_url(String car_num) {
		String url = "";
		for (CarDTO cardto: return_Car) {
			if(cardto.getCar_Num().contains(car_num)) {
				url =  cardto.getCar_Url();
			}
		}
		return url;
	}
	//차종 이름 가져 오는 메소드
	private String return_car_size(String car_num) {
		for (CarDTO cardto: return_Car) {
			if(cardto.getCar_Num().contains(car_num)) {
				car_num =  cardto.getCar_Name();
			}
		}return car_num;
	}
	
	// 추가요금 구하는 메소드
	// date_1 = 사용한 시간 date_2 = 결제 시간
	String date_1 = null;
	String date_2 = null;
	private JTextField textField_retunTime;
	private int ex_Charge(String date_1, String date_2) {
		
		List<CarDTO> select_Car = carDAO.select_One(customerDTO.getCar_Num()); // car_Num을 매개변수로 car 테이블을 SELECT 
		// ChargeDTO charge = carDAO.SelectCharge(select_Car.get(0).getSize()).get(0); // size를 매개변수로 charge 테이블을 SELECT
		ChargeDTO charge = chargeDAO.select_One(select_Car.get(0).getSize()).get(0); // size를 매개변수로 charge 테이블을 SELECT
		ChargeDTO charge_Table = new ChargeDTO(charge.getCar_Size(), charge.getTen_Min(), charge.getOne_Hour(), charge.getThree_Hour(),charge.getSix_Hour(),charge.getOne_Day(),charge.getThree_Day());
		
		this.date_1 = date_1; // 3일 1시간 21분
		this.date_2 = date_2; // 1일 2시간 32분
		System.out.println(date_1 + " and " +date_2);
		date_1 = date_1.replace("일", "");
		date_1 = date_1.replace("시", "");
		date_1 = date_1.replace("분", "");
		date_2 = date_2.replace("일", "");
		date_2 = date_2.replace("시", "");
		date_2 = date_2.replace("분", "");
		
		String[] arr_1 = date_1.split(" "); // 3 1 21
		String[] arr_2 = date_2.split(" "); // 1 2 32
		
		int time_1 = Integer.parseInt(arr_1[0]) * 1440 + Integer.parseInt(arr_1[1]) * 60 + Integer.parseInt(arr_1[2]);
		int time_2 = Integer.parseInt(arr_2[0]) * 1440 + Integer.parseInt(arr_2[1]) * 60 + Integer.parseInt(arr_2[2]);
		
		int res = 0;

		if (time_2 - time_1 < 0) {
			int diff_time = time_1 - time_2;
			System.out.println(diff_time);
			// 3일
			int three_Days = diff_time / 4320;
			res += three_Days * charge_Table.getThree_Day();
			diff_time %= 4320;
			// 1일
			int one_Days = diff_time / 1440;
			res += one_Days * charge_Table.getOne_Day();
			diff_time %= 1440; 
			// 6시간
			int six_Hours = diff_time / 360;
			res += six_Hours * charge_Table.getSix_Hour();
			diff_time %= 360;
			// 3시간
			int three_Hours = diff_time / 180;
			res += three_Hours * charge_Table.getThree_Hour();
			diff_time %= 180;
			// 1시간
			int one_Hours = diff_time / 60;
			res += one_Hours * charge_Table.getOne_Hour();
			diff_time %= 60;
			// 10분
			int ten_Minutes = diff_time / 10;
			diff_time %= 10;
			if (diff_time > 0) {
				ten_Minutes += 1;
			}
			res += ten_Minutes * charge_Table.getTen_Min();
		}
		
		return res;
	}
	
	private String com_Money(int m) {
		String money = Integer.toString(m);
		String com_Money = String.format("%,d", Integer.parseInt(money));
		String result = com_Money + " 원";
		return result;
	}
}
