package Proj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectChatting {	
	public Connection con;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public ChattingVO Ch;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##ezen";
	String password = "ezen1234";
	
	public List<ChattingVO> selectChatting(ChattingVO Ch) throws ClassNotFoundException, SQLException  {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		List<ChattingVO> list = new ArrayList<ChattingVO>();
		try {

			String query = "select * from Chatting where word=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, LoginTest.ta.getText());
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				//DTO 인스턴스 생성 - 인스턴스 필드에는 기본값 저장 
				Ch =new ChattingVO();
				//검색행의 컬럼값을 DTO 인스턴스의 필드값으로 매핑 처리(Oracle >> Java)
				Ch.setWord(rs.getString("word"));
				Ch.setAnswer(rs.getString("answer"));
				list.add(Ch);
			}
		} catch (SQLException e) {
			System.out.println("[에러]insertLogin() 메소드의 SQL 오류 = " + e.getMessage());
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
