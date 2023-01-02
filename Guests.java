package HotelDBMS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Guests {
	public static boolean  Guests() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 String sqlDB = "CREATE TABLE Guests"
		         +"(id INTEGER,"
				 +"guest_name VARCHAR(10) not NULL,"
				+"guest_phone VARCHAR(10) not NULL ," 
				 +"guest_accompanying_members INTEGER not NULL,"
				+"room_id  INTEGER "+" REFERENCES room(id),"
				 +"hotel_id INTEGER "+" REFERENCES Hotel(id),"
				+"created_date Date  not null,"
				 +"updated_date Date,"
				+"is_Active Boolean not NULL,"
				 +"PRIMARY KEY (id))";
		 
		 Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url,username, password);
				Statement st = conn.createStatement();
				int m = st.executeUpdate(sqlDB);
				if ((m >= 0)){
					System.out.println("Created table in given database...");
				} else {
					System.out.println(" table already Created in given database...");
					return true;
				}
				conn.close();
			}
			catch (Exception ex) {
				System.err.println(ex);
			}
			return false;
}
}
