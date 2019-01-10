package idb.hms.DAO;

import java.util.List;

import idb.hms.entity.Guest;

public interface GuestDAO {
	
	public List<Guest> getActualGuests();
	
	public List<Guest> getCheckedoutGuests();
	
	public void saveUpdateGuest(Guest theGuest);
	
	public Guest getGuestById(int id);

	public List<Guest> getCommingCheckouts();
	
}








