package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;

public class OutHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";

		if (request.getMethod().equals("POST")) {
			String id = request.getParameter("id");

			MemberService service = new MemberService();
			service.delMember(id);
			view = "redirect:/index.jsp";
		}

		HttpSession session = request.getSession(false);
		session.invalidate();
		return view;
	}

}
