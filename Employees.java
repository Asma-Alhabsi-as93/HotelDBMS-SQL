package HotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Employees {
	public static boolean  Employees() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
		 String sqlDB = "CREATE TABLE Employees"
		         +"(id INTEGER,"
				 +"employee_type_id INTEGER "+" REFERENCES Employee_Type(id),"
				+"room_id INTEGER "+" REFERENCES Hotel(id)," 
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
	public static void insertIntoTable(int number) throws Throwable {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		 Scanner sc = new Scanner(System.in);
	int employee_type_id  = 1;
	int room_id  = 1;
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

			String insert1 = "Insert into Employees values(" + i  + ",'" +employee_type_id+ "',"+ room_id +",'"+created_date+"','" + updated_date + "'," + 1 + ")";
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
			String sql = "select * from  Employees where id='" + inputid + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= inputid) {
				int id = rs.getInt("id");

				int employee_type_id  = rs.getInt("employee_type_id");
				int  room_id  = rs.getInt(" room_id ");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + employee_type_id + " " +  room_id  + " " + createddate + " " + updateddate
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
			String sql="SELECT * FROM Employees ORDER BY id LIMIT "+top;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= top) {
				int id = rs.getInt("id");

				int employee_type_id = rs.getInt("employee_type_id");
				int  room_id  = rs.getInt(" room_id ");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(id + " " + employee_type_id + " " + room_id + " " + createddate + " " + updateddate
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

			System.out.println("Please Enter any id to Update employees data :");
			int userinput = scanner.nextInt();
			System.out.println("Please Enter the new employee_type_id:");
			int employee_type_id = scanner.nextInt();
			System.out.println("Please Enter the new room_id:");
			int room_id = scanner.nextInt();

			String sql = "UPDATE Employee_Type SET employee_type_id=" +employee_type_id + ",room_id='" + room_id
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

			System.out.println("Please Enter any id to Update emplooyes data :");
			int userinput = scanner.nextInt();
			
			

			String sql = "UPDATE Employees SET is_Active =false WHERE id<=" + userinput ;
			int result = st.executeUpdate(sql);
		} catch (Exception ex) {
			System.err.println(ex);

		}

	}

}
