package www.bt.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.bt.dao.MovieDAO;
import www.bt.dao.MovieDAOImpl;
import www.bt.entities.Movie;
@WebServlet(urlPatterns = {"/ActionManagementServlet", "/list", "/new", "/edit", "/delete"})
public class ActionManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MovieDAO movieDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionManagementServlet() {
		super();
		try {
			movieDAO = new MovieDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		long id = Long.parseLong(request.getParameter("id"));

		String title = request.getParameter("title");

		int year = Integer.parseInt(request.getParameter("year"));

		String direc = request.getParameter("directors").trim();

		List<String> directors = Arrays.asList(direc);

		String ac = request.getParameter("actors").trim();

		List<String> actors = Arrays.asList(ac);

		long duration = Long.parseLong(request.getParameter("duration"));

		Movie movie = null;

		if (movieDAO.getMovie(id) == null) {
			movie = movieDAO.addNewMovie(new Movie(id, year, title, directors, actors, duration));
		} else {
			movie = movieDAO.updateMovie(new Movie(id, year, title, directors, actors, duration));
		}

		if (movie != null) {
			listAll(request, response);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showForm(request, response);
			break;
		case "/edit":
			showForm(request, response);
			break;
		case "/delete":
			deleteMovie(request, response);
		default:
			listAll(request, response);
			break;
		}
	}

	/**
	 * Xoa movie
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		movieDAO.deleteMovie(id);
		listAll(request, response);
	}

	/**
	 * Hiên thị form cho chức năng thêm mới hoặc update
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */

	private void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Movie movie = null;
		// nếu tồn tại id của movie, thì mở form cập nhật
		if (request.getParameter("id") != null) {
			// lấy id movies
			long id = Long.parseLong(request.getParameter("id"));

			// tìm movie theo id
			movie = movieDAO.getMovie(id);
		}
		// đưa movie vào request
		request.setAttribute("movie", movie);

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/form-movie.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * Hiện danh sách movies
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Movie> movies = movieDAO.getAllMovies();
		request.setAttribute("movies", movies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/list-movies.jsp");
		dispatcher.forward(request, response);
	}

}
