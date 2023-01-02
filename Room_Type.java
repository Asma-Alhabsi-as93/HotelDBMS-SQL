package HotelDBMS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Room_Type {
	public static boolean  room_type() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 String sqlDB = "CREATE TABLE room_type"
		         +"(id INTEGER , "
				 +" room_type_name VARCHAR(8) not NULL, "
				+"created_date Date ," 
				 +"updated_date Date,"
				+"is_Active  Boolean not NULL,"
				 +"PRIMARY KEY (id))";
		 String insert ="Insert into room_type values(1,'doble','2002-02-20','2003-02-02',true)";
		 
		 Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url,username, password);
				Statement st = conn.createStatement();
				int m = st.executeUpdate(sqlDB);
				int s = st.executeUpdate(insert);
				if ((m >= 0)&&(s>=1)){
					System.out.println("Created table in given database...");
					System.out.println("inserted Successfully...");
				} else {
					System.out.println(" table already Created in given database...");
					System.out.println("insertion failed...");
					return true;
				}
				conn.close();
			}
			catch (Exception ex) {
				System.err.println(ex);
			}
			return false;
}
	public static void readFromTable(){
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 System.out.println(" how many users you have to print");
		 String SQL="SELECT * FROM room_type ORDER BY id LIMIT 10;";
			Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url,username, password);
				Statement st = conn.createStatement();
				ResultSet m = st.executeQuery(SQL);
				 while(m.next()){
			            //Display values
			            System.out.print("ID: " + m.getInt("id"));
			            System.out.print(", room_type_name: " + m.getString("room_type_name"));
			            System.out.print(", created_date: " + m.getDate("created_date"));
			            System.out.println(", updated_date: " + m.getDate("updated_date"));
			            System.out.println(", is_Active: " + m.getBoolean("is_Active"));
				 }
				conn.close();
			}
			catch (Exception ex) {
				System.err.println(ex);
			}
		 
			}
}
