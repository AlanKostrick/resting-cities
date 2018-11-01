package rest;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	private CityRepository cityRepo;

	@Resource
	private StateRepository stateRepo;

	@Override
	public void run(String... args) throws Exception {

		State ohio = new State("OH", "Ohio", "Birthplace of Aviation", "");
		stateRepo.save(ohio);

		City columbus = new City("Columbus", ohio, 800000);
		cityRepo.save(columbus);

		City cleveland = new City("Cleveland", ohio, 300000);
		cityRepo.save(cleveland);

		State hawaii = new State("HI", "Hawaii", "The Islands of Aloha", "Humuhumunukunukuapua");
		stateRepo.save(hawaii);
		
		City honolulu = new City("Honolulu", hawaii, 337256);
		cityRepo.save(honolulu);

		City waipahu = new City("Waipahu", hawaii, 38216);
		cityRepo.save(waipahu);

		City wailuku = new City("Wailuku", hawaii, 15313);
		cityRepo.save(wailuku);

	}

}
