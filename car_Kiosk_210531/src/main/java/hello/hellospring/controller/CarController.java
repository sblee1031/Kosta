package hello.hellospring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CarDAO;
import dao.CustomerDAO;
import dao.MemberDAO;
import dto.CarDTO;
import dto.ChargeDTO;
import dto.CustomerDTO;
import dto.MemberDTO;

@Controller
public class CarController {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	CarDAO carDAO = CarDAO.getInstance();
	MemberDAO memberDao = MemberDAO.getInstance();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	
	@GetMapping("index")
	public String Index() {
		
		return "index";
	}
	
	@GetMapping("log_in")
	public String Login() {
		
		return "log_in";
	}
//	@GetMapping("/car")
//	public String Car2(Model model) {
//		List<CarDTO> list = carDAO.select_All();
//		model.addAttribute("carDTO", list);
//		return "carList";
//	}
	@GetMapping("cartable")//차 테이블
	public String CarTable(Model model) {
		List<CarDTO> list = carDAO.select_All();
		System.out.println(list.get(0).isKey());
		model.addAttribute("carDTO", list);
		return "car-table";
	}
	@PostMapping("cardelete")//대여고객 삭제
	public String cardelete(@RequestParam("name") String carNum) {
		carDAO.delete_Table(carNum);
		return "redirect:cartable";
	}
	@PostMapping("caradd")//대여고객 추가
	public String caradd(@RequestParam("car_Name") String car_Name, @RequestParam("car_Num") String car_Num, @RequestParam("car_Url") String car_Url,
			@RequestParam("car_Iskey") boolean car_Iskey,@RequestParam("car_Size") String car_Size	
			) {
		System.out.println(car_Name+car_Num+car_Url+" "+car_Iskey);
				carDAO.add_Table(car_Name, car_Num,   car_Url,
						  car_Iskey, car_Size);
		return "redirect:cartable";
	}
	
	@GetMapping("membertable")//멤버 테이블
	public String MemberTable(Model model) {
		List<MemberDTO> list = memberTable();
		model.addAttribute("memberDTO", list);
		return "member-table";
	}
	
	@GetMapping("customertable")//대여고객 테이블
	public String customerTable(Model model) {
		List<CustomerDTO> list = customerTable();
		model.addAttribute("customerDTO", list);
		return "customer-table";
	}
	@PostMapping("customerdelete")//대여고객 삭제
	public String customerdelete(@RequestParam("name") String name) {
//		System.out.println(name);
		customerDAO.delete_Table(name);
		return "redirect:customertable";
	}
	
	@GetMapping("chargetable")//대여고객 테이블
	public String chargeTable(Model model) {
		List<ChargeDTO> list = chargeTable();
		model.addAttribute("chargeDTO", list);
		return "charge-table";
	}
	
	private List<ChargeDTO> chargeTable() {//요금 테이블
		getConnection();	
		List<ChargeDTO> login_arr = new ArrayList<>();
		String sql = "SELECT * FROM Charge" ; // DB에서 ID체크
		//물음표에는 우리가 처리한 데이터 관련 넣기
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.execute();
			rs = pstmt.executeQuery();
					
			while(rs.next()) {//전체 테이블 탐색
				ChargeDTO chargeDTO = new ChargeDTO(
				          rs.getString("car_Size")   
				          ,rs.getInt("ten_Min")
				          ,rs.getInt("one_Hour")
				          ,rs.getInt("three_Hour")
				          ,rs.getInt("six_Hour")
				          ,rs.getInt("one_Day")
				          ,rs.getInt("three_Day")
						);
				login_arr.add(chargeDTO);
			};
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("검색된 DB 없음");
		} finally {
			try{
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		return login_arr;
}
	
	private List<CustomerDTO> customerTable() {
		getConnection();	
		List<CustomerDTO> login_arr = new ArrayList<>();
		String sql = "SELECT * FROM Customer" ; // DB에서 ID체크
		//물음표에는 우리가 처리한 데이터 관련 넣기
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.execute();
			rs = pstmt.executeQuery();
					
			while(rs.next()) {//전체 테이블 탐색
				CustomerDTO customerDTO = new CustomerDTO(
						 rs.getString("li_Num")
						,rs.getString("li_Date")
						,rs.getString("ph_Num")
						,rs.getString("car_Num")
						,rs.getBoolean("Agree")
						,rs.getString("lent_Time")
						,rs.getString("start_Time")
						,rs.getString("return_Time")
						,rs.getString("pay_Method")
						,rs.getInt("pay_Money")
						,rs.getString("overpay_Method")
						,rs.getString("overpay_Money")
						,rs.getBoolean("isKey")
						);
				login_arr.add(customerDTO);
			};
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("검색된 DB 없음");
		} finally {
			try{
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		return login_arr;
}
	
	private List<MemberDTO> memberTable() {
			getConnection();	
			List<MemberDTO> login_arr = new ArrayList<>();
			String sql = "SELECT * FROM Member" ; // DB에서 ID체크
			//물음표에는 우리가 처리한 데이터 관련 넣기
			try {
				pstmt = conn.prepareStatement(sql);	
				pstmt.execute();
				rs = pstmt.executeQuery();
						
				while(rs.next()) {//전체 테이블 탐색
					MemberDTO dto = new MemberDTO(
							rs.getString("member_Id")
							,rs.getString("member_Pw")
					,rs.getString("li_Num")
					,rs.getString("li_Date")
					,rs.getString("ph_Num")
					,rs.getInt("mileage")
						);
					login_arr.add(dto);
				};
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("검색된 DB 없음");
			} finally {
				try{
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
					if(conn!=null)conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
						
			}
			return login_arr;
	}

	public Connection getConnection() {
		try {
			String dbFile = ".\\db\\carKiosk.db";
			String dbFileUrl ="jdbc:sqlite:"+dbFile;
			conn=DriverManager.getConnection(dbFileUrl);
			System.out.println("DB Connection Success!");
			
			String dropSql = "SELECT MAX(mem_Num) FROM Member";// 마지막 seq 값 가져오는 SQL문		
			pstmt = conn.prepareStatement(dropSql);	
			pstmt.execute();
			rs = pstmt.executeQuery();
			String seq = rs.getString(1);
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return conn;
}
}
