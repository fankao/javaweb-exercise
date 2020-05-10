package www.bt.entities;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Show {
	private LocalDateTime timing;
	
	@ManyToOne
	@JoinColumn(name="movieID")
	private Movie movie;
	

	public Show(LocalDateTime timing, Movie movie) {
		super();
		this.timing = timing;
		this.movie = movie;
	}
	

	public Show() {
		super();
	}


	public LocalDateTime getTiming() {
		return timing;
	}

	public void setTiming(LocalDateTime timing) {
		this.timing = timing;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((timing == null) ? 0 : timing.hashCode());
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
		Show other = (Show) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (timing == null) {
			if (other.timing != null)
				return false;
		} else if (!timing.equals(other.timing))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Show [timing=" + timing + "]";
	}
	
	
	
	
	
}
