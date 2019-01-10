package idb.hms.services;

import java.util.List;

import idb.hms.entity.Room;

public interface RoomService {
	
	public Room getRoomById(int id) ;
	
	public List<Room> getVacantRooms ();
	
	public List<Room> getOccupiedRooms ();
	
	void saveUpdateRoom(Room theRoom);
	
}








