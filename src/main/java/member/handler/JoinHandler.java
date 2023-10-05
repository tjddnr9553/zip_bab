package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.Member;
import member.MemberService;

public class JoinHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if (request.getMethod().equals("GET")) {
			request.setAttribute("view", "/member/join.jsp");
		} else {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int type = Integer.parseInt(request.getParameter("type"));

			MemberService service = new MemberService();
			service.addMember(new Member(id, pwd, name, email, type));

			view = "redirect:/index.jsp";
		}

		return view;
	}

}
