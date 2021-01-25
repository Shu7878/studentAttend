package studentAttendServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentService.AttendSearch;
import studentService.ChangeAttend;



/**
 * Servlet implementation class StudentAttend
 */
@WebServlet("/StudentAttend")
public class StudentAttendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "出欠情報を登録してください");

		String jsp;
		try{
			AttendSearch search = new AttendSearch();
			search.execute(request);
			jsp = "/disp.jsp";
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "JDBCのエラーです");
			jsp = "/disp.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "エラーが発生しました");
			jsp = "/disp.jsp";
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String jsp;
		String btn = request.getParameter("btn");

		try{
			if(btn != null && btn.equals("attendBtn")){
				ChangeAttend change = new ChangeAttend();		//SQLExceptionの発生
				change.execute(request);
				jsp = "/disp.jsp";
			}
			jsp="/disp.jsp";
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "JDBCのエラーです");
			jsp = "/disp.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "エラーが発生しました");
			jsp = "/disp.jsp";
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}

}
