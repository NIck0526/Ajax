package servlet.step3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingAjaxServlet
 */
@WebServlet("/EncodingAjaxServlet")
public class EncodingAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EncodingAjaxServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;charset=utf-8");
		PrintWriter out = response.getWriter();
		String nick = request.getParameter("nick");
		//nick=URLDecoder.decode(nick,"utf-8");
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			
		}
		out.print(nick);
	}

	

}
