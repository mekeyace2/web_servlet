package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deliveryok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw = null;
	
	//HttpServletRequest request;
	//HttpServletResponse response;
	
	//즉시실행 메소드(Servlet) : 일반 class에서 사용하는 형태와는 구조 다릅니다.
    public deliveryok() {
    /*
    	try {
    	 this.request.setCharacterEncoding("utf-8");
    	 this.response.setContentType("text/html;charset=utf-8");
 		 this.pw = this.response.getWriter();
    	}catch (Exception e) {
			
		}
	*/
    }
    //일반메소드
	public void deliveryok(HttpServletRequest request, HttpServletResponse response) {	//action에서 해당 class 실행하면 즉시 메소드
    	try {
    		request.setCharacterEncoding("utf-8");
    		response.setContentType("text/html;charset=utf-8");
    		this.pw = response.getWriter();
    	}
    	catch(Exception e) {
    		System.out.println("해당 URL 경로를 올바르지 않습니다.");
    	}
    }
	//매개변수명을 변경하여 request 또는 response를 다른 이름으로 변경 가능함
	protected void doPost(HttpServletRequest res, HttpServletResponse rep) throws ServletException, IOException {
		this.deliveryok(res,rep);
		String mname = res.getParameter("mname");
		String mtel = res.getParameter("mtel");
		String memail = res.getParameter("memail");
		String maddress = res.getParameter("maddress");
		//클래스 배열하는 이유는 setAttribute 너무 많이 생성하여 jsp로 전달시 getAttribute 많아짐
		ArrayList<String> data = new ArrayList<String>();
		data.add(mname);
		data.add(mtel);
		data.add(memail);
		data.add(maddress);
		
		//클래스 배열을 jsp로 전달
		res.setAttribute("data", data);
		
		RequestDispatcher rd = res.getRequestDispatcher("./deliveryok.jsp");
		rd.forward(res, rep);
	}

}
