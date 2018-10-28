package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.QuizDb;
import quiz.Quiz;

/**
 * Servlet implementation class ResultPage
 */
@WebServlet("/ResultPage")
public class ResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		int result=0;
		String quizId = request.getParameter("quiz");
		String index = request.getParameter("index");
		for (int i=1;i<=Integer.parseInt(index);i++) {
			if (request.getParameter("answer"+i) != null) {
				result += Integer.parseInt(request.getParameter("answer"+i));
			}
		}
		request.setAttribute("quizId", quizId);
		request.setAttribute("result",result);
		request.setAttribute("total", index);
		request.getRequestDispatcher("/WEB-INF/jsp/resultPage.jsp").forward(request, response);
	}

}
