package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.QuizDb;
import database.UserDb;
import login.Student;
import login.User;
import quiz.Quiz;

/**
 * Servlet implementation class userList
 */
@WebServlet("/ModifyUser")
public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("loggedUser");
		request.setAttribute("loggedUser", user);
		String permission = (String) session.getAttribute("userPermission");
		request.setAttribute("permission", permission);
		UserDb userDb = new UserDb();
		String userFunction = request.getParameter("user");
		String userId = request.getParameter("id");
		User selectedUser = new User();
		if (userFunction !=null & userFunction.equals("student")) {
			selectedUser = (Student) userDb.getStudent(Integer.parseInt(userId));
		} else {
			selectedUser = userDb.getEmployee(Integer.parseInt(userId));
		}
		request.setAttribute("selectedUser",selectedUser);
		request.setAttribute("function",selectedUser.getFunction());
		request.getRequestDispatcher("/WEB-INF/jsp/modifyUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("loggedUser");
		request.setAttribute("loggedUser", user);
		String permission = (String) session.getAttribute("userPermission");
		request.setAttribute("permission", permission);
		UserDb userDb = new UserDb();
		
		String id = (String) request.getParameter("id");
		String firstname = (String) request.getParameter("firstname");
		String lastname = (String) request.getParameter("lastname");
		String email = (String) request.getParameter("email");
		String function = (String) request.getParameter("function");
		String admission_score;
		String completed_courses;
		String corrected_courses;
		int graduate;
		if (function !=null & function.equals("student")) {
			admission_score = (String) request.getParameter("admission_score");
			completed_courses = (String) request.getParameter("completed_courses");
			corrected_courses = (String) request.getParameter("corrected_courses");
			graduate = Integer.parseInt(request.getParameter("graduate"));
			userDb.updateStudent(id,firstname,lastname,email,function,admission_score,completed_courses,corrected_courses,graduate);
		} else {
			userDb.updateUser(id,firstname,lastname,email,function);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/adminPage.jsp").forward(request, response);
	}

}
