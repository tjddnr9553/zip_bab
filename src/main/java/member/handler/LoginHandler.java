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
			request.setAttribute("view", "/member/login.jsp");
		} else {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			MemberService service = new MemberService();
			Member m = service.getMember(id);
			String msg = "";
			msg = "로그인 실패";
			if (m != null && pwd.equals(m.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginId", id);
				session.setAttribute("type", m.getType());
				msg = "로그인 성공 / " + id + " 님은 ";
				if (m.getType() == 1) {
					msg += "구매자입니다.";
				} else {
					msg += "판매자입니다.";
				}
			} else {
				request.setAttribute("view", "/member/login.jsp");
			}
			request.setAttribute("msg", msg);
		}

		return view;
	}

}
