package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.QuizDb;
import login.User;

/**
 * Servlet implementation class StudentPage
 */

public class StudentPage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPage() {
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
		
		QuizDb quizList = new QuizDb();
		HashMap<Integer,String> quizAvailable = quizList.getQuizList(true);
		request.setAttribute("quizAvailable", quizAvailable);
		
		request.getRequestDispatcher("/WEB-INF/jsp/studentPage.jsp").forward(request, response);
	}
	

}
