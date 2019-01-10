package idb.hms.services;

import java.util.List;

import javax.mail.MessagingException;

import idb.hms.entity.Guest;
import idb.hms.entity.Room;

public interface GuestService {

	public List<Guest> getActualGuests ();
	public List<Guest> getArchivedGuests ();
	public List<Room> getVacantRooms();
	public List<Room> getOccupiedRooms();
	public void saveUpdateGuest(Guest theGuest);
	public void saveUpdateRoom(Room theRoom);
	public Room getRoomById(int id);
	public Guest getGuestById(int id);
	public int getNightsNumber(Guest guest);
	public void saveBillPDF(Guest guest);
	public void sendBillByMail(Guest guest, String email) throws MessagingException;
	
}









