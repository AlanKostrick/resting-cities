package rest;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StateController {

	@Resource
	StateRepository stateRepo;

	@RequestMapping("/show-states")
	public String showAllStates(Model model) {
		model.addAttribute("states", stateRepo.findAll());
		return "views/states";
	}

	@RequestMapping(path = "/show-states/{abbreviation}/{stateName}", method = RequestMethod.POST)
	public String addState(@PathVariable String abbreviation, @PathVariable String stateName, Model model) {
		stateRepo.save(new State(abbreviation, stateName));
		model.addAttribute("states", stateRepo.findAll());
		return "partials/states-list";
	}

}
