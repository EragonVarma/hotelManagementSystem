package idb.hms.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idb.hms.DAO.GuestDAO;
import idb.hms.DAO.RoomDAO;
import idb.hms.entity.Guest;
import idb.hms.entity.Room;

@Service
public class HotelStatusServiceImpl implements HotelStatusService{
	
	@Autowired
	private RoomDAO roomDAO; 
	
	@Autowired
	private GuestDAO guestDAO;
	
	@Override
	@Transactional
	public List<Room> getAllRooms() {
		return roomDAO.getAllRooms();
	}
	
	@Override
	@Transactional
	public List<Guest> getActualGuests() {
		return guestDAO.getActualGuests();
	}

}



