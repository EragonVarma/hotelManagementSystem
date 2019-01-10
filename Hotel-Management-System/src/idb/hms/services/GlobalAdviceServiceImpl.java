package idb.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idb.hms.DAO.ToDoListDAO;
import idb.hms.entity.ToDo;

@Service
public class GlobalAdviceServiceImpl implements GlobalAdviceService{

	@Autowired
	private ToDoListDAO toDoDAO;
	
	@Override
	@Transactional
	public void addToDo(ToDo toDo) {
		toDoDAO.addToDo(toDo);
		
	}
	
	@Override
	@Transactional
	public List<ToDo> getToDo() {
		// TODO Auto-generated method stub
		return toDoDAO.getToDo();
	}

}






