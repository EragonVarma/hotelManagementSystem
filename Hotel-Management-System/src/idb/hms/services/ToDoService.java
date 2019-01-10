package idb.hms.services;

import idb.hms.entity.ToDo;

public interface ToDoService {

	public void deleteToDo(ToDo theToDo);

	public void deleteToDo(int id);

	public void addToDo(ToDo theToDo);
	
}





