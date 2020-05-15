package www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import www.dao.PersonDAO;
import www.dao.PersonDAOImpl;
import www.entity.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet(urlPatterns = { "/PersonServlet","/list", "/edit", "/delete" })
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDAO personDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonServlet() {
		super();
		personDAO = new PersonDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/edit":
			showFormEdit(request, response);
			break;
		case "/delete":
			deletePerson(request, response);
			break;
		default:
			showListPerson(request, response);
			break;
		}
	}

	/**
	 * Delete Person
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		ObjectId id = idStr == "" ? null : new ObjectId(idStr);
		personDAO.deleteById(id);
		request.setAttribute("message", "Person deleted successfully");
		response.sendRedirect("list");

	}

	/**
	 * Show form for edit
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showFormEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		ObjectId id = idStr == "" ? null : new ObjectId(idStr);
		Person person = personDAO.findById(id);
		request.setAttribute("person", person);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-person.jsp");
		dispatcher.forward(request, response);
		

	}

	/**
	 * Show list person
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showListPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Person> persons = personDAO.findAll();
		request.setAttribute("persons", persons);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-person.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		ObjectId id = idStr == "" ? null : new ObjectId(idStr);

		String name = request.getParameter("name");

		String country = request.getParameter("country");

		Person p = null;
		if (id == null) {
			p = new Person();
		} else {
			p = personDAO.findById(id);
		}
		p.setName(name);
		p.setCountry(country);
		personDAO.save(p);
		response.sendRedirect("list");

	}

}
