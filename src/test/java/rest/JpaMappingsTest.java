package rest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private StateRepository stateRepo;

	@Resource
	private CityRepository cityRepo;

	@Test
	public void shouldSaveAndLoadState() {

		State stateUnderTest = new State("", "test name", "", "");
		stateUnderTest = stateRepo.save(stateUnderTest);

		assertThat(stateUnderTest.getName(), is("test name"));
	}
	
	@Test
	public void shouldSaveAndLoadCity() {
		
		State stateUnderTest = new State("", "test name", "", "");
		stateUnderTest = stateRepo.save(stateUnderTest);
		
		City cityUnderTest = new City("test name", stateUnderTest, 0);
		cityUnderTest = cityRepo.save(cityUnderTest);

		

		assertThat(cityUnderTest.getName(), is("test name"));
	}
	
	@Test
	public void shouldSaveAndLoadCitiesToState() {
		
		State stateUnderTest = new State("", "test name", "", "");
		stateRepo.save(stateUnderTest);
		long stateId = stateUnderTest.getId();
		
		City cityUnderTest1 = new City("test name", stateUnderTest, 0);
		cityRepo.save(cityUnderTest1);
		
		City cityUnderTest2 = new City("test name", stateUnderTest,0);
		cityRepo.save(cityUnderTest2);
		
		entityManager.flush();
		entityManager.clear();
		
		stateUnderTest= stateRepo.findOne(stateId);
		
		
		assertThat(stateUnderTest.getCities(), containsInAnyOrder(cityUnderTest1, cityUnderTest2));
		
	}

	
}