package rest;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityRestController {

	@Resource
	private CityRepository cityRepo;

	@RequestMapping("")
	public Iterable<City> findAllCitiess(@RequestParam(defaultValue = "") String search) {
		if (search.isEmpty()) {

			return cityRepo.findAll();
		}
		return cityRepo.findAllByNameIgnoreCaseLike(search);
	}

	@RequestMapping("/{id}")
	public City findOneCity(@PathVariable long id) {

		return cityRepo.findOne(id);
	}

}
