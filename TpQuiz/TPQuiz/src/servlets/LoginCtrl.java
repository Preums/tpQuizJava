package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Login;
import login.User;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = Login.checkIdent(email,password);
		HttpSession session = request.getSession();
		String loggedMessage = "Bonjour "+user.getFirstname();
		String userPermission = user.getFunction();
		session.setAttribute("loggedUser", loggedMessage);
		session.setAttribute("userPermission", userPermission);
		String function = user.getFunction();
		switch (function) {
			case "guest":
				response.sendRedirect("index");
			break;
			case "student":
				response.sendRedirect("student");
			break;
			case "teacher":
				response.sendRedirect("teacher");
			break;
			case "admin":
				response.sendRedirect("admin");
			break;
			default:
				response.sendRedirect("index");
		}
	}

}
