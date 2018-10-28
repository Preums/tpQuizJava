package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.UserDb;

/**
 * Servlet implementation class RegistryPage
 */
@WebServlet("/RegistryPage")
public class RegistryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistryPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String permission = (String) session.getAttribute("userPermission");
		request.setAttribute("permission", permission);
		float result = Float.parseFloat(request.getParameter("result"));
		float total = Float.parseFloat(request.getParameter("total"));
		float purcentResult = (total * 100) / result;
		request.setAttribute("purcentResult", purcentResult);
		request.getRequestDispatcher("/WEB-INF/jsp/registryPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String function = request.getParameter("function");
		Float admission_score = Float.parseFloat(request.getParameter("admission_score"));
		UserDb user = new UserDb();
		user.SetStudent(firstname, lastname, email, password, admission_score);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

}
