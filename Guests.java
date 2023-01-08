package HotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
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
		 String SQL="SELECT * FROM Guests ORDER BY id LIMIT 10;";
			Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url,username, password);
				Statement st = conn.createStatement();
				ResultSet m = st.executeQuery(SQL);
				 while(m.next()){
			            //Display values
			            System.out.print("Id: " + m.getInt("id"));
			            System.out.print(", guest_name: " + m.getString("guest_name"));
			            System.out.print(", guest_phone: " + m.getDate("guest_phone"));
			            System.out.println(",guest_accompanying_members: " + m.getInt("guest_accompanying_members"));
			            System.out.println(",room_id : " + m.getInt("room_id "));
			            System.out.println(",hotel_id : " + m.getInt("hotel_id "));
			            System.out.println(",created_date : " + m.getDate("created_date "));
			            System.out.println(",updated_date : " + m.getDate("updated_date"));
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
	String guest_name = "king room";
	String guest_phone = "+997999000";
	String guest_accompanying_members = "king room";
	int room_id = 4;
	int hotel_id = 5;
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

			String insert1 = "Insert into Guests values(" + i  + ",'" +guest_name + "','" +guest_phone + "','" +guest_accompanying_members + "'," +room_id + "','" +hotel_id  + "','"
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
			String sql = "select * from Guests where id='" + inputid + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= inputid) {
				int id = rs.getInt("id");

				String guest_name = rs.getString("guest_name");
				String guest_phone= rs.getString("guest_phone");
				String guest_accompanying_members=rs.getString("guest_accompanying_members");
				int room_id=rs.getInt("room_id");
				int hotel_id=rs.getInt("hotel_id");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + guest_name +" "+ guest_phone +""+guest_accompanying_members+" "+room_id+" "+" "+hotel_id+" "+" " + createddate + " " + updateddate
						+ " " + isActive);
				count++;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	public static void printGuests(int top) {
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
			String sql="SELECT * FROM Guests ORDER BY id LIMIT "+top;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= top) {
				int id = rs.getInt("id");

				String guest_name = rs.getString("guest_name");
				int room_id=rs.getInt("room_id");
				int hotel_id=rs.getInt("hotel_id");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + guest_name +" "+room_id+" "+ hotel_id+"  " + createddate + " " + updateddate
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
			System.out.println("Please Enter the new guest_name:");
			String guest_name  = scanner.next();
			

			String sql = "UPDATE Guests SET guest_name='" + guest_name + "';"
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

			System.out.println("Please Enter any id toGuests data :");
			int userinput = scanner.nextInt();
			
			

			String sql = "UPDATE Guests SET is_Active =false WHERE id<=" + userinput ;
			int result = st.executeUpdate(sql);
		} catch (Exception ex) {
			System.err.println(ex);

		}

	}
}
