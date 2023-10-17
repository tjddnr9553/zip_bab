package follow.handler;

import follow.FollowService;
import handler.Handler;
import member.Member;
import member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FollowerListHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        FollowService followService = new FollowService();
        MemberService service = new MemberService();
        String loginId = request.getParameter("loginId");
        Member m = service.getMember(loginId);

        List<Integer> followers = followService.getFollowerId(m.getMemberId());

        List<Member> followersMembers = new ArrayList<>();
        for (Integer loop:followers){
            Member member = service.getMemberByMemberId(loop);
            System.out.println("loop = " + loop);
            System.out.println("member = " + member);
            followersMembers.add(member);
        }

        request.setAttribute("list", followersMembers);
        request.setAttribute("subTitle", "follower List");

        return "/member/followList.jsp";
    }
}
