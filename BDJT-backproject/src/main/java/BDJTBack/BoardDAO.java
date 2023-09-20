package BDJTBack;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
	
//	파일 업로드
	public void insertuploadInfo(BoardDO newBoard) {
	    try {
	                sql = "INSERT INTO board (photo, title, url, skill, creationDate, id) " +
	                      "VALUES (?, ?, ?, ?, ?, ?)";
	                
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setString(1, newBoard.getPhoto());
	                pstmt.setString(2, newBoard.getTitle());
	                pstmt.setString(3, newBoard.getUrl());
	                pstmt.setString(4, newBoard.getSkill());
	                pstmt.setTimestamp(5, Timestamp.valueOf(newBoard.getCreationDate()));
	                pstmt.setString(6, newBoard.getId()); // 사용자 아이디 설정
	                System.out.println(newBoard+"-1");
	                pstmt.executeUpdate();
	                // 파일을 실제로 업로드하고 저장 경로를 데이터베이스에 저장해야 합니다.
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
//	초기 갤러리 업로드
	public ArrayList<BoardDO> initialBoard() {
		ArrayList<BoardDO> galleryList = new ArrayList<BoardDO>();
		sql = "SELECT b.photo, b.title, b.url, b.skill, b.creationDate, u.github " +
			      "FROM users u, board b " +
			      "WHERE u.id = b.id ";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDO boardDO = new BoardDO();
				boardDO.setPhoto(rs.getString("photo"));
				boardDO.setTitle(rs.getString("title"));
				boardDO.setUrl(rs.getString("url"));
				boardDO.setSkill(rs.getString("skill"));
                String dateString = rs.getString("creationDate");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime creationDate = LocalDateTime.parse(dateString, formatter);
                boardDO.setCreationDate(creationDate);
				boardDO.setGithub(rs.getString("github"));
				
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
	
	public ArrayList<BoardDO> searchBoardByTechStack(String skill) {
	    ArrayList<BoardDO> searchResults = new ArrayList<>();
	    sql = "SELECT * FROM board WHERE skill LIKE ?";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + skill + "%");
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            BoardDO boardDO = new BoardDO();
	            boardDO.setPhoto(rs.getString("photo"));
	            boardDO.setTitle(rs.getString("title"));
	            boardDO.setUrl(rs.getString("url"));
	            boardDO.setSkill(rs.getString("skill"));
	            // 문자열을 LocalDateTime으로 변환
	            String dateString = rs.getString("creationDate");
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	            LocalDateTime creationDate = LocalDateTime.parse(dateString, formatter);
	            boardDO.setCreationDate(creationDate);
	            boardDO.setId(rs.getString("id"));
	            searchResults.add(boardDO);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 여기서 ResultSet, PreparedStatement, Connection을 닫아줘야 합니다.
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return searchResults;
	}
	
}
	


	
	
	
