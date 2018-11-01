package rest;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

	Iterable<City> findAllByNameIgnoreCaseLike(String name);

}
