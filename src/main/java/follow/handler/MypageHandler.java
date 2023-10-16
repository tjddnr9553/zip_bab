package follow.handler;

import bookmark.Bookmark;
import bookmark.BookmarkService;
import follow.FollowService;
import handler.Handler;
import member.Member;
import member.MemberService;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class MypageHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        String loginId = request.getParameter("loginId");

        HttpSession session = request.getSession();
//      Member loginMember = (Member) session.getAttribute("loginId");
        FollowService followService = new FollowService();

        MemberService service = new MemberService();
        Member m = service.getMember(loginId);
        int followerCount = followService.getFollower(m.getMemberId());
        int followingCount = followService.getFollowing(m.getMemberId());

        //북마크 목록 출력
        int memberId = Integer.parseInt(request.getParameter("memberId"));
        BookmarkService bservice = new BookmarkService();
        RecipeService rservice = new RecipeService();
        ArrayList<Bookmark> blist = bservice.getByMemberId(memberId);
        ArrayList<Recipe> rlist = new ArrayList<>();
        for (Bookmark b : blist) {
            Recipe r = rservice.getById(b.getRecipeId());
            rlist.add(r);
        }

        request.setAttribute("rlist", rlist);
        request.setAttribute("view","/member/mypage.jsp");
        request.setAttribute("member", m);
        request.setAttribute("followerCount", followerCount);
        request.setAttribute("followingCount", followingCount);
        return view;
    }
}
