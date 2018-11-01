package rest;

import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State,Long> {

	State findOneByAbbreviationIgnoreCaseLike(String abbreviation);

}
