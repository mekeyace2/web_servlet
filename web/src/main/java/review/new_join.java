package review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.rmd;

public class new_join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//자동등록방지 : 4자리 번호
		ArrayList<String> seno = new rmd(4).make_num();
		
		//jsp로 자동난수 4자리 배열 전달
		request.setAttribute("seno", seno);
				
		RequestDispatcher rd = request.getRequestDispatcher("./new_join.jsp");
		rd.forward(request, response);
		
	}
}







