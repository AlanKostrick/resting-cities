package rest;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateRestController {

	@Resource
	private StateRepository stateRepo;

	@Resource
	private CityRepository cityRepo;

	@RequestMapping("")
	public Iterable<State> findAllStates() {
		return stateRepo.findAll();
	}

	@RequestMapping("/{abbreviation}")
	public State getAState(@PathVariable String abbreviation) {

		return stateRepo.findOneByAbbreviationIgnoreCaseLike(abbreviation);
	}

	@RequestMapping("/{abbreviation}/cities")
	public Collection<City> findAllCities(@PathVariable(value = "abbreviation") String abbreviation) {
		State state = stateRepo.findOneByAbbreviationIgnoreCaseLike(abbreviation);
		return state.getCities();
	}

	@RequestMapping("/{abbreviation}/{stateName}/add")
	public Iterable<State> addState(@PathVariable(value = "abbreviation") String abbreviation,
			@PathVariable(value = "stateName") String stateName, @RequestBody String body) throws JSONException {

		if (stateRepo.findOneByAbbreviationIgnoreCaseLike(abbreviation) == null) {
			stateRepo.save(new State(abbreviation, stateName));
		}

		return stateRepo.findAll();
	}

}