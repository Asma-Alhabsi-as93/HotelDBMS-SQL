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
				 //Hotel.HotelTable();
				// Room_Type.room_type();
				//Rooms.room();
				 //Guests.Guests();
				//Employee_Type.Employee_Type();
				//Employees.Employees();
				break;
			case 1:
//		 HotelTable();
				System.out.println(" how many users you have to print");
				int number1 = sc.nextInt();
				Hotel.insertIntoTable(number1);
//				
				break;

			case 2:
				Hotel.insertIntoTable(1);
				break;
			case 3:
				Hotel. printHotel(10);
				break;

			case 4:
				Hotel.makeIsActiveFalseById(); 
				break;

			case 5:
				System.out.println(" how many users you have to input");
				int top = sc.nextInt();
				Hotel.printHotel(top);
				break;
			
			case 6:
				Hotel.exit();
				break;
				
				
//			case 7:
//				Hotel.deleteById();
//				break;
			}
		} while (hasExit);
	}

}


