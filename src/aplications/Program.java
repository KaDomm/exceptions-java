package aplications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation room = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + room);
			System.out.println();

			System.out.print("Enter data to update the reservation: \nCheck-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			room.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + room);
		} catch (ParseException e) {
			System.out.println("Invalid date format!");
		} catch (DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		sc.close();
	}

}
