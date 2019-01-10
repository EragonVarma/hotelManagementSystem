package idb.hms.services;

import java.util.List;

import idb.hms.entity.Guest;
import idb.hms.entity.Room;

public interface HotelStatusService {
	
	public List<Room> getAllRooms();
	public List<Guest> getActualGuests();
	
}






