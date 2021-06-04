package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dto.MemberDTO;
import dto.CustomerDTO;

public class Pay_Check extends JFrame implements Runnable{

	private JFrame frame;
	private JLabel timeLabel;
	private int sec = 5;//타이머 시작시간
	MemberDTO memberDTO = MemberDTO.getInstance();
	CustomerDTO customerDTO = CustomerDTO.getInstance();
	public Pay_Check() {
		System.out.println(customerDTO.toString());
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("코드의 美");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		ImageIcon image1 = new ImageIcon("./img/check.png");
		Image img = image1.getImage();
		Image changImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changIcon = new ImageIcon(changImg);
		JLabel lblNewLabel = new JLabel(changIcon);
		
		lblNewLabel.setBounds(394, 293, 155, 150);

		lblNewLabel.setVisible(true);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("결제가 완료 되었습니다");
		lblNewLabel_1.setForeground(new Color(102, 102, 204));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel_1.setBounds(273, 446, 397, 71);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("키오스크 우측 하단에서 키를 수령하세요");
		lblNewLabel_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 27));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(180, 506, 584, 124);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_6 = new JButton("돌아가기");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorder(new LineBorder(Color.black,2,true));
		btnNewButton_6.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		
		Thread t1 = new Thread(this);//타이머 쓰레드 호출 메서드
		t1.start();
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberDTO.setMember_Id(null);
				Main main = new Main();
				t1.stop();
				frame.dispose();
			}
		});
		btnNewButton_6.setBounds(387, 800, 170, 60);
		frame.getContentPane().add(btnNewButton_6);
		
		timeLabel = new JLabel(""); //타이머 표시 라벨
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		timeLabel.setBounds(330, 674, 293, 80);
		frame.getContentPane().add(timeLabel);
		
		
	}

	private void main() {
		JFrame frame = this.frame;
		frame.setResizable(false);
		frame.setTitle("코드의 美");
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(500, 0, 960, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		memberDTO.setMember_Id(null);
		Main main = new Main(frame,null);
		

		
	}

	@Override
	public void run() {
		
		while (sec!=0) {
			try {
				String time = sec + "초 후 자동종료";
				Thread.sleep(1000);
				timeLabel.setText(time);
				sec = sec-1;
				System.out.println("sec : "+sec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("타이머종료");
		memberDTO.setMember_Id(null);
		main();
		frame.dispose();
	}
}


