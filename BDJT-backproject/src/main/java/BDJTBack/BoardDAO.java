package BDJTBack;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public BoardDAO() {
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
	
//	초기, 최신순 갤러리 업로드
	public ArrayList<BoardDO> initialBoard() {
		ArrayList<BoardDO> galleryList = new ArrayList<BoardDO>();
		sql = "select b.photo, b.title, b.url, b.skill, b.creationDate, b.orderRcmnd , u.github from users u , board b where u.id = b.id; ";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDo.boardDO = new BoardDO();
				boardDO.setPhoto(rs.getString("photo"));
				boardDO.setTitle(rs.getString("title"));
				boardDO.setUrl(rs.getString("url"));
				boardDO.setSkill(rs.getString("skill"));
				boardDO.setCreationDate(rs.getString("creationDate"));
				boardDO.setOrderRcmnd(rs.getString("orderRcmnd"));
				userDO.setGithub(rs.getString("github"));
				
				galleryList.add(boardDO);
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
		
		
		return galleryList;
	}
	
	
	

}
