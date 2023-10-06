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
			String username = request.getParameter("username");

			Member m = service.getMember(username);

			request.setAttribute("m", m);
			request.setAttribute("view", "/member/edit.jsp");
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String birthdayStr = request.getParameter("birthday");
			LocalDate birthday =null;
			service.editMember(new Member(0,username, nickname, password, "",null, 0));
			view = "redirect:" + view;
		}

		return view;
	}

}
