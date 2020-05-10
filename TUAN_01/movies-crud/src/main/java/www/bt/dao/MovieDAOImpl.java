package www.bt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import www.bt.entities.Movie;

public class MovieDAOImpl implements MovieDAO {
	private EntityManager em;

	public MovieDAOImpl() {
		em = MovieEntityManager.getInstance().getEntityManager();
	}

	/**
	 * Lấy movie theo id
	 */
	public Movie getMovie(long id) {
		// TODO Auto-generated method stub
		return em.find(Movie.class, id);
	}

	/**
	 * 
	 * Lấy danh sách tất cả movie
	 */
	public List<Movie> getAllMovies() {
		final List<Movie> movies = new ArrayList<Movie>();
		List<?> result = em.createNativeQuery("db.movies.find({})", Movie.class).getResultList();
		result.forEach(x -> {
			Movie movie = (Movie) x;
			movies.add(movie);
		});
		return movies;
	}

	/**
	 * thêm mới movie
	 */
	public Movie addNewMovie(Movie movie) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(movie);
			trans.commit();
			return movie;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}

	public Movie updateMovie(Movie movie) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(movie);
			trans.commit();
			return movie;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteMovie(long id) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.createNativeQuery("db.movies.deleteOne({'_id':'" + id + "'})").executeUpdate();
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
