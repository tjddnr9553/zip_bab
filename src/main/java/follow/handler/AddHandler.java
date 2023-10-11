package follow.handler;

import follow.FollowService;
import handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
         int followerId = Integer.parseInt(request.getParameter("followerId"));
         int followingId = Integer.parseInt(request.getParameter("followingId"));
         FollowService followService = new FollowService();
         followService.addFollow(followerId,followingId);

         return "/";
    }
}
