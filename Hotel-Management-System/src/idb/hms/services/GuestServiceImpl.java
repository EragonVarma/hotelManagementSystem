package idb.hms.services;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import idb.hms.DAO.GuestDAO;
import idb.hms.DAO.RoomDAO;
import idb.hms.entity.Guest;
import idb.hms.entity.Room;
import idb.hms.services.helper.EmailMessage;
import idb.hms.services.helper.PDFPrinter;

import java.time.temporal.ChronoUnit;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDAO guestDAO;
	
	@Autowired
	private RoomDAO roomDAO;
	
	@Override
	@Transactional
	public List<Guest> getActualGuests() {
		return guestDAO.getActualGuests();
	}
	
	@Override
	@Transactional
	public Guest getGuestById(int id) {
		return guestDAO.getGuestById(id);
	}

	@Override
	@Transactional
	public void saveUpdateGuest(Guest theGuest) {
		guestDAO.saveUpdateGuest(theGuest);
		
	}

	@Override
	@Transactional
	public List<Room> getVacantRooms() {
		return roomDAO.getVacantRooms();
	}

	@Override
	@Transactional
	public Room getRoomById(int id) {
		return roomDAO.getRoomById(id);
	}

	@Override
	@Transactional
	public void saveUpdateRoom(Room theRoom) {
		roomDAO.saveUpdateRoom(theRoom);
		
	}

	@Override
	@Transactional
	public List<Room> getOccupiedRooms() {
		return roomDAO.getOccupiedRooms();
	}
	
	@Override
	@Transactional
	public List<Guest> getArchivedGuests() {	
		return guestDAO.getCheckedoutGuests();
	}

	@Override
	public int getNightsNumber(Guest guest) {
		LocalDate checkIn = guest.getCheckinDate();
		LocalDate checkOut;
		
		if(guest.getIsCheckedout()) {
			checkOut = guest.getCheckoutDate();
		}else {
			checkOut = LocalDate.now();
		}
		
		int nightsNumber = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
		return nightsNumber;
	}

	@Override
	public void saveBillPDF(Guest guest) {
		
		Room room;
		
		if(guest.getIsCheckedout()) {
		room = guest.getLastCheckedoutRoom();
		}else {
		room = guest.getRoom();
		}
		
		
		String dest = "C:\\bills";
		File dir = new File(dest);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String bill = constructBill(guest, room);
		try {
			PDFPrinter.createPDF(bill, dest + "\\" + guest.getFirstName() + "_" + guest.getLastName() + "_" + guest.getId() + ".pdf");		
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void sendBillByMail(Guest guest, String email) throws MessagingException {
		Room room;
		if(guest.getIsCheckedout()) {
		room = guest.getLastCheckedoutRoom();
		}else {
		room = guest.getRoom();
		}
		String bill = constructBill(guest, room);
		
		LinkedList <String> to = new LinkedList<String>();
		to.add(email);
		EmailMessage wiadomosc = new EmailMessage.EmailBuilder("marek.czwartek@wp.pl", to)
			.addSubject("Ticket purchase confirmation " + guest.getFirstName() + " " + guest.getLastName())
			.addContent(bill)
			.build();

		
			wiadomosc.send("adrianroguski1990", "smtp.wp.pl", 465);
		    

	}

	private String constructBill(Guest guest, Room room) {
		int nightsNumber = getNightsNumber(guest);
		String bill = ""
				+ "First name: " + guest.getFirstName() +"\n"
				+ "Last name: " + guest.getLastName() +"\n"
				+ "Room number: " + room.getNumber() +"\n"
				+ "Room standard: " + room.getStandard() +"\n"
				+ "Checkin date: " + guest.getCheckinDate() +"\n"
				+ "Checkout date: " + guest.getCheckoutDate() +"\n"
				+ "Rate: " + room.getRate() + "$" +"\n"
				+ "Number of nights: " + nightsNumber +"\n" 
				+ "Tax (VAT 24%): " + nightsNumber*room.getRate()*room.TAX + "$" +"\n"
				+ "Total: " + nightsNumber*room.getRate()*(1 + room.TAX) + "$" +"\n"
				+ "Thank you for staying with us ! :)";
		return bill;
	}

}








