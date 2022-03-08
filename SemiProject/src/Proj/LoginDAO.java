package Proj;

import java.sql.*;
import java.util.ArrayList;

public class LoginDAO {
	private LoginDB Lo;
	public Connection con;
	public Statement stmt;
	public ResultSet rs;

	public ArrayList<LoginVO> list(String pid) {
		ArrayList<LoginVO> list = new ArrayList<LoginVO>();

		try {
			Lo = new LoginDB();

			String query = "SELECT * FROM Login";
			if (pid != null) {
				query += " where id ='" + pid + "'";
			}
			System.out.println(query);
			rs = Lo.stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				rs.previous();
				while (rs.next()) {
					String id = rs.getString("id");
					String pwd = rs.getString("pwd");

					LoginVO data = new LoginVO(id, pwd);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}