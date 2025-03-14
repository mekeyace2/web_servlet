package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/product_list.do")
public class product_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //DTO
	dto_product pd = new dto_product();
	//select Model
	m_product mp = new m_product();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String midx = request.getParameter("midx");
		String pagename = "";
		
		if(midx==null) {
		ArrayList<ArrayList<String>> all = this.mp.product_all();
		request.setAttribute("all", all);
		
		//jsp 로드하여 View 역활로 데이터 출력
		pagename = "./product_list.jsp";
		}
		else {
		pagename = "./product_view.jsp";	
		}
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);	
		
		
	}

}
