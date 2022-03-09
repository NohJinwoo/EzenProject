package Proj;

import java.sql.*;

public class InsertLogin {
	public Connection con;
	public PreparedStatement pstmt;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##ezen";
	String password = "ezen1234";

	public int insertLogin(LoginVO Login) throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		int rows = 0;
		try {

			String query = "insert into Login values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, LoginTest.ppid.getText());
			pstmt.setString(2, LoginTest.pppwd.getText());
			pstmt.setString(3, LoginTest.ppname.getText());
			pstmt.setString(4, LoginTest.age.getText());
			pstmt.setString(5, LoginTest.address.getText());
			pstmt.setString(6, LoginTest.food.getText());

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