package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,	//파일 한개의 최대 용량 2MB
		maxRequestSize = 1024 * 1024 * 100	//여러개의 파일을 전송시 총 용량 : 100MB
)
public class part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//회원가입 완료
	PrintWriter pw = null;
	String url = null;	//웹 경로를 저장하는 변수
	String filenm = null;	//파일명을 저장하는 변수
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter();
			
			String mid = request.getParameter("mid");
			String mname = request.getParameter("mname");
			String mpass = request.getParameter("mpass");
			String memail = request.getParameter("memail");
			String mtel = request.getParameter("mtel");
			Part mfile = request.getPart("mfile");	//첨부파일
			
			if(mid.equals("") || mname.equals("") || mpass.equals("") || memail.equals("") || mtel.equals("")) {
				this.pw.write("<script>"
						+ "alert('올바른 데이터 접근이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {	//사용자 정보가 모두 정상 입력 후 파일처리
				this.filenm = mfile.getSubmittedFileName(); //파일명

				if(this.filenm != null && this.filenm != "") {
					long size = mfile.getSize();
					if(size > 2097152) {	//첨부파일 용량 2MB 이상일 경우
						this.pw.write("<script>"
								+ "alert('첨부파일은 최대 2MB까지 입니다.');"
								+ "history.go(-1);"
								+ "</script>");
					}else {	//첨부파일이 용량 2MB 이하일 경우 서버에 저장
						//웹경로
						this.url = request.getServletContext().getRealPath("/user/");
						mfile.write(this.url + this.filenm);
					}
					
				}
			}
			
			//JSP에 값을 전달
			request.setAttribute("mid", mid);
			request.setAttribute("mname", mname);
			request.setAttribute("memail", memail);
			request.setAttribute("mtel", mtel);
			request.setAttribute("image", this.filenm);	//첨부파일 이미지
			
			RequestDispatcher rd = request.getRequestDispatcher("./part3.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			
		}finally {
			this.pw.close();
		}
	}

}
