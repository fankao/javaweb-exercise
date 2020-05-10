package www.bt.test;

import java.util.Arrays;

import www.bt.dao.MovieDAO;
import www.bt.dao.MovieDAOImpl;
import www.bt.entities.Movie;

public class Testing {
	public static void main(String[] args) {
		MovieDAO movieDAO = new MovieDAOImpl();

		Movie m1 = new Movie(1L, 2019, "John Wicks", Arrays.asList("John"), Arrays.asList("Keanu"), 1600);
		Movie m2 = new Movie(2L, 2019, "One Piece", Arrays.asList("vkhgkjs"), Arrays.asList("Kefsfsfdanu"), 1600);
		
		movieDAO.addNewMovie(m1);
		movieDAO.addNewMovie(m2);
		
		System.out.println(movieDAO.getAllMovies());
		
		
		
	}
}
