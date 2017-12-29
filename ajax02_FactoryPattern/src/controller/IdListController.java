package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdListController implements Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 클라이언트(웹 브라우저) 가 서버로부터 데이터를 받을 때 캐시 저장소를 아예 사용하지 않겠다는 설정
		 * 이전에 캐시에 저장된 데이타가 출력되는 경우를 방지하는 의도
		 * Ajax 프로그램에서 기술의 정확도를 높이려면 이 부분을 기술하는것이 좋다.
		 * 
		 * ::
		 * 
		 * 은행의 웹 사이트 경우, 보안상 중요한 데이타를 처리하는 사이트는 반드시 이 부분이 기술..
		 * 서버가 작업을 수행한 후 리턴되는 결과값을 웹 브라우저에 흔적을 남기지 않겠다는 의도
		 * 혹은
		 * 서버쪽 디비값이 자주 변경되는 경우,,, 이런 경우에도 정보를 저장하지 않도록 처리,,
		 * 
		 */
		
		response.setHeader("Cache-Control", "no-cache"); // 주는것이 좋음!
		List<String> list = MemberDAO.getInstance().getIdList();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("show_idList.jsp");
	}
}
