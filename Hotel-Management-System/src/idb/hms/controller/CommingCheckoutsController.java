package idb.hms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import idb.hms.entity.Guest;
import idb.hms.services.CommingCheckoutsService;

@Controller
@RequestMapping("/commingCheckouts")
public class CommingCheckoutsController {

	@Autowired
	private CommingCheckoutsService commingCheckOutsService;

	@GetMapping("/list")
	public String commingCheckoutsList(Model theModel) {

		List <Guest> commingCheckouts = commingCheckOutsService.getCommingCheckouts();
		
		theModel.addAttribute("guestList", commingCheckouts);
		return "guestList";

	}

}




