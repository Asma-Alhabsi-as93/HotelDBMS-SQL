package HotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Employee_Type {
	public static boolean  Employee_Type() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 String sqlDB = "CREATE TABLE Employee_Type"
		         +"(id INTEGER ,"
				 +" employee_type_name VARCHAR(8) not NULL,"
				 +"hotel_location varchar(20),"
				+"created_date Date not NULL," 
				 +"updated_date Date,"
				+"is_Active  Boolean not NULL,"
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
	public static void insertIntoTable(int number) throws Throwable {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
	String employee_type_name = "Ahamed";
	String hotel_location = "gubrah";
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

			String insert1 = "Insert into Employee_Type values(" + i  + ",'" + employee_type_name + "','" + hotel_location + "','"
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
			String sql = "select * from  Employee_Type where id='" + inputid + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= inputid) {
				int id = rs.getInt("id");

				String employee_type_name = rs.getString("employee_type_name");
				String hotellocation = rs.getString("hotel_location");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + employee_type_name + " " + hotellocation + " " + createddate + " " + updateddate
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
			String sql="SELECT * FROM Employee_Type ORDER BY id LIMIT "+top;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= top) {
				int id = rs.getInt("id");

				String employee_type_name = rs.getString("employee_type_name");
				String hotellocation = rs.getString("hotel_location");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + employee_type_name + " " + hotellocation + " " + createddate + " " + updateddate
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

			System.out.println("Please Enter any id to Update employee_type_name data :");
			int userinput = scanner.nextInt();
			System.out.println("Please Enter the new employee_type_name name:");
			String employee_type_name = scanner.next();
			System.out.println("Please Enter the new Hotel location:");
			String hotellocatin = scanner.next();

			String sql = "UPDATE Employee_Type SET employee_type_name='" +employee_type_name + "',hotel_location='" + hotellocatin
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

			System.out.println("Please Enter any id to Update employee_type data :");
			int userinput = scanner.nextInt();
			
			

			String sql = "UPDATE Employee_Type SET is_Active =false WHERE id<=" + userinput ;
			int result = st.executeUpdate(sql);
		} catch (Exception ex) {
			System.err.println(ex);

		}

	}


}
