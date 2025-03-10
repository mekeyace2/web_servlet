package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idsearch extends HttpServlet {
	PrintWriter pw = null;
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter();
			String mname = request.getParameter("mname");
			String mtel = request.getParameter("mtel");
			String memail = request.getParameter("memail");
			String result = "";	//결과를 View(jsp)에 전달할 변수값
			if(mname.equals("홍길동") && mtel.equals("01010041919") && memail.equals("hong@naver.com")) {
				result = "hong2025";
			}else {
				result = "가입정보가 확인 되지 않습니다.";
			}
			request.setAttribute("result", result);	//결과값 jsp로 전달
			RequestDispatcher rd = request.getRequestDispatcher("./idsearch.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 값이 전달 되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			this.pw.close();
		}
	}

}
