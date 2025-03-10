package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class payok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //Controller (Front-end 전송된 값 처리 및 사칙연산 처리 후 View 전달)   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();	//javascript
		try {
			//Front-end 값을 받는 역활
			String m = request.getParameter("money");
			String s = request.getParameter("sales");
			String p = request.getParameter("point");
			
			//해당 데이터를 숫자로 변환 후 사칙연산
			int product_m = Integer.parseInt(m);
			int product_s = Integer.parseInt(s);
			int product_p = Integer.parseInt(p);
			int total = (product_m - (product_m * product_s) / 100) - product_p;
			
			//Controller => View(.jsp에서 사용할 수 있도록 함)
			request.setAttribute("product_m", product_m);
			request.setAttribute("product_s", product_s);
			request.setAttribute("product_p", product_p);
			request.setAttribute("total", total);
			
			//RequestDispatcher : View를 선언하여 웹페이지에 출력 되도록 설정
			RequestDispatcher rd = request.getRequestDispatcher("/payok.jsp");
			rd.forward(request, response);	//Controller에서 사용된 정보를 jsp 이관
			
		}
		catch (Exception e) {	//Front-end값이 숫자로 변환시 비정상적일 경우 해당 스크립 실행됨
			pw.write("<script>"
					+ "alert('올바른 값이 전달되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
	}

}
