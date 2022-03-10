package Proj;

import java.sql.*;
import java.util.ArrayList;

public class SelectChatting {	
	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	public ChattingVO Ch;
	
	public ArrayList<ChattingVO> list(String pword) {
		ArrayList<ChattingVO> list = new ArrayList<ChattingVO>();
		try {
			LoginDB Lo = new LoginDB();
			
			String query = "SELECT * FROM Chatting";
			if (pword != null) {
				query += " where word ='" + pword + "'";
			}
			System.out.println(query);
			rs=Lo.stmt.executeQuery(query);
			rs.last();
			
			if(rs.getRow() ==0) {
				System.out.println("0 row selected...");
			} else {
				rs.previous();
				while(rs.next()) {
				String word =rs.getString("word");
				String answer = rs.getString("answer");
				ChattingVO data = new ChattingVO(word, answer);
				list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
