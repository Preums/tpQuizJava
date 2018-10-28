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
import login.User;
import quiz.Quiz;

/**
 * Servlet implementation class userList
 */
@WebServlet("/userList")
public class UserListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListCtrl() {
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
		UserDb userList = new UserDb();
		String userFunction = request.getParameter("user");
		ArrayList<User> listing = new ArrayList<User>();
		if (userFunction !=null & userFunction.equals("student")) {
			listing = userList.getStudentList();
		} else {
			listing = userList.getEmployeesList();
		}
		request.setAttribute("listing",listing);
		request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
