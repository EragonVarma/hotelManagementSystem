package idb.hms.services;

import java.util.List;

import idb.hms.entity.ToDo;

public interface GlobalAdviceService {
	
	public void addToDo(ToDo toDo);
	
	public List<ToDo> getToDo();
	
}









