package rest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StateRestTest {

	@Resource
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

		HttpStatus status = response.getStatusCode();

		assertThat(status, is(HttpStatus.OK));

	}

	@Test
	public void shouldBeOkForStates() {
		ResponseEntity<String> response = restTemplate.getForEntity("/states", String.class);

		HttpStatus status = response.getStatusCode();

		assertThat(status, is(HttpStatus.OK));

	}

	@Test
	public void shouldBeOkForParticularStateByAbbreviation() {
		ResponseEntity<String> response = restTemplate.getForEntity("/states/oh", String.class);

		HttpStatus status = response.getStatusCode();

		assertThat(status, is(HttpStatus.OK));

	}

	@Test
	public void shouldBeOkForAParticularStateByAbbreviationCities() {
		ResponseEntity<String> response = restTemplate.getForEntity("/states/oh/cities", String.class);

		HttpStatus status = response.getStatusCode();

		assertThat(status, is(HttpStatus.OK));

	}

}
