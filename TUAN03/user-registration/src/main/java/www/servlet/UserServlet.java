package www.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.dao.UserDAO;
import www.dao.UserDAOImpl;
import www.entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		userDAO = new UserDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/pages/user-registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String genderStr = request.getParameter("gender");
		boolean gender = genderStr.equals("true") ? true : false;
		String pass = request.getParameter("pass");

		String date = request.getParameter("date");
		String month = request.getParameter("month");
		String year = request.getParameter("year");

		String dateOfBirth = date + ", " + month + ", " + year;

		User user = new User(fname, lname, email, pass, dateOfBirth, gender);
		userDAO.insert(user);

		request.setAttribute("user", user);

		getServletContext().getRequestDispatcher("/pages/success.jsp").forward(request, response);

	}

}
