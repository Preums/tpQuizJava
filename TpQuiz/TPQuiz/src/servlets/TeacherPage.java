package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.User;

/**
 * Servlet implementation class TeatcherPage
 */

public class TeacherPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherPage() {
        super();
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
		
		request.getRequestDispatcher("/WEB-INF/jsp/teacherPage.jsp").forward(request, response);
	}

}
