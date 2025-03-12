package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/join.do")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		footers ft = new footers();
		ft.fts();
		request.setAttribute("cpdata", ft.cdata);
		
		RequestDispatcher rd = request.getRequestDispatcher("./join.jsp");
		rd.forward(request, response);
	}
}

class footers extends ab_footer {
	public footers() {
		this.fts();
	}
	@Override
	public void fts() {
		super.fts();
	}
}



