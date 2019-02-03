package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {

	static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	protected Integer roomNumber;
	protected Date checkIn;
	protected Date checkOut;

	public Reservation() {
		super();
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions {
		
		if (!checkOut.after(checkIn))
			throw new DomainExceptions("Check-out date must be after check-in date");
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getcheckIn() {
		return checkIn;
	}

	public Date getcheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions {
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now))
			throw new DomainExceptions("Reservation dates for updates must be future dates");

		if (!checkOut.after(checkIn))
			throw new DomainExceptions("Check-out date must be after check-in date");

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Room " + roomNumber + ", check-in: ");
		sb.append(sdf.format(checkIn) + ", check-out: ");
		sb.append(sdf.format(checkOut) + ", " + this.duration() + " nights");
		return sb.toString();
	}

}
