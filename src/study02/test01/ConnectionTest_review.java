package study02.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest_review {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "bdi";
			String pwd = "12345678";
			
			Connection con = DriverManager.getConnection(url, id, pwd);
			Statement stmt = con.createStatement();
			String sql = "select * from user_info";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("id") + " / " + rs.getString("pwd") + " / " + rs.getString("name") + " / " + rs.getString("age") + " / " + rs.getString("etc"));
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
