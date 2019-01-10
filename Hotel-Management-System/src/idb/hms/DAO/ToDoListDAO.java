package idb.hms.DAO;

import java.util.List;

import idb.hms.entity.ToDo;

public interface ToDoListDAO {

	public void addToDo(ToDo toDo);

	public List<ToDo> getToDo();

	public void deleteToDo(ToDo toDo);

	public void deleteToDo(int id);


}








