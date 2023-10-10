package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import lombok.extern.slf4j.Slf4j;
import member.Member;
import member.MemberService;

import java.time.LocalDate;

@Slf4j
public class JoinHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		//log.info("JoinHandler 실행확인");

		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if (request.getMethod().equals("GET")) {
			view = "/member/join.jsp";
		} else {
			String loginId = request.getParameter("loginId");
			//log.info("username 확인 : {}", username);
			String nickname = request.getParameter("nickname");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String birthdayStr = request.getParameter("birthday");
			LocalDate birthday =
					LocalDate.parse(request.getParameter("birthday"));
			int gender = Integer.parseInt(request.getParameter("gender"));


			MemberService service = new MemberService();
			service.addMember(new Member(0, loginId, nickname, password, email,birthday,gender));

			view = "redirect:/index.jsp";
		}

		return view;
	}

}
