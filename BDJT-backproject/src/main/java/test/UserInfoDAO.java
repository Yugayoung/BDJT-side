package chap09;

import java.sql.*;
import java.util.*;

public class UserInfoDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public UserInfoDAO() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		if(conn == null) {
			try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url, "scott","tiger");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int insertUserInfo(UserInfoDO userDO) {
		int rowCount = 0;
		
		sql = "insert into user_info (username, email) values (?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDO.getUsername());
			pstmt.setString(2, userDO.getEmail());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return rowCount;
	}
	
	public ArrayList<UserInfoDO> getAllUserInfo() {
		ArrayList<UserInfoDO> userList = new ArrayList<UserInfoDO>();
		sql = "select username, email from user_info";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				UserInfoDO userDO = new UserInfoDO();
				userDO.setUsername(rs.getString("username"));
				userDO.setEmail(rs.getString("email"));
				
				userList.add(userDO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(stmt != null) {
				try {
					stmt.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return userList;
	}
}
