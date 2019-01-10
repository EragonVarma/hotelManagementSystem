package idb.hms.controller.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import idb.hms.entity.Room;
import idb.hms.services.GuestService;
import idb.hms.services.GuestServiceImpl;

public class StringToRoomConverter implements  Converter<String,Room>{
	
	@Autowired
	GuestService guestService;
	
	@Override
	public Room convert(String id) {
		 Room room = guestService.getRoomById(Integer.parseInt(id));
		 return room;
	}

}





