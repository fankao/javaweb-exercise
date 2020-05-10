package www.bt.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	private long id;

	private int year;

	private String title;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	private List<String> directors;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	private List<String> actors;

	private long running_time_secs;

	public Movie(Long id, int year, String title, List<String> directors, List<String> actors, long running_time_secs) {
		super();
		this.id = id;
		this.year = year;
		this.title = title;
		this.directors = directors;
		this.actors = actors;
		this.running_time_secs = running_time_secs;
	}

	public Movie() {
		this.setId(0L);
	}

	public Movie(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public long getRunning_time_secs() {
		return running_time_secs;
	}

	public void setRunning_time_secs(long running_time_secs) {
		this.running_time_secs = running_time_secs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", year=" + year + ", title=" + title + ", directors=" + directors + ", actors="
				+ actors + ", running_time_secs=" + running_time_secs + "]";
	}

	@Transient
	public String showListString(List<String> lstString) {
		StringBuilder line = new StringBuilder();
		if (lstString == null) {
			lstString = new ArrayList<String>();
		}
		lstString.forEach(x -> {
			line.append(x+"\n");
		});
		return line.toString();
	}

}
