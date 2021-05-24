package day_05_18;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;

public class PaymentFrame2 {

	private JFrame frame;
   	static ArrayList<ArrayList<String>> userInfo ;
    String strCart = "자유석 시간권(10시간)/자유석 기간권(4주)/5인실 일회권(3시간);";
   	String[] aryCart = strCart.split(";");
   	private JPanel buyPanel = new JPanel();
   	private JPanel bigPanel = new JPanel();
   	private JPanel paymentPanel= new JPanel();
   	private JLabel totalAmount;
   	private JTextField Notice1;
   	private JTextField Notice2;
   	
   	String price = "";
   	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentFrame2 window = new PaymentFrame2();
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
	public PaymentFrame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param JButton 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 700, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		bigPanel.setBackground(Color.BLACK);
		bigPanel.setBounds(-5, -29, 700, 800);
		frame.getContentPane().add(bigPanel);
		bigPanel.setLayout(null);
		
		buyPanel.setBackground(Color.BLACK);
		buyPanel.setBounds(0, 80, 700, 713);
		bigPanel.add(buyPanel);
		buyPanel.setLayout(null);

		//타이틀 '시간권/기간권' 구입
		JLabel BuyPass = new JLabel("시간권 기간권 구입");
		BuyPass.setBounds(219, 31, 270, 35);
		BuyPass.setFont(new Font("굴림", Font.BOLD, 30));
		BuyPass.setForeground(Color.ORANGE);
		BuyPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.ORANGE));
		buyPanel.add(BuyPass);
		
		//전체타입
		JTextField ProductType = new JTextField();
		ProductType.setBackground(Color.ORANGE);
		ProductType.setFont(new Font("굴림", Font.BOLD, 15));
		ProductType.setHorizontalAlignment(SwingConstants.CENTER);
		ProductType.setText("전체타입");
		ProductType.setBounds(56, 79, 136, 49);
		ProductType.setColumns(10);
		buyPanel.add(ProductType);
		//전체상품
		JTextField AllProduct = new JTextField();
		AllProduct.setText("전체상품");
		AllProduct.setHorizontalAlignment(SwingConstants.CENTER);
		AllProduct.setFont(new Font("굴림", Font.BOLD, 15));
		AllProduct.setColumns(10);
		AllProduct.setBackground(Color.ORANGE);
		AllProduct.setBounds(56, 144, 136, 49);
		buyPanel.add(AllProduct);
		
		//자유석
		JButton FreeSeats = new JButton("자유석");
		FreeSeats.setBackground(new Color(65, 105, 225));
		FreeSeats.setForeground(Color.WHITE);
		FreeSeats.setBounds(219, 79, 106, 49);
		buyPanel.add(FreeSeats);
		
		//5인실
		JButton GroupRoom = new JButton("5인실");
		GroupRoom.setForeground(Color.WHITE);
		GroupRoom.setBackground(new Color(65, 105, 225));
		GroupRoom.setBounds(337, 79, 106, 49);
		buyPanel.add(GroupRoom);
		
		//일회권
		JButton ADayPass = new JButton("일회권");
		ADayPass.setForeground(Color.WHITE);
		ADayPass.setBackground(new Color(65, 105, 225));
		ADayPass.setBounds(219, 144, 106, 49);
		buyPanel.add(ADayPass);
		
		//시간권
		JButton DayPass = new JButton("시간권");
		DayPass.setForeground(Color.WHITE);
		DayPass.setBackground(new Color(65, 105, 225));
		DayPass.setBounds(337, 144, 106, 49);
		buyPanel.add(DayPass);
		
		//기간권
		JButton WeekPass = new JButton("기간권");
		WeekPass.setForeground(Color.WHITE);
		WeekPass.setBackground(new Color(65, 105, 225));
		WeekPass.setBounds(455, 144, 106, 49);
		buyPanel.add(WeekPass);
		

		//자유석 미니패널
		JPanel MiniPanelFreeSeats = new JPanel();
		MiniPanelFreeSeats.setBackground(new Color(0, 0, 0));
		MiniPanelFreeSeats.setBounds(25, 213, 646, 377);
		buyPanel.add(MiniPanelFreeSeats);
		MiniPanelFreeSeats.setLayout(null);
		

		String[] FreeSeat = {"<HTML><body style='text-align:center;'>자유석 1회권<br>2시간 3,000원</body>"
				+ "</HTML>","<HTML><body style='text-align:center;'>자유석 1회권<br>4시간 5,000원</body>"
				+ "</HTML>","<HTML><body style='text-align:center;'>자유석 1회권<br>6시간 7,000원</body>"
				+ "</HTML>","<HTML><body style='text-align:center;'>자유석 1회권<br> 추가 1시간 1,000원"
				+ "</body></HTML>", "<HTML><body style='text-align:center;'>자유석 시간권<br> "
				+ "20시간 29,000원</body></HTML>","<HTML><body style='text-align:center;'>"
				+ "자유석 시간권<br>50시간 59,000원</body></HTML>", "<HTML><body style='text-align:"
				+ "center;'>자유석 시간권<br> 100시간 88,000원</body></HTML>", "<HTML><body style='text-align:center;'>\uC790\uC720\uC11D"
				+ " \uAE30\uAC04\uAD8C<br>1\uC8FC 40,000\uC6D0</body></HTML>","<HTML><body style='text-align:center;'>\uC790\uC720\uC11D "
				+ "\uAE30\uAC04\uAD8C<br>2\uC8FC 75,000\uC6D0</body></HTML>","<HTML><body style='text-align:center;'>\uC790\uC720\uC11D"
				+ " \uAE30\uAC04\uAD8C<br>4\uC8FC 100,000\uC6D0</body></HTML>"};
	
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				JToggleButton freeSeatBtn = new JToggleButton(FreeSeat[i+(j*3)]);
				freeSeatBtn.setForeground(Color.WHITE);
				freeSeatBtn.setFont(new Font("굴림", Font.BOLD, 15));
				freeSeatBtn.setBorder((new LineBorder(new Color(255, 200, 0), 1)));
				freeSeatBtn.setBackground(Color.BLACK);
				freeSeatBtn.setBounds(24+(207*i), 22+(95*j), 182, 67);
				MiniPanelFreeSeats.add(freeSeatBtn);
		}	
	}
		JToggleButton FreeSeatBtn = new JToggleButton(FreeSeat[9]);
		FreeSeatBtn.setForeground(Color.WHITE);
		FreeSeatBtn.setFont(new Font("굴림", Font.BOLD, 15));
		FreeSeatBtn.setBorder((new LineBorder(new Color(255, 200, 0), 1)));
		FreeSeatBtn.setBackground(Color.BLACK);
		FreeSeatBtn.setBounds(24, 309, 182, 67);
		MiniPanelFreeSeats.add(FreeSeatBtn);
		
