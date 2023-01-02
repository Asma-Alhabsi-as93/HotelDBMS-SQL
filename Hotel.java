package HotelDBMS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Hotel {
	public static boolean  HotelTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 String sqlDB = "CREATE TABLE Hotel"
		         +"(id INTEGER ,"
				 +" hotel_name VARCHAR(8) not NULL,"
				 +"hotel_location varchar(20),"
				+"created_date Date not NULL," 
				 +"updated_date Date,"
				+"is_Active  Boolean not NULL,"
				 +"PRIMARY KEY (id))";
		 
		 String insert ="Insert into Hotel values(1,'almaha','muscat','2002-02-20','2003-02-02',true)";
		 
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
		 String SQL="SELECT * FROM Hotel ORDER BY id LIMIT 100;";
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
			            System.out.print(", hotel_name: " + m.getString("hotel_name"));
			            System.out.print(", hotel_location: " + m.getString("hotel_location"));
			            System.out.println(", created_date: " + m.getDate("created_date"));
			            System.out.println(", updated_date: " + m.getDate("updated_date"));
			            System.out.println(", is_Active: " + m.getBoolean("is_Active"));
				 }
				conn.close();
			}
			catch (Exception ex) {
				System.err.println(ex);
			}
		 
			}
	
			
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner (System .in);
boolean hasExit=true;
do {
	System.out.println("1:craete hotel table");
	System.out.println("2:Room_Type");
	System.out.println("3:room ");
	System.out.println("4: Guests");
	System.out.println("5:Employee_Type");
	System.out.println("6:Employees");
	int select = sc.nextInt();

	switch (select) {
	case 1:
		 HotelTable();
		 readFromTable();
		break;
		
	case 2:
		Room_Type.room_type();
		Room_Type.readFromTable();
		 break;
	case 3:
		Rooms.room();
		break;
		
	case 4:
		Guests.Guests();
		break;
		
	case 5:
			Employee_Type.Employee_Type();
		break;
	case 6:
		Employees.Employees();
		break;
	}
}while (hasExit);
	}
	
}

