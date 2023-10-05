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
		String id = request.getParameter("id");
		Member m = (new MemberService()).getMember(id);
		boolean flag = false;
		if (m == null) {
			flag = true;
		}
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		
		String txt = obj.toJSONString();
		return "responsebody/" + txt;
	}

}