//		String a = FreeSeatBtn.getText().split("<br>")[0];
//		CreateLabel(a.substring(0,a.length()-9));
		
				
		//5인실 미니패널
		JPanel MiniPanelGroupRoom = new JPanel();
		MiniPanelGroupRoom.setBackground(new Color(0, 0, 0));
		MiniPanelGroupRoom.setBounds(25, 213, 646, 377);
		buyPanel.add(MiniPanelGroupRoom);
		MiniPanelGroupRoom.setLayout(null);
		
		String[] groupRoom = {"<HTML><body style='text-align:center;'>5인실 1회권<br> 2시간 12,000원"
				+ "</body></HTML>","<HTML><body style='text-align:center;'>5인실 1회권<br> 추가 1시간"
				+ " 6,000원</body></HTML>"};
			
		
		for (int i = 0; i < 2; i++) {
				JToggleButton GroupRoomBtn = new JToggleButton(groupRoom[i]);
				GroupRoomBtn.setForeground(Color.WHITE);
				GroupRoomBtn.setFont(new Font("굴림", Font.BOLD, 15));
				GroupRoomBtn.setBorder((new LineBorder(new Color(255, 200, 0), 1)));
				GroupRoomBtn.setBackground(Color.BLACK);
				GroupRoomBtn.setBounds(24+(207*i), 22, 182, 67);
				MiniPanelGroupRoom.add(GroupRoomBtn);
		}
		//일회권 미니패널
		JPanel MiniPanelADayPass = new JPanel();
		MiniPanelADayPass.setBackground(new Color(0, 0, 0));
		MiniPanelADayPass.setBounds(25, 213, 646, 377);
		buyPanel.add(MiniPanelADayPass);
		MiniPanelADayPass.setLayout(null);
		
		String[] aDayPass = {"<HTML><body style='text-align:center;'>자유석 1회권<br>2시간 3,000원</body>"
				+ "</HTML>","<HTML><body style='text-align:center;'>자유석 1회권<br>4시간 5,000원</body>"
				+ "</HTML>","<HTML><body style='text-align:center;'>자유석 1회권<br>6시간 7,000원</body>"
				+ "</HTML>","<HTML><body style='text-align:center;'>자유석 1회권<br> 추가 1시간 1,000원"
				+ "</body></HTML>","<HTML><body style='text-align:center;'>5인실 1회권<br> 2시간 12,000원"
				+ "</body></HTML>","<HTML><body style='text-align:center;'>5인실 1회권<br> 추가 1시간"
				+ " 6,000원</body></HTML>"};
		
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				int temp = i;
				int temp2 = j;
				JToggleButton ADayPassBtn = new JToggleButton(aDayPass[i+(j*3)]);
				ADayPassBtn.setForeground(Color.WHITE);
				ADayPassBtn.setFont(new Font("굴림", Font.BOLD, 15));
				ADayPassBtn.setBorder((new LineBorder(new Color(255, 200, 0), 1)));
				ADayPassBtn.setBackground(Color.BLACK);
				ADayPassBtn.setBounds(24+(207*i), 22+(95*j), 182, 67);
				
				ADayPassBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						price = aDayPass[temp+(temp2*3)];
						String a = price.split("<br>")[1];
						if(temp==1&&temp2 == 1) {
							totalAmount.setText(a.substring(5 ,a.length()-14));
						}else if(temp2 == 1) {
							totalAmount.setText(a.substring(8 ,a.length()-14));
						}else if(temp2 == 0) {
							totalAmount.setText(a.substring(4 ,a.length()-14));
						}
					}
				});
				MiniPanelADayPass.add(ADayPassBtn);
		}
			}
		//기간권 미니패널
		JPanel MiniPanelWeekPass = new JPanel();
		MiniPanelWeekPass.setBackground(new Color(0, 0, 0));
		MiniPanelWeekPass.setBounds(25, 213, 646, 377);
		buyPanel.add(MiniPanelWeekPass);
		MiniPanelWeekPass.setLayout(null);
			
		String[] weekpass = {"<HTML><body style='text-align:center;'>\uC790\uC720\uC11D"
				+ " \uAE30\uAC04\uAD8C<br>1\uC8FC 40,000\uC6D0</body></HTML>","<HTML><body style='text-align:center;'>\uC790\uC720\uC11D "
				+ "\uAE30\uAC04\uAD8C<br>2\uC8FC 75,000\uC6D0</body></HTML>","<HTML><body style='text-align:center;'>\uC790\uC720\uC11D"
				+ " \uAE30\uAC04\uAD8C<br>4\uC8FC 100,000\uC6D0</body></HTML>" };
		
		for (int i = 0; i < 3; i++) {
				JToggleButton WeekPassBtn = new JToggleButton(weekpass[i]);
				WeekPassBtn.setForeground(Color.WHITE);
				WeekPassBtn.setFont(new Font("굴림", Font.BOLD, 15));
				WeekPassBtn.setBorder((new LineBorder(new Color(255, 200, 0), 1)));
				WeekPassBtn.setBackground(Color.BLACK);
				WeekPassBtn.setBounds(24+(207*i), 22, 182, 67);
				MiniPanelWeekPass.add(WeekPassBtn);
		}
		//시간권 미니패널
		JPanel MiniPanelDayPass = new JPanel();
		MiniPanelDayPass.setBackground(new Color(0, 0, 0));
		MiniPanelDayPass.setBounds(25, 213, 646, 377);
		buyPanel.add(MiniPanelDayPass);
		MiniPanelDayPass.setLayout(null);
			
		String[] dayPass = {"<HTML><body style='text-align:center;'>자유석 시간권<br> "
				+ "20시간 29,000원</body></HTML>","<HTML><body style='text-align:center;'>"
				+ "자유석 시간권<br>50시간 59,000원</body></HTML>","<HTML><body style='text-align:"
				+ "center;'>자유석 시간권<br> 100시간 88,000원</body></HTML>"};	
		for (int i = 0; i < 3; i++) {
				JToggleButton DayPassBtn = new JToggleButton(dayPass[i]);
				DayPassBtn.setForeground(Color.WHITE);
				DayPassBtn.setFont(new Font("굴림", Font.BOLD, 15));
				DayPassBtn.setBorder((new LineBorder(new Color(255, 200, 0), 1)));
				DayPassBtn.setBackground(Color.BLACK);
				DayPassBtn.setBounds(24+(207*i),22, 182, 67);
				MiniPanelDayPass.add(DayPassBtn);
			}

		MiniPanelFreeSeats.setVisible(false);
		MiniPanelGroupRoom.setVisible(false);
		MiniPanelADayPass.setVisible(false);
		MiniPanelWeekPass.setVisible(false);
		MiniPanelDayPass.setVisible(false);
		
		ArrayList<JPanel> AllType = new ArrayList<JPanel>();
		AllType.add(MiniPanelFreeSeats); //자유석
		AllType.add(MiniPanelGroupRoom); //5인실
		AllType.add(MiniPanelADayPass); //일회권
		AllType.add(MiniPanelWeekPass); //기간권
		AllType.add(MiniPanelDayPass); //시간권
		
		FreeSeats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JPanel bigPanel:AllType) {
					if(bigPanel!=MiniPanelFreeSeats) 
						bigPanel.setVisible(false);
					else 
						MiniPanelFreeSeats.setVisible(!MiniPanelFreeSeats.isVisible());
				}	
			}
		});
		
		GroupRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JPanel bigPanel:AllType) {
					if(bigPanel!=MiniPanelGroupRoom) 
						bigPanel.setVisible(false);
					else 
						MiniPanelGroupRoom.setVisible(!MiniPanelGroupRoom.isVisible());
				}	
			}
		});
		WeekPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JPanel bigPanel:AllType) {
					if(bigPanel!=MiniPanelWeekPass) { 
						bigPanel.setVisible(false);
						ADayPass.setVisible(false);
						DayPass.setVisible(false);
						
					}else 
						MiniPanelWeekPass.setVisible(!MiniPanelWeekPass.isVisible());
						ADayPass.setVisible(!MiniPanelWeekPass.isVisible());
						DayPass.setVisible(!MiniPanelWeekPass.isVisible());
						
				}	
			}
		});
		
		ADayPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JPanel bigPanel:AllType) {
					if(bigPanel!=MiniPanelADayPass) {
						bigPanel.setVisible(false);
						WeekPass.setVisible(false);
						DayPass.setVisible(false);
					}else 
						MiniPanelADayPass.setVisible(!MiniPanelADayPass.isVisible());
						WeekPass.setVisible(!MiniPanelADayPass.isVisible());
						DayPass.setVisible(!MiniPanelADayPass.isVisible());
						
				}	
			}
		});
		DayPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JPanel bigPanel:AllType) {
					if(bigPanel!=MiniPanelDayPass) { 
						bigPanel.setVisible(false);
						WeekPass.setVisible(false);
						ADayPass.setVisible(false);
					}else 
						MiniPanelDayPass.setVisible(!MiniPanelDayPass.isVisible());
						WeekPass.setVisible(!MiniPanelDayPass.isVisible());
						ADayPass.setVisible(!MiniPanelDayPass.isVisible());
						
				}	
			}
		});
		
		//홈버튼 (상단)
		JButton backToHome = new JButton("처음으로");
		backToHome.setBackground(Color.ORANGE);
		backToHome.setFont(new Font("굴림", Font.BOLD, 15));
		backToHome.setForeground(new Color(0, 0, 0));
		backToHome.setBounds(8, 32, 212, 49);
		bigPanel.add(backToHome);
				
		//회원정보
		JTextField id = new JTextField();
		id.setFont(new Font("굴림", Font.BOLD, 15));
		id.setForeground(new Color(0, 0, 0));
		id.setBounds(218, 32, 260, 49);
		bigPanel.add(id);
		id.setColumns(10);
				
		//로그아웃
		JButton logOut = new JButton("LogOut");
		logOut.setForeground(new Color(0, 0, 0));
		logOut.setBackground(Color.ORANGE);
		logOut.setFont(new Font("굴림", Font.BOLD, 15));
		logOut.setBounds(476, 32, 212, 49);
		bigPanel.add(logOut);

		//이전버튼
		JButton btnPrevious = new JButton("<<\uC774\uC804");
		btnPrevious.setFont(new Font("굴림", Font.BOLD, 18));
		btnPrevious.setBackground(Color.ORANGE);
		btnPrevious.setBounds(0, 650, 345, 63);
		buyPanel.add(btnPrevious);

		
		//다음버튼
		JButton btnNext = new JButton(">>\uB2E4\uC74C");
		btnNext.setFont(new Font("굴림", Font.BOLD, 18));
		btnNext.setBackground(Color.ORANGE);
		btnNext.setBounds(345, 650, 345, 63);
		buyPanel.add(btnNext);
		//다음버튼누르면 결제창으로 이동
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buyPanel.setVisible(!buyPanel.isVisible());	
					paymentPanel.setVisible(true);
			}	
		});
		
		//안내문구 
		Notice1 = new JTextField();
		Notice1.setBackground(Color.BLACK);
		Notice1.setForeground(Color.WHITE);
		Notice1.setText("\u203B\uC77C\uD68C\uAD8C \uC0C1\uD488\uC740 \uD1F4\uC2E4\uC2DC "
			+ "\uC18C\uBA78\uB418\uBA70 \uD658\uBD88\uC774 \uBD88\uAC00\uD569\uB2C8\uB2E4");
		Notice1.setFont(new Font("굴림", Font.BOLD, 13));
		Notice1.setBorder((new LineBorder(new Color(0, 0, 0), 1)));
		Notice1.setBounds(15, 600, 668, 21);
		buyPanel.add(Notice1);
		Notice1.setColumns(10);
		
		Notice2 = new JTextField();
		Notice2.setText("\u203B\uC2DC\uAC04\uAD8C \uC774\uC6A9\uC2DC \uB0A8\uC740 \uC2DC"
			+ "\uAC04\uC740 \uC790\uB3D9 \uC801\uB9BD\uB418\uC5B4 \uC7AC\uBC29\uBB38\uC2DC "
			+ "\uC774\uC6A9\uAC00\uB2A5\uD569\uB2C8\uB2E4.");
		Notice2.setForeground(Color.WHITE);
		Notice2.setFont(new Font("굴림", Font.BOLD, 13));
		Notice2.setBorder((new LineBorder(new Color(0, 0, 0), 1)));
		Notice2.setColumns(10);
		Notice2.setBackground(Color.BLACK);
		Notice2.setBounds(15, 620, 668, 21);
		buyPanel.add(Notice2);


		
		//결제창패널
		paymentPanel.setBackground(Color.BLACK);
		paymentPanel.setBounds(0, 0, 700, 800);
		bigPanel.add(paymentPanel);
		paymentPanel.setLayout(null);
		paymentPanel.setVisible(false);

		JPanel miniPanel_payment = new JPanel();
		miniPanel_payment.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		miniPanel_payment.setBackground(Color.BLACK);
		miniPanel_payment.setBounds(23, 33, 646, 420);
		paymentPanel.add(miniPanel_payment);
		miniPanel_payment.setLayout(null);

		JLabel paymentSelect = new JLabel("\uACB0\uC81C\uBC29\uBC95\uC120\uD0DD");
		paymentSelect.setForeground(Color.ORANGE);
		paymentSelect.setFont(new Font("굴림", Font.BOLD, 30));
		paymentSelect.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.ORANGE));
		paymentSelect.setBounds(220, 90, 190, 35);
		miniPanel_payment.add(paymentSelect);
		
		//이전버튼 -누르면 시간권/기간권 선택창 이동
		JButton btnPrevious2 = new JButton("<<\uC774\uC804");
		btnPrevious2.setFont(new Font("굴림", Font.BOLD, 18));
		btnPrevious2.setBackground(Color.ORANGE);
		btnPrevious2.setBounds(0, 730, 345, 63);
		paymentPanel.add(btnPrevious2);
		btnPrevious2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentPanel.setVisible(!paymentPanel.isVisible());	
				buyPanel.setVisible(true);
			}	
		});
		
		//다음버튼
		JButton btnNext2 = new JButton(">>\uB2E4\uC74C");
		btnNext2.setFont(new Font("굴림", Font.BOLD, 18));
		btnNext2.setBackground(Color.ORANGE);
		btnNext2.setBounds(345, 730, 345, 63);
		paymentPanel.add(btnNext2);

		//구입상품
		JLabel selectedProduct = new JLabel("\uAD6C\uC785\uC0C1\uD488");
		selectedProduct.setHorizontalAlignment(SwingConstants.CENTER);
		selectedProduct.setForeground(Color.WHITE);
		selectedProduct.setBackground(Color.GRAY);
		selectedProduct.setFont(new Font("굴림", Font.BOLD, 15));
		selectedProduct.setBounds(12, 149, 136, 49);
		miniPanel_payment.add(selectedProduct);
		
		//보유포인트
		JLabel points = new JLabel("\uBCF4\uC720\uD3EC\uC778\uD2B8");
		points.setBackground(Color.GRAY);
		points.setHorizontalAlignment(SwingConstants.CENTER);
		points.setForeground(Color.WHITE);
		points.setFont(new Font("굴림", Font.BOLD, 15));
		points.setBounds(12, 214, 136, 49);
		miniPanel_payment.add(points);

		//보유포인트
		JPanel pointsDetail = new JPanel();
		pointsDetail.setBounds(148, 214, 464, 49);
		pointsDetail.setBackground(Color.WHITE);
		pointsDetail.setLayout(null);
		miniPanel_payment.add(pointsDetail);
		
		JButton btnUseAllPoints = new JButton("\uC804\uC561\uC0AC\uC6A9");
		btnUseAllPoints.setBackground(Color.BLUE);
		btnUseAllPoints.setForeground(Color.WHITE);
		btnUseAllPoints.setFont(new Font("굴림", Font.BOLD, 10));
		btnUseAllPoints.setBounds(243, 10, 77, 30);
		pointsDetail.add(btnUseAllPoints);

		JTextField ownPoints = new JTextField();
		ownPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		ownPoints.setText("0");
		ownPoints.setBounds(330, 10, 100, 30);
		ownPoints.setFont(new Font("굴림", Font.BOLD, 14));
		pointsDetail.add(ownPoints);
		
		JTextField P = new JTextField();
		P.setText("P");
		P.setBounds(430, 10, 23, 30);
		P.setFont(new Font("굴림", Font.BOLD, 16));
		P.setBorder((new LineBorder(new Color(0, 0, 0), 0)));
		pointsDetail.add(P);

	
		//사용포인트
		JLabel usedPoints = new JLabel("\uC0AC\uC6A9\uD3EC\uC778\uD2B8");
		usedPoints.setHorizontalAlignment(SwingConstants.CENTER);
		usedPoints.setBackground(Color.GRAY);
		usedPoints.setForeground(Color.WHITE);
		usedPoints.setFont(new Font("굴림", Font.BOLD, 15));
		usedPoints.setBounds(12, 289, 136, 49);
		miniPanel_payment.add(usedPoints);
				
		JTextField selectedProductDetail = new JTextField();
		selectedProductDetail.setFont(new Font("굴림", Font.BOLD, 12));
		selectedProductDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		selectedProductDetail.setColumns(10);
		selectedProductDetail.setBounds(148, 149, 464, 49);
		miniPanel_payment.add(selectedProductDetail);
		
		JPanel usedPointsDetail = new JPanel();
		usedPointsDetail.setBounds(148, 289, 464, 49);
		usedPointsDetail.setBackground(Color.WHITE);
		usedPointsDetail.setLayout(null);
		miniPanel_payment.add(usedPointsDetail);
		
		JButton btncancelPoints = new JButton("\uC0AC\uC6A9\uCDE8\uC18C");
		btncancelPoints.setBackground(Color.RED);
		btncancelPoints.setForeground(Color.WHITE);
		btncancelPoints.setFont(new Font("굴림", Font.BOLD, 10));
		btncancelPoints.setBounds(243, 10, 77, 30);
		usedPointsDetail.add(btncancelPoints);
		
		JTextField notice = new JTextField();
		notice.setForeground(new Color(250, 128, 114));
		notice.setHorizontalAlignment(SwingConstants.RIGHT);
		notice.setText("(1,000P 단위로 사용가능)");
		notice.setBorder((new LineBorder(new Color(0, 0, 0), 0)));
		notice.setBounds(47, 10, 193, 30);
		notice.setFont(new Font("굴림", Font.BOLD, 14));
		usedPointsDetail.add(notice);
		
		JTextField cancelPoints = new JTextField();
		cancelPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		cancelPoints.setText("0");
		cancelPoints.setBounds(330, 10, 100, 30);
		cancelPoints.setFont(new Font("굴림", Font.BOLD, 14));
		usedPointsDetail.add(cancelPoints);
		
		JTextField P2 = new JTextField();
		P2.setText("P");
		P2.setBounds(430, 10, 23, 30);
		P2.setFont(new Font("굴림", Font.BOLD, 16));
		P2.setBorder((new LineBorder(new Color(0, 0, 0), 0)));
		usedPointsDetail.add(P2);

		//총결제금액
		JLabel total = new JLabel("\uCD1D\uACB0\uC81C\uAE08\uC561");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setBackground(Color.BLACK);
		total.setForeground(Color.WHITE);
		total.setFont(new Font("굴림", Font.BOLD, 15));
		total.setBounds(12, 364, 136, 49);
		miniPanel_payment.add(total);
		
		totalAmount = new JLabel();
