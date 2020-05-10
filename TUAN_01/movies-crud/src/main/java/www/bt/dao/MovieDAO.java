package www.bt.dao;

import java.util.List;

import www.bt.entities.Movie;

public interface MovieDAO {
	Movie getMovie(long id);
	List<Movie> getAllMovies();
	Movie addNewMovie(Movie movie);
	Movie updateMovie(Movie movie);
	void deleteMovie(long id);
}
