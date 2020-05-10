package www.bt.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cinemas")
public class Cinema {
	@Id
	private long id;
	
	private String name;
	private String location;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Show> listShows;

	public Cinema(long id, String name, String location, List<Show> listShows) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.listShows = listShows;
	}

	public Cinema(long id) {
		super();
		this.id = id;
	}

	public Cinema() {
		this.setId(0);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Show> getListShows() {
		return listShows;
	}

	public void setListShows(List<Show> listShows) {
		this.listShows = listShows;
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
		Cinema other = (Cinema) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
	
}