//		totalAmount.setText("0");
		totalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		totalAmount.setBounds(148, 364, 464, 49);
		totalAmount.setBackground(Color.WHITE);
		totalAmount.setForeground(Color.WHITE);
		totalAmount.setFont(new Font("굴림", Font.BOLD, 15));
		miniPanel_payment.add(totalAmount);
		

//		totalAmount = new JTextField();
//		totalAmount.setText("0");
//		totalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
//		totalAmount.setBackground(Color.BLACK);
//		totalAmount.setForeground(Color.ORANGE);
//		totalAmount.setFont(new Font("굴림", Font.BOLD, 15));
//		totalAmount.setBorder((new LineBorder(new Color(0, 0, 0), 1)));
//		totalAmount.setColumns(10);
//		totalAmount.setBounds(148, 364, 464, 49);
//		miniPanel_payment.add(totalAmount);
		
		
		
		JPanel miniPanel_paymentMethod = new JPanel();
		miniPanel_paymentMethod.setBackground(Color.BLACK);
		miniPanel_paymentMethod.setBounds(23, 450, 646, 270);
		paymentPanel.add(miniPanel_paymentMethod);
		miniPanel_paymentMethod.setLayout(null);
		
		JTextField Paytext = new JTextField("결제 방법을 선택하시고 다음버튼을 눌러주세요.");
		Paytext.setBackground(Color.BLACK);
		Paytext.setHorizontalAlignment(SwingConstants.CENTER);
		Paytext.setBounds(130,5,403,28);
		Paytext.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		Paytext.setFont(new Font("굴림", Font.BOLD, 15));
		Paytext.setForeground(Color.ORANGE);
		miniPanel_paymentMethod.add(Paytext);
				
		JLabel payCard = new JLabel(new ImageIcon("UserInfo\\credit img.jpg"));
		payCard.setSize(138, 100);
		payCard.setLocation(49, 60);
		payCard.setFont(new Font("굴림", Font.BOLD, 15));
		payCard.setForeground(Color.ORANGE);
		payCard.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		miniPanel_paymentMethod.add(payCard);
		
		JRadioButton payWithCard = new JRadioButton("카드결제(삼성페이가능)");
		payWithCard.setBackground(Color.BLACK);
		payWithCard.setBounds(40, 160, 177, 23);
		payWithCard.setFont(new Font("굴림", Font.PLAIN, 12));
		payWithCard.setForeground(Color.WHITE);
		miniPanel_paymentMethod.add(payWithCard);
		
		
		
		
