package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nidx = Integer.parseInt(request.getParameter("nidx"));
		//조회수 +1 증가 및 데이터를 출력
		m_noticeview mv = new m_noticeview();
		mv.viewcount(nidx);
		
		ArrayList<String> notice_v = mv.db_data;
		
		//게시물 1개의 데이터 내용을 JSP로 전달
		request.setAttribute("notice_v", notice_v);
		
		RequestDispatcher rd = request.getRequestDispatcher("./notice_view.jsp");
		rd.forward(request, response);
	}
}


