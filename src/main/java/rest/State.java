package rest;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {

	@Id
	@GeneratedValue
	private Long id;
	private String abbreviation;
	private String name;
	private String motto;
	private String fish;

	@JsonIgnore
	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getName() {
		return name;
	}

	public String getMotto() {
		return motto;
	}

	public String getFish() {
		return fish;
	}

	public Long getId() {
		return id;
	}

	public Collection<String> getCitiesUrl() {
		Collection<String> urls = new ArrayList<>();
		for (City city : cities) {
			urls.add(format("/states/%s/cities/%s", this.getAbbreviation(), city.getName()));
		}
		return urls;
	}

	public Collection<City> getCities() {
		return cities;
	}

	@SuppressWarnings("unused")
	private State() {

	}

	public State(String abbreviation, String name) {
		this.abbreviation = abbreviation;
		this.name = name;
	}

	public State(String abbreviation, String name, String motto, String fish) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.motto = motto;
		this.fish = fish;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
