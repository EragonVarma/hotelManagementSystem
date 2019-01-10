package idb.hms.controller.converters;

import org.springframework.core.convert.converter.Converter;

import idb.hms.entity.Room;

public class RoomToStringConverter  implements  Converter<Room,String>{

	@Override
	public String convert(Room room) {
		return String.valueOf(room.getStandard() + " " + room.getNumber());
	}

}







