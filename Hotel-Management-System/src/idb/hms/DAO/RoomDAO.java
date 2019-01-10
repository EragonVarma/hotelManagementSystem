package idb.hms.DAO;

import java.util.List;

import idb.hms.entity.Guest;
import idb.hms.entity.Room;

public interface RoomDAO {

	public List<Room> getAllRooms();
	
	public List<Room> getVacantRooms();
	
	public Room getRoomById(int id);
	
	public void saveUpdateRoom(Room room);
	
	public List<Room> getOccupiedRooms();

}







