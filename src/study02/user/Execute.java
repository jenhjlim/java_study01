package study02.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Execute {
	Connection con = DBCon.getCon();
	Scanner scan = new Scanner(System.in);
	
	void insert() {
		System.out.println("Please enter your id : ");
		String id = "'" + scan.nextLine() + "'";
		System.out.println("Please enter your pwd : ");
		String pwd = "'" + scan.nextLine() + "'";
		System.out.println("Please enter your name : ");
		String name = "'" + scan.nextLine() + "'";
		System.out.println("Please enter your age : ");
		String age = "'" + scan.nextLine() + "'";
		System.out.println("Please enter your etc : ");
		String etc = "'" + scan.nextLine() + "'";
		String sql = "insert into user_info(id, pwd, name,age, etc)";
		sql += " values(" + id + "," + pwd + "," + name + "," + age + "," + etc + ")";
		
		try {
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println("# of Inserted items : " + result);
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void delete() {
		System.out.println("Please enter an ID that you want to delete: ");
		String id = "'" + scan.nextLine() + "'";
		String sql = "Delete user_info where id = " + id;
		
		try {
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println("# of deleted items : " + result);
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void update() {
		System.out.println("Please enter an ID that you want to update: ");
		String id = "'" + scan.nextLine() + "'";
		System.out.println("Please update the age of the ID : ");
		String age = "'" + scan.nextLine() + "'";
		String sql = "Update user_info set age =" + age + " where id = " + id;
		
		try {
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println("# of updated items : " + result);
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void select() {
		System.out.println("Please enter alphabet(s) that ID(s) start with that you want to see: ");
		String id = scan.nextLine();
		String sql = "Select * from user_info where id like '" + id + "%'";
		
		try {
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println("# of items to show : " + result);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Execute ex = new Execute();
		
		// q를 입력할때까지 반복해서 물어보기
		String orderNum = ex.scan.nextLine();
		
		do {
			System.out.println("Enter a number that matches what you want to do : ");
			System.out.println("1. Insert data");
			System.out.println("2. Delete a user");
			System.out.println("3. Modify information of a user.");
			System.out.println("4. Show information of user(s).");
			System.out.println("q. Quit this program.");
			System.out.println("=====================================");
			
			if (orderNum.equals("1")){
				ex.insert();
			} else if(orderNum.equals("2")) {
				ex.delete();
			} else if(orderNum.equals("3")) {
				ex.update();
			} else if(orderNum.equals("4")) {
				ex.select();
			} 
		} while(!orderNum.equals("q"));
	}
}
