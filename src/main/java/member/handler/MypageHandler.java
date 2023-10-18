package member.handler;

import bookmark.Bookmark;
import bookmark.BookmarkService;
import follow.FollowService;
import handler.Handler;
import member.Member;
import member.MemberService;
import memberrecipe.MemberRecipe;
import memberrecipe.MemberRecipeService;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class MypageHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        String loginId = request.getParameter("loginId");

        HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginId");
        FollowService followService = new FollowService();

        MemberService service = new MemberService();
        Member m = service.getMember(loginId);
        int followerCount = followService.getFollower(m.getMemberId());
        int followingCount = followService.getFollowing(m.getMemberId());

        //북마크 목록 출력
        BookmarkService bservice = new BookmarkService();
        RecipeService rservice = new RecipeService();
        ArrayList<Bookmark> blist = bservice.getByMemberId(m.getMemberId());
        ArrayList<Recipe> rlist = new ArrayList<>();
        for (Bookmark b : blist) {
            Recipe r = rservice.getById(b.getRecipeId());
            rlist.add(r);
        }

        // 작성한 글 출력
        MemberRecipeService mrService = new MemberRecipeService();
        List<MemberRecipe> wlist = mrService.getByMemberId(m.getMemberId());


        request.setAttribute("rlist", rlist);
        request.setAttribute("wlist", wlist);
        request.setAttribute("view","/member/mypage.jsp");
        request.setAttribute("member", m);
        request.setAttribute("followerCount", followerCount);
        request.setAttribute("followingCount", followingCount);


        List<Integer> following = followService.getFollowingId(m.getMemberId());
        // following : [1,5,23,12,5] 단건 데이터가 필요하다.
        List<Integer> followers = followService.getFollowerId(m.getMemberId());

        List<Member> follwingMembers = new ArrayList<>();
        for (Integer loop : following) {
            Member member = service.getMemberByMemberId(loop);
            follwingMembers.add(member);
        }

        List<Member> followersMembers = new ArrayList<>();
        for (Integer loop:followers){
            Member member = service.getMemberByMemberId(loop);
            followersMembers.add(member);
        }
        boolean isFollowed = false;
        if(loginMember!=null){
            isFollowed = followService.isFollowed(loginMember.getMemberId(),m.getMemberId());
        }

        request.setAttribute("member", m);
        request.setAttribute("followerCount", followerCount);
        request.setAttribute("followingCount", followingCount);
        request.setAttribute("following", following);
        request.setAttribute("follower", followers);
        request.setAttribute("followingMembers", follwingMembers);
        request.setAttribute("followersMembers", followersMembers);
        request.setAttribute("isFollowed", isFollowed);

        return view;

    }
}
