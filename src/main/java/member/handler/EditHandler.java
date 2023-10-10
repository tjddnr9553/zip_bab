package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.Member;
import member.MemberService;

import java.time.LocalDate;

public class EditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		MemberService service = new MemberService();
		if (request.getMethod().equals("GET")) {
			String loginId = request.getParameter("loginId");
			Member m = service.getMember(loginId);
			request.setAttribute("m", m);
			request.setAttribute("view", "/member/edit.jsp");
		} else {
			String loginId = request.getParameter("loginId");
			//String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			service.editMember(new Member(0,loginId, nickname, "", "",null, 0));
			view = "redirect:" + view;
		}

		return view;
	}

}
