package HotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {
public static void guest() throws SQLException {

	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	String username = "root";
	String password = "root";
	 Scanner sc = new Scanner(System.in);
	 Connection conn = null;
	 
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			conn = DriverManager.getConnection(url, username, password);
			// Creating a statement
			Statement st = conn.createStatement();
			Scanner scanner = new Scanner(System.in);
String sql ="select * from guests where guest_name like '%E'";
ResultSet rs = st.executeQuery(sql);
while (rs.next() ) {
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

}
} catch (Exception ex) {
System.err.println(ex);
}
}

public static void Roomswhereguestsarepaying() {
	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	String username = "root";
	String password = "root";
	 Scanner sc = new Scanner(System.in);
	 Connection conn = null;
	 
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			conn = DriverManager.getConnection(url, username, password);
			// Creating a statement
			Statement st = conn.createStatement();
			Scanner scanner = new Scanner(System.in);
			
			String sql ="SELECT  * FROM room INNER JOIN guests ON room.id=guests.room_id WHERE guests.guest_accompanying_members >50";
			
		
		} catch (Exception ex) {
		System.err.println(ex);
		}
		}

public static void CountGuests() {
//	SELECT  *
//	FROM guests
//	 JOIN room ON guests.room_id=room.id JOIN room_type ON room_type.room_type='DELUXE'

}
public static void GuestshaveAName() {

//	select * from guests inner join room on guests .room_id = room.id inner join employees on room.id = employees.room_id inner join Employee_type 
//			on employees.employee_type_id = Employee_type.id where Employee_type. employee_type_name like '%A%';
}

ELECT * FROM room join room_type  on room.room_type_id=room_type.id where room_type.room_type_name='Deluxe'and room.is_Active='true';


