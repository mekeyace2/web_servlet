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
		//상품을 한가지를 클릭했을 경우 Front-end에서 GET 전송값
		String midx = request.getParameter("midx");
		
		String pagename = "";	//하나의 Controller => 두개의 View존재
		
		
		if(midx==null) {	//상품 전체리스트
		ArrayList<ArrayList<String>> all = this.mp.product_all();
		request.setAttribute("all", all);
		
		//jsp 로드하여 View 역활로 데이터 출력
		pagename = "./product_list.jsp";
		}
		else {	//하나의 상품만 상세내역
		this.pd.setMidx(Integer.parseInt(midx));	//DTO로 전달
		this.mp.oneproduct(this.pd);	//DTO의 객체를 모델로 전달
		
		this.pd = this.mp.pd;	//Controller에서 Model에 있는 DTO 객체 가져오기
		
		//Dto Model을 JSP 전달하기 위한 Attribute
		request.setAttribute("dto", this.pd);
		pagename = "./product_view.jsp";	
		}
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);	
		
		
	}

}
