package follow.handler;

import follow.FollowService;
import handler.Handler;
import member.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MypageHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("loginId");
        FollowService followService = new FollowService();
        int followerCount = followService.getFollower(member.getMemberId());
        int followingCount = followService.getFollowing(member.getMemberId());

        
        return null;
    }
}
