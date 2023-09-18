package BDJTBack;

import java.io.File;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;


public class BoardDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	private String savePath = "./views/image";
	
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
	
//	갤러리 테스트를 위한 파일업로드 샘플
	public void insertuploadInfo(List<FileItem> items, BoardDO newBoard) {
	    try {
	        for (FileItem item : items) {
	            if (!item.isFormField()) {
	                String fileName = new File(item.getName()).getName();
	                String fileurl = savePath + File.separator + fileName;
	                File storeFile = new File(fileurl);
	                
	                // 파일 이름 중복 처리
	                int counter = 1;
	                while (storeFile.exists()) {
	                    String[] parts = fileName.split("\\.");
	                    String newFileName = parts[0] + "(" + counter + ")." + parts[1];
	                    fileurl = savePath + File.separator + newFileName;
	                    storeFile = new File(fileurl);
	                    counter++;
	                }

	                // 데이터베이스에 새 게시물 추가
	                sql = "INSERT INTO board (photo, title, url, skill, creationDate, orderRcmnd, id) " +
	                      "VALUES (?, ?, ?, ?, ?, ?, ?)";
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setString(1, newBoard.getPhoto());
	                pstmt.setString(2, newBoard.getTitle());
	                pstmt.setString(3, newBoard.getUrl());
	                pstmt.setString(4, newBoard.getSkill());
	                pstmt.setTimestamp(5, Timestamp.valueOf(newBoard.getCreationDate()));
	                pstmt.setInt(6, newBoard.getOrderRcmnd());
	                pstmt.setString(7, newBoard.getId()); // 사용자 아이디 설정

	                pstmt.executeUpdate();

	                // 파일을 실제로 업로드하고 저장 경로를 데이터베이스에 저장해야 합니다.
	                item.write(storeFile);
	            }
	        }
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
	
//	초기, 최신순 갤러리 업로드
	public ArrayList<BoardDO> initialBoard() {
		ArrayList<BoardDO> galleryList = new ArrayList<BoardDO>();
		sql = "select b.photo, b.title, b.url, b.skill, b.creationDate, b.orderRcmnd , "
				+ "u.github from users u , board b "
				+ "where u.id = b.id order by creationDate DESC";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDO boardDO = new BoardDO();
				UsersDO userDO = new UsersDO();
				boardDO.setPhoto(rs.getString("photo"));
				boardDO.setTitle(rs.getString("title"));
				boardDO.setUrl(rs.getString("url"));
				boardDO.setSkill(rs.getString("skill"));
				
				// 문자열을 LocalDateTime으로 변환
                String dateString = rs.getString("creationDate");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime creationDate = LocalDateTime.parse(dateString, formatter);
                boardDO.setCreationDate(creationDate);
                
				boardDO.setOrderRcmnd(rs.getInt("orderRcmnd"));
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
	// 좋아요
	public ArrayList<BoardDO> rcmndBoard() {
		ArrayList<BoardDO> galleryList = new ArrayList<BoardDO>();
		sql = "SELECT b.photo, b.title, b.url, b.skill, b.creationDate, b.orderRcmnd, u.github " +
			      "FROM users u, board b " +
			      "WHERE u.id = b.id " +
			      "ORDER BY b.orderRcmnd DESC";


		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDO boardDO = new BoardDO();
				UsersDO userDO = new UsersDO();
				boardDO.setPhoto(rs.getString("photo"));
				boardDO.setTitle(rs.getString("title"));
				boardDO.setUrl(rs.getString("url"));
				boardDO.setSkill(rs.getString("skill"));
				
				// 문자열을 LocalDateTime으로 변환
                String dateString = rs.getString("creationDate");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime creationDate = LocalDateTime.parse(dateString, formatter);
                boardDO.setCreationDate(creationDate);
                
				boardDO.setOrderRcmnd(rs.getInt("orderRcmnd"));
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