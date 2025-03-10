package session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		//session에 저장된 값을 가져올 때 get을 이용하여 처리 할 수 있음
		/*
		System.out.println(se.getAttribute("id"));
		System.out.println(se.getAttribute("name"));
		System.out.println(se.getAttribute("tel"));
		*/
		request.setAttribute("se",se);	//jsp로 session을 전달
		
		RequestDispatcher rd = request.getRequestDispatcher("./session2.jsp");
		rd.forward(request, response);
		//getMaxInactiveInterval() : session 최대 유지시간을 확인 클래스
		System.out.println(se.getMaxInactiveInterval());
	}

}
