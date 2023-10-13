package follow.handler;

import follow.FollowService;
import handler.Handler;
import member.Member;
import member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MypageHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String loginId = request.getParameter("loginId");

        HttpSession session = request.getSession();
//        Member loginMember = (Member) session.getAttribute("loginId");
        FollowService followService = new FollowService();

        MemberService service = new MemberService();
        Member m = service.getMember(loginId);
        int followerCount = followService.getFollower(m.getMemberId());
        int followingCount = followService.getFollowing(m.getMemberId());

        request.setAttribute("member", m);
        request.setAttribute("followerCount", followerCount);
        request.setAttribute("followingCount", followingCount);
        return "/member/projection/index.jsp";
    }
}
