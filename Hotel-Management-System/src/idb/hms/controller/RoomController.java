package idb.hms.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import idb.hms.entity.Guest;
import idb.hms.entity.Room;
import idb.hms.services.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("/list")
	public String roomList(Model theModel) {
		
		List <Room> vacantRooms = roomService.getVacantRooms();
		theModel.addAttribute("roomList", vacantRooms);
		return "roomList";
		
	}
	
	@GetMapping("/occupiedRoomlist")
	public String occupiedRoomList(Model theModel) {
		
		List <Room> occupiedRooms = roomService.getOccupiedRooms();
		theModel.addAttribute("roomList", occupiedRooms);
		return "occupiedRoomList";
		
	}
	
	@GetMapping("/checkout")
	public String checkoutRoom (@RequestParam("roomId") Integer theRoomId) {
		System.out.println("I am mapped!!!");
		Room theRoom = roomService.getRoomById(theRoomId);
		List<Guest> occupants = theRoom.getOccupants();
		LocalDate localDate = LocalDate.now();
		localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		for(Guest guest : occupants) {
			System.out.println(guest.getFirstName());
			guest.setCheckedout(true);
			guest.setCheckoutDate(localDate);
			theRoom.setOccupants(null);
			theRoom.setOccupied(false);

		}
		roomService.saveUpdateRoom(theRoom);
		return "redirect:/room/occupiedRoomlist";
	}
	
}