//		label=new JLabel("");
//		label.setBounds(37,48,200,108);
		
		
		
		
		
	}

	 static void RedVariable() {
		  
		  userInfo = new ArrayList<ArrayList<String>>();
		    
		  String strID = "11111111;22222222;33333333;";
		  String strPW = "1111;2222;3333;";
		  String strCart = "자유석 시간권(10시간)/자유석 기간권(4주)/5인실 일회권(3시간);";
		  String strPaymentHistory = ""
		    + "자유석 시간권(10시간)/30,000원/2021-04-23/800P/0P/이용중#"     // A고객이 2개의 결제 내역 보유시 #으로 연결
		    + "자유석 일회권(3시간)/3,000원/2021-03-03/500P/0P/종료;"
		    
		    + "5인석 일회권(2시간)/10,000원/2021-03-01/100P/0P/종료;"        // B고객의 1개 결제 내역의 세부 정보는 / 로 연결
		    
		    + "자유석 시간권(20시간)/60,000원/2021-05-06/2000P/2000P/이용중;";  // 다음 고객과의 구별은 ; 로 한다.

		  String[] aryID = strID.split(";");
		  String[] aryPW = strPW.split(";");
		  String[] aryCart = strCart.split(";");
		  String[] aryPaymentHistory = strPaymentHistory.split(";");
		  
		  ArrayList<String> ID = new ArrayList<String>(Arrays.asList(aryID));
		  ArrayList<String> PW = new ArrayList<String>(Arrays.asList(aryPW));
		  ArrayList<String> Cart = new ArrayList<String>(Arrays.asList(aryCart));
		  ArrayList<String> paymentHistory = new ArrayList<String>(Arrays.asList(aryPaymentHistory));
		  
		  userInfo.add(ID);    userInfo.add(PW);   userInfo.add(Cart);   userInfo.add(paymentHistory);
		  }
	 public void CreateLabel(String str) {
		 label.setText(str);
	 }
}
