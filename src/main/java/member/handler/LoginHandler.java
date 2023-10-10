package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.Member;
import member.MemberService;

public class LoginHandler implements Handler {

		@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if (request.getMethod().equals("GET")) {
//			request.setAttribute("view", "/member/login.jsp");
			view = "/member/login.jsp";
		} else {
			String loginId = request.getParameter("loginId");
			String password = request.getParameter("password");

			MemberService service = new MemberService();
			Member m = service.getMember(loginId);

			if (m != null && password.equals(m.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginId", m);
			} else {
				view = "/member/login.jsp";
//				request.setAttribute("view", "/member/login.jsp");
			}

		}

		return view;
	}

}

