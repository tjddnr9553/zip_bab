package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;
import member.Member;
import member.MemberService;

public class IdCheckHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String loginId = request.getParameter("loginId");

		Member m = (new MemberService()).getMember(loginId);
		System.out.println("가져온 아이디"+m);
		boolean flag = false;
		if(m==null) {
			flag = true;
		}
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		String txt = obj.toJSONString();
		return "responsebody/"+txt;
	}

}
