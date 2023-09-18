package test;

import java.sql.*;
import java.util.*;

public class TestDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public TestDAO() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		if(conn == null) {
			try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url, "system","oracle");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int insertUserInfo(TestDO testDO) {
		int rowCount = 0;
		
		sql = "insert into users (id, github) values (?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, testDO.getId());
			pstmt.setString(2, testDO.getGithub());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(" 로드 !");
			e.printStackTrace();
		}
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}
				catch(Exception e) {
					System.out.println("JDBC 드라이버 !");
					e.printStackTrace();
				}
			}
		}
		
		return rowCount;
	}
	
	public ArrayList<TestDO> users() {
		ArrayList<TestDO> userList = new ArrayList<TestDO>();
		sql = "select id, github from users";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				TestDO testDO = new TestDO();
				testDO.setId(rs.getString("id"));
				testDO.setGithub(rs.getString("github"));
				
				userList.add(testDO);
			}
		}
		catch(Exception e) {
			System.out.println("JDBC 드라이버 로드 !");
			e.printStackTrace();
			
		}
		finally {
			if(stmt != null) {
				try {
					stmt.close();
				}
				catch(Exception e) {
					System.out.println("JDBC 드라이버 로드 실패 !");
					e.printStackTrace();
					
				}
			}
		}
		
		
		return userList;
	}
}
