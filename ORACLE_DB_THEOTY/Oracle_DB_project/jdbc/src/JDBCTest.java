import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.day.sql.MyConnection;

public class JDBCTest {

	public static void testUPDATE() {
		//dB연결
		Connection con = null;
		try {
		con = com.day.sql.MyConnection.getConnection();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return;
		}
		//SQL구문 송신
		String updateSQL = "UPDATE customer SET name = '테스트' WHERE name LIKE '%n%'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			int rowcnt = stmt.executeUpdate(updateSQL);
			System.out.println("총"+rowcnt + "건의 이름이 \'테스트\'로 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	public static void testUPDATE(String idValue, String pwdValue, String nameValue) {
		//dB연결
				Connection con = null;
				try {
				con = com.day.sql.MyConnection.getConnection();
				}catch(SQLException sqle) {
					sqle.printStackTrace();
					return;
				}
		//SQL구문을 DB에 송신
		PreparedStatement pstmt = null;
		String selectSQL = "SELECT * "
				+ "FROM customer "
				+ "WHERE id = ?";
		ResultSet rs = null; //결과수신
		try {
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setString(1, idValue);
			rs = pstmt.executeQuery();
			
			System.out.println("SQL구문을  DB에 송신, 결과수신");
			if(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				System.out.println(id +" : "+ pwd + " : "+ name);
				
				if(!pwdValue.equals("")&&!nameValue.equals("")) {
					String updateSQL = "UPDATE customer SET pwd =  '" 
							+ pwdValue +"'" +", name =  '" 
									+ nameValue +"'"
							+ "WHERE id = '"+idValue+"'";
					Statement stmt = null;
					try {
						stmt = con.createStatement();
						stmt.executeUpdate(updateSQL);
						System.out.println("id : "+ idValue + "변경될 pwd : "+ pwdValue + "변경될 name : " +nameValue);
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						if(stmt != null) {
							try {
								stmt.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if(con != null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}else if(!pwdValue.equals("")) {
					String updateSQL = "UPDATE customer SET pwd =  '" 
							+ pwdValue +"'"
							+ "WHERE id = '"+idValue+"'";
					Statement stmt = null;
					try {
						stmt = con.createStatement();
						stmt.executeUpdate(updateSQL);
						System.out.println("id : "+ idValue + "변경될 pwd : "+ pwdValue + " name : " );
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						if(stmt != null) {
							try {
								stmt.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if(con != null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}else if(!nameValue.equals("")) {
					String updateSQL = "UPDATE customer SET name =  '" 
							+ nameValue +"'"
							+ "WHERE id = '"+idValue+"'";
					Statement stmt = null;
					try {
						stmt = con.createStatement();
						stmt.executeUpdate(updateSQL);
						System.out.println("id : "+ idValue + "변경될 name : "+ nameValue );
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						if(stmt != null) {
							try {
								stmt.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if(con != null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}else {
					System.out.println("변경할 값이 없습니다.");
				}
				
			}else {
				System.out.println("검색된 값이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void testINSERT() {
		//dB연결
				Connection con = null;
				try {
				con = com.day.sql.MyConnection.getConnection();
				}catch(SQLException sqle) {
					sqle.printStackTrace();
					return;
				}
		
		//SQL구문송신
		String insertSQL = "INSERT INTO customer(id,pwd,name) VALUES ('id9','p9','n9')";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			int rowcnt = stmt.executeUpdate(insertSQL);
			if(rowcnt ==1) {
				System.out.println("id9번 고객 추가 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}finally {
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		//SQL결과수신
		//결과활용
		//DB연결 닫기
	}
	public static void testINSERT(String id, String pwd, String name) {
		//dB연결
				Connection con = null;
				try {
				con = com.day.sql.MyConnection.getConnection();
				}catch(SQLException sqle) {
					sqle.printStackTrace();
					return;
				}
		
		//SQL구문송신
		String insertSQL = "INSERT INTO customer(id,pwd,name) VALUES (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertSQL);
			//int rowcnt = stmt.executeUpdate(insertSQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			
			int rowcnt = pstmt.executeUpdate();
			if(rowcnt ==1) {
				System.out.println("id9번 고객 추가 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		//SQL결과수신
		//결과활용
		//DB연결 닫기
	}
 	public static void testSELECT() {
//		//DB연결
//				String url = "jdbc:oracle:thin:@localhost:1521:xe";
//				String user = "hr";
//				String password = "hr";
//				Connection con = null;
//				try {
//					con = DriverManager.getConnection(url, user, password);
//					System.out.println("DB연결 성공");
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					return;
//				}
 		//dB연결
 				Connection con = null;
 				try {
 				con = com.day.sql.MyConnection.getConnection();
 				}catch(SQLException sqle) {
 					sqle.printStackTrace();
 					return;
 				}
				//SQL구문을 DB에 송신
				Statement stmt = null;
				String selectSQL = "SELECT employee_id, "
						+ "first_name, "
						+ "hire_date, "
						+ "salary, "
						+ "salary + (salary*NVL(commission_pct, 0)) 실급여 "
									+ "FROM employees";
				ResultSet rs = null; //결과수신
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(selectSQL);
					System.out.println("SQL구문을  DB에 송신, 결과수신");
					while(rs.next()) {//결과행의 커서 이동 메서드
						int emp_id = rs.getInt("employee_id");
						String f_name = rs.getString(2);
						java.sql.Date hire_dt = rs.getDate("hire_date");
						int sal = rs.getInt("salary");
						float real_sal = rs.getFloat("실급여");
						System.out.println(emp_id +" : "+ f_name + " : "+ hire_dt + " : "+sal +" : "+ real_sal);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					//DB와 연결해제 null이 아닐경우에만 클로즈 기능! 각각 try/catch문으로 방지할것!
					if(rs !=null) {
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(stmt !=null) {
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(con !=null) {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		
	}
	public static void testSELECT(String idValue) {
//		//DB연결
//				String url = "jdbc:oracle:thin:@localhost:1521:xe";
//				String user = "hr";
//				String password = "hr";
//				Connection con = null;
//				try {
//					con = DriverManager.getConnection(url, user, password);
//					System.out.println("DB연결 성공");
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					return;
//				}
		//dB연결
				Connection con = null;
				try {
				con = com.day.sql.MyConnection.getConnection();
				}catch(SQLException sqle) {
					sqle.printStackTrace();
					return;
				}
				
				//SQL구문을 DB에 송신
				PreparedStatement pstmt = null;
				String selectSQL = "SELECT * "
						+ "FROM customer "
						+ "WHERE id = ?";
				ResultSet rs = null; //결과수신
				try {
					pstmt = con.prepareStatement(selectSQL);
					pstmt.setString(1, idValue);
					rs = pstmt.executeQuery();
					
					System.out.println("SQL구문을  DB에 송신, 결과수신");
					if(rs.next()) {
						String id = rs.getString("id");
						String pwd = rs.getString("pwd");
						String name = rs.getString("name");
						System.out.println(id +" : "+ pwd + " : "+ name);
					}else {
						System.out.println("검색된 값이 없습니다.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					//DB와 연결해제 null이 아닐경우에만 클로즈 기능! 각각 try/catch문으로 방지할것!
					com.day.sql.MyConnection.close(con, pstmt, rs);
				}
		
	}
	public static void main(String[] args) {
		// JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
//		testSELECT();
//		testINSERT();
//		testUPDATE();
//		키보드로 입력 받은 id,pwd, name 값을 customer 테이블에 추가
//		Scanner sc = new Scanner(System.in);
//		System.out.println("아이디 : ");
//		String idValue = sc.nextLine();
//		System.out.println("비밀번호 : ");
//		String pwdValue = sc.nextLine();
//		System.out.println("이름 : ");
//		String nameValue = sc.nextLine();
//		
//		testINSERT(idValue,pwdValue,nameValue);
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String idValue = sc.nextLine();
		//testSELECT(idValue); 아이디 비번 이름 출력 PreparedStatement활용~
		
		System.out.print("비밀번호를 변경하려면 값을 입력하세요 [변경안하려면 enter를 누르세요]:");
		String pwdValue = sc.nextLine(); //enter를 누른경우 pwdValue변수값은 ""가 된다
//		System.out.print("입력한 비밀번호값 : [" + pwdValue + "]");
		System.out.print("이름을 변경하려면 값을 입력하세요[변경안하려면 enter를 누르세요]:");
		String nameValue = sc.nextLine();
		testUPDATE(idValue, pwdValue, nameValue);
		
		
		
	}

}
