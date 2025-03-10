package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list를 출력하기 위한 Database Table을 로드는 Model
		m_noticelist nl = new m_noticelist();
		//2차 클래스배열로 저장된 Table에 모든 데이터를 셋팅함
		ArrayList<ArrayList<String>> result = nl.db_data();
		
		//JSP로 2차 클래스 배열 값을 전달(View)
		request.setAttribute("result", result);
				
		RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
		rd.forward(request, response);	
	}
	
	
	

}
