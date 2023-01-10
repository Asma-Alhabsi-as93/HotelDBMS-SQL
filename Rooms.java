package HotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Rooms {
	public static boolean  room() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 String sqlDB = "CREATE TABLE room"
		         +"(id INTEGER,"
				 +"room_type_id INTEGER "+"  REFERENCES  room_type(id),"
				+"hotel_id INTEGER "+"  REFERENCES Hotel(id)," 
				 +"updated_date Date,"
				+"created_date Date not null,"
				+"is_Active Boolean not NULL,"
				 +"PRIMARY KEY  AUTO_INCREMENT (id))";
		 
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
	public static void readFromTable(){
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 System.out.println(" how many users you have to print");
		 String SQL="SELECT * FROM room ORDER BY id LIMIT 10;";
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
			            System.out.print(", room_type_id: " + m.getInt("room_type_id"));
			            System.out.print(", hotel_id: " + m.getInt("hotel_id"));
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
	
	
	public static void insertIntoTable(int number) throws Throwable {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
	int room_type_id = 3;
	int hotel_id=5;
	Date created_date = new Date(System.currentTimeMillis());
	Date updated_date = new Date(System.currentTimeMillis());
	boolean is_Active = true;
//	System.out.println(" how many users you have to print");
//	int number1 = sc.nextInt();
	Random rn = new Random();
	Integer NumberToAdd = rn.nextInt(100);
	Connection conn = null;
	try {
		Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, username, password);
		for (int i = 0; i <= number; i++) {

			String insert1 = "Insert into room (room_type_id, hotel_id,created_date,updated_date, is_Active)"
					+ "values(" + room_type_id + "," + hotel_id + ",'"
					  + created_date + "','" + updated_date + "'," + 1 + ")";
			System.out.println(insert1);

			Statement st = conn.createStatement();
			st.executeUpdate(insert1);
			System.out.println(insert1 + " Records Inserted Successfully!");

		}
	} catch (Exception ex) {
		System.err.println(ex);
	} finally {
		if (conn != null)
			conn.close();
	}
}
	
	
	public static void getById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter the id: ");
			int inputid = scanner.nextInt();
			int count = 1;
			String sql = "select * from room where id='" + inputid + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= inputid) {
				int id = rs.getInt("id");

				int room_type_id = rs.getInt("room_type_id");
				int hotel_id = rs.getInt("hotel_id");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + room_type_id +  " " + createddate +" "+hotel_id+""  + updateddate
						+ " " + isActive);
				count++;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	
	public static void printRoom(int top) {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);
			int count = 1;
			String sql="SELECT * FROM room ORDER BY id LIMIT "+top;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= top) {
				int id = rs.getInt("id");

				int room_type_id = rs.getInt("room_type_id");
				int hotel_id = rs.getInt("hotel_id");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + room_type_id +" "+ hotel_id+"  " + createddate + " " + updateddate
						+ " " + isActive);
				count++;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	
	public static void updateById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			conn = DriverManager.getConnection(url, user, pass);
			// Creating a statement
			Statement st = conn.createStatement();

			System.out.println("Please Enter any id to Update room type data :");
			int userinput = scanner.nextInt();
			System.out.println("Please Enter the new room_type name:");
			int room_type_id  = scanner.nextInt();
			

			String sql = "UPDATE room_type SET room=" + room_type_id + "';"
					+ "' WHERE id='" + userinput + "'";
			int result = st.executeUpdate(sql);
		} catch (Exception ex) {
			System.err.println(ex);

		}

	}
	
	public static void makeIsActiveFalseById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			conn = DriverManager.getConnection(url, user, pass);
			// Creating a statement
			Statement st = conn.createStatement();

			System.out.println("Please Enter any id to eroom_type data :");
			int userinput = scanner.nextInt();
			
			

			String sql = "UPDATE room SET is_Active =false WHERE id<=" + userinput ;
			int result = st.executeUpdate(sql);
		} catch (Exception ex) {
			System.err.println(ex);

		}

	}

}
