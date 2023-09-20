package BDJTBack;

import java.sql.*;
import java.util.ArrayList;

import test.TestDO;

public class UsersDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public UsersDAO() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		if(conn == null) {
			try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url, "bdjt","bdjt");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//회원가입
	public int insertUserInfo(UsersDO usersDO) {
	    int rowCount = 0;

	    sql = "insert into users (id, name, password, birthdate, github) "
	            + "values (?, ?, ?, ?, ?)";

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, usersDO.getId());
	        pstmt.setString(2, usersDO.getName());
	        pstmt.setString(3, usersDO.getPassword());
	        pstmt.setString(4, usersDO.getBirthdate());
	        pstmt.setString(5, usersDO.getGithub());
	        System.out.println("2");

	        rowCount = pstmt.executeUpdate(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println(e+"1");
	    } finally {
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	                System.out.println("2");
	            } catch (Exception e) {
	            	System.out.println(e+"3");
	                e.printStackTrace();
	            }
	        }
	    }

	    return rowCount; 
	}

	
	//로그인 
	public boolean loginUser(String id, String password) {
	    boolean loggedIn = false;

	    String sql = "SELECT * FROM users WHERE id = ? AND password = ?";
	    
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, password);
	        
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            loggedIn = true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return loggedIn;
	}


}
