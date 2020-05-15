package www.bt07.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.bt07.dao.StudentDAO;
import www.bt07.dao.StudentDAOImpl;
import www.bt07.entity.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(urlPatterns = { "/save", "/list", "/new", "/edit", "/delete" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		studentDAO = new StudentDAOImpl();
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
		case "/list":
			showListStudent(request, response);
			break;

		case "/edit":
			showForm(request, response);
			break;
		case "/delete":
			deleteStudent(request, response);
			break;

		default:
			showListStudent(request, response);
			break;
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String msv = request.getParameter("maSV");
		studentDAO.deleteById(msv);
		response.sendRedirect("list");
		
	}

	private void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msv = request.getParameter("maSV");
		if (msv != null) {
			request.setAttribute("student", studentDAO.findById(msv));
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/form-student.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showListStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> students = studentDAO.findAll();
		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/list-student.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String maSV = request.getParameter("maSV");
		String hoVaTen = request.getParameter("hoVaTen");
		boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
		String soDT = request.getParameter("sdt");
		String diaChi = request.getParameter("diaChi");

		Student student = new Student(maSV, hoVaTen, gioiTinh, diaChi, soDT);
		studentDAO.save(student);
		response.sendRedirect("list");
	}

}
