package HotelDBMS;

import java.util.Scanner;

public class main {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean hasExit = true;
		do {
			System.out.println("HELLO IN HOTELS");
			System.out.println("*****************");
			System.out.println("1:Insert 10,000 hotels");
			System.out.println("2:Insert 1 hotel");
			System.out.println("3:Print 10 hotels");
			System.out.println("4:Make first 10 hotels 'is_Active' = false");
			System.out.println("5Print hotel information by user input");
			System.out.println("6:^^EXIT^^");
			System.out.println("*******************");
			
			int select = sc.nextInt();

			switch (select) {
			case 0:
//				Hotel.HotelTable();
				 //Room_Type.room_type();
//				Rooms.room();
				 Guests.Guests();
//				Employee_Type.Employee_Type();
//				Employees.Employees();
				break;
			case 1:
//		 HotelTable();
				System.out.println(" how many users you have to print");
				int number = sc.nextInt();
//				Hotel.insertIntoTable(number);
//				Room_Type.insertIntoTable(number);
//				Rooms.insertIntoTable(number);
//				Guests.insertIntoTable(number);
//				Employees.insertIntoTable(number);
//				Employee_Type.insertIntoTable(number);
				break;

			case 2:
//				Hotel.insertIntoTable(1);
//				Room_Type.insertIntoTable(3);
//				Rooms.insertIntoTable(1);
				Guests.insertIntoTable(1);
//				Employees.insertIntoTable(20);
//				Employee_Type.insertIntoTable(1000);
				break;
			case 3:
				Hotel. printHotel(10);
//				Room_Type.printRoom_Type(10);
//				Rooms.printRoom(10);
//				Guests.printGuests(10);
//				Employees.printHotel(10);
//				Employee_Type.printHotel(10);
				break;

			case 4:
				Hotel.makeIsActiveFalseById(); 
//				Room_Type.makeIsActiveFalseById();
//				Rooms.makeIsActiveFalseById();
//				Guests.makeIsActiveFalseById();
//				Employees.makeIsActiveFalseById();
//				Employee_Type.makeIsActiveFalseById();
				break;

			case 5:
				System.out.println(" how many users you have to input");
				int top = sc.nextInt();
				Hotel.printHotel(top);
//				Room_Type.printRoom_Type(top);
//				Rooms.printRoom(top);
//				Guests.printGuests(top);
//				Employees.printHotel(top);
//				Employee_Type.printHotel(top);
				break;
			
			case 6:
				Hotel.exit();
				break;
				
				
			case 7:
//				Hotel.deleteById();
				//Guests.readFromTable();
				System.out.println(" how many users you have to input");
				int top1 = sc.nextInt();
				Room_Type.readFromTable(top1);
			break;
			}
		} while (hasExit);
	}

}


