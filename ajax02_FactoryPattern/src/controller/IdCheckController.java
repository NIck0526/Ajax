package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckController implements Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean flag=MemberDAO.getInstance().isExist(id);
		PrintWriter out = response.getWriter();
		/*String path = "idcheck.jsp";
		request.setAttribute("flag", flag);
		return new ModelAndView(path);*/
		
		out.print(flag); // true | false
		
		return null;
	}
}












