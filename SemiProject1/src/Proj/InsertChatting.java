package Proj;

import java.sql.*;


public class InsertChatting {
	public Connection con;
	public PreparedStatement pstmt;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##ezen";
	String password = "ezen1234";
	
	public int insertChatting(ChattingVO Chatting) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		int rows = 0;
		try {
			
			String query = "insert into Chatting values(?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, LoginTest.word.getText());
			pstmt.setString(2, LoginTest.pppwd.getText());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertLogin() 메소드의 SQL 오류 = " + e.getMessage());
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
}
