package com.day.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootTest
public class MemberTest {
	  @Autowired
	  private PasswordEncoder pwencoder;
	  
	  @Autowired
	  private DataSource ds;
	  
	  @Test
	  public void testInsertMember() {

	    String sql = "insert into tbl_member(userid, userpw, username) values (?,?,?)";
	    
	    for(int i = 1; i <= 6; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	        
	        pstmt.setString(2, pwencoder.encode("pw" + i));
	        
	        if(i <3) {
	          
	          pstmt.setString(1, "user"+i);
	          pstmt.setString(3,"일반사용자"+i);//user1, user2
	          
	        }else if (i <5) {
	          pstmt.setString(1, "manager"+i); //manager3, manager4
	          pstmt.setString(3,"운영자"+i);
	          
	        }else {
	          
	          pstmt.setString(1, "admin"+i); //admin5:, admin6
	          pstmt.setString(3,"관리자"+i);
	          
	        }
	        
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
	      }
	    }//end for
	  }
	  
	  @Test
	  public void testInsertAuth() {
	    String sql = "insert into tbl_member_auth (userid, auth) values (?,?)";
	    
	    for(int i = 1; i <= 6; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	      
	        
	        if(i <3) {
	          
	          pstmt.setString(1, "user"+i);
	          pstmt.setString(2,"ROLE_USER");
	          
	        }else if (i <5) {
	          
	          pstmt.setString(1, "manager"+i);
	          pstmt.setString(2,"ROLE_MANAGER");
	          
	        }else {
	          
	          pstmt.setString(1, "admin"+i);
	          pstmt.setString(2,"ROLE_ADMIN");
	          
	        }
	        
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
	      }
	    }//end for
	  }
}
