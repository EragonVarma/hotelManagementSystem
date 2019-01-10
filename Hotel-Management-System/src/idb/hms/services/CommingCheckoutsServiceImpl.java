package idb.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idb.hms.DAO.GuestDAO;
import idb.hms.entity.Guest;

@Service
public class CommingCheckoutsServiceImpl implements CommingCheckoutsService {
	
	@Autowired
	private GuestDAO guestDAO;
	
	@Override
	@Transactional
	public List<Guest> getCommingCheckouts() {
		
		return guestDAO.getCommingCheckouts();
	}

}







