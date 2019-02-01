package aplications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (checkOut.after(checkIn)) {

			Reservation room = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + room);
			System.out.println();

			System.out.print("Enter data to update the reservation: \nCheck-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (!checkIn.before(now) && !checkOut.before(now)) {
				if (checkOut.after(checkIn)) {

					room.updateDates(checkIn, checkOut);
					System.out.println(room);
				} else {
					System.out.println("Error in reservation: Check-out date must be after check-in date");
				}
			} else
				System.out.println("Error in reservation: Reservation dates for updates must be future dates");
		} else
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		sc.close();
	}

}
