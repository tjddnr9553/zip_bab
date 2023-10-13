package follow.handler;

import follow.FollowService;
import handler.Handler;
import member.Member;
import member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        int followerId = Integer.parseInt(request.getParameter("followerId"));
        int followingId = Integer.parseInt(request.getParameter("followingId"));
        FollowService followService = new FollowService();
        MemberService mService = new MemberService();

        if(followService.isFollowed(followerId,followingId)){
            followService.delFollow(followerId,followingId);
        } else{
            followService.addFollow(followerId, followingId);
        }

        Member m = mService.getMemberByMemberId(followingId);

        return "redirect:/follow/mypage.do?loginId=" + m.getLoginId();
    }
}
