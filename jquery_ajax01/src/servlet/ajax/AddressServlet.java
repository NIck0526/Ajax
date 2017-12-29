package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> map = new HashMap<>();
    
   @Override
   public void init() throws ServletException {
	   map.put("김광석", "동성로");
	   map.put("신해철", "수내동");
	   map.put("김동률", "여의도");
	   map.put("김범수", "신림동");
	   map.put("이적", "혜화동");
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset:utf-8");
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		out.println(map.get(name));
	}

}
