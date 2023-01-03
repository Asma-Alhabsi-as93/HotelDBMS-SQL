package HotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Hotel {
	static String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	static String username = "root";
	static String password = "root";

	public static boolean HotelTable() {

		Scanner sc = new Scanner(System.in);
		String sqlDB = "CREATE TABLE Hotel" + "(id INTEGER ," + " hotel_name VARCHAR(8) not NULL,"
				+ "hotel_location varchar(20)," + "created_date Date not NULL," + "updated_date Date,"
				+ "is_Active  BIT not NULL," + "PRIMARY KEY (id))";

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

	public static void insertIntoTable() throws Throwable {

		Scanner sc = new Scanner(System.in);
		System.out.println(" how many users you have to print");
		int insert = sc.nextInt();
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
			for (int i = 1; i <= 100; i++) {

				String insert1 = "Insert into Hotel values(" + i + NumberToAdd + ",'" + hotel_name + "','"
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
			ResultSet result = st.executeQuery(sql);
		} catch (Exception ex) {
			System.err.println(ex);

		}

	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean hasExit = true;
		do {
			System.out.println("1:insertIntoTable");
			System.out.println("2:getById");
			System.out.println("3: updateById");
			System.out.println("4:deleteById");
			System.out.println("5:makeIsActiveFalseById");
			
			int select = sc.nextInt();

			switch (select) {
			case 1:
//		 HotelTable();
//		 
				insertIntoTable();
//				
				break;

			case 2:
				getById();
				break;
			case 3:
				 updateById();
				break;

			case 4:
				 //updateById(); 
				break;

			case 5:
				Employee_Type.Employee_Type();
				break;
			
			}
		} while (hasExit);
	}

}
