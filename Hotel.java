package HotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Hotel {
	static String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	static String username = "root";
	static String password = "root";

	public static boolean HotelTable() {

		Scanner sc = new Scanner(System.in);
		String sqlDB = "CREATE TABLE Hotel" + "(id INTEGER ," + " hotel_name VARCHAR(8) not NULL,"
				+ "hotel_location varchar(20)," + "created_date Date not NULL," + "updated_date Date,"
				+ "is_Active  BIT not NULL," + "PRIMARY KEY AUTO_INCREMENT (id))";

		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);

			if ((m >= 0)) {
				System.out.println("Created table in given database...");

			} else {
				System.out.println(" table already Created in given database...");

				return true;
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}
	
	
	
	
	

	public static void insertIntoTable(int number) throws Throwable {

		String hotel_name = "majaan";
		String hotel_location = "muscat";
		Date created_date = new Date(System.currentTimeMillis());
		Date updated_date = new Date(System.currentTimeMillis());
		boolean is_Active = true;

		Random rn = new Random();
		Integer NumberToAdd = rn.nextInt(100);
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			for (int i = 0; i <= number; i++) {

				String insert1 = "Insert into Hotel values(" + i  + ",'" + hotel_name + "','"
						+ hotel_location + "','" + created_date + "','" + updated_date + "'," + 1 + ")";
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
			String sql = "select * from hotel where id='" + inputid + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= inputid) {
				int id = rs.getInt("id");

				String hotelname = rs.getString("hotel_name");
				String hotellocation = rs.getString("hotel_location");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + hotelname + " " + hotellocation + " " + createddate + " " + updateddate
						+ " " + isActive);
				count++;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void printHotel(int top) {
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
			String sql="SELECT * FROM Hotel ORDER BY id LIMIT "+top;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= top) {
				int id = rs.getInt("id");

				String hotelname = rs.getString("hotel_name");
				String hotellocation = rs.getString("hotel_location");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + hotelname + " " + hotellocation + " " + createddate + " " + updateddate
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

			System.out.println("Please Enter any id to Update hotel data :");
			int userinput = scanner.nextInt();
			System.out.println("Please Enter the new Hotel name:");
			String hotelname = scanner.next();
			System.out.println("Please Enter the new Hotel location:");
			String hotellocatin = scanner.next();

			String sql = "UPDATE hotel SET hotel_name='" + hotelname + "',hotel_location='" + hotellocatin
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

			System.out.println("Please Enter any id to Update hotel data :");
			int userinput = scanner.nextInt();
			
			

			String sql = "UPDATE hotel SET is_Active =false WHERE id<=" + userinput ;
			int result = st.executeUpdate(sql);
		} catch (Exception ex) {
			System.err.println(ex);

		}

	}

	
	public static void deleteById() {
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
			int inputid=scanner.nextInt();
			String sql = "select * from hotel where id='" + inputid + "'";
			
			int rs = st.executeUpdate(sql);

		      // execute the preparedstatement
		      
		      conn.close();
		   
	} catch (Exception ex) {
		System.err.println(ex);
	}
}
	public static void exit() {
		System.out.println("**************");
		System.out.println("Thank You");
		System.exit (0);
		System.out.println("**************");
	}
	
	
	
}
	
	
	//public static void makeIsActiveFalseById() {

	