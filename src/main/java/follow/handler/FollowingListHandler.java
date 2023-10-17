package follow.handler;

import follow.FollowService;
import handler.Handler;
import member.Member;
import member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FollowingListHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        FollowService followService = new FollowService();
        MemberService service = new MemberService();
        String loginId = request.getParameter("loginId");
        Member m = service.getMember(loginId);

        List<Integer> following = followService.getFollowingId(m.getMemberId());

        List<Member> follwingMembers = new ArrayList<>();
        for (Integer loop : following) {
            Member member = service.getMemberByMemberId(loop);
            follwingMembers.add(member);
        }

        request.setAttribute("followingMembers", follwingMembers);

        return "/member/followList.jsp";
    }
}
