package recipereview.handler;

import handler.Handler;
import member.Member;
import recipereview.RecipeReview;
import recipereview.RecipeReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class CreateHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";

        int recipeId = Integer.parseInt(request.getParameter("recipeId"));
        HttpSession session = request.getSession(false);

        if (Objects.isNull(session.getAttribute("loginId"))) {
            return "responsebody/<script>alert('로그인 해주세요.');history.back();</script>";
        }

        if (request.getMethod().equals("GET")) {
            request.setAttribute("recipeId", recipeId);
            request.setAttribute("view", "/review/create.jsp");
        } else {
            RecipeReviewService service = new RecipeReviewService();

            int memberId = ((Member)session.getAttribute("loginId")).getMemberId();
            String content = request.getParameter("content");

            RecipeReview r = new RecipeReview(0, memberId, recipeId, content, null);
            service.addReview(r);

//            ReviewMember rm = (ReviewMember) service.getReviewMember(r.getReviewId());
//            System.out.println("r = " + r);
//            JSONObject review = new JSONObject();
//            review.put("")

            view = "redirect:/memberrecipe/detail.do?memberRecipeId=" + recipeId + "#review";

        }
        return view;
    }
}
