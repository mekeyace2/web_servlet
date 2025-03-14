package mallpage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/index.do")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //copyright 정보 Model
	copyright cr = new copyright();
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> cpdata = this.cr.copyright_info();
		request.setAttribute("cpdata", cpdata);
			
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}

}
