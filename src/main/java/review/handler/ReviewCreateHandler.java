package review.handler;

import handler.Handler;
import member.Member;
import review.Review;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class ReviewCreateHandler implements Handler {
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
            ReviewService service = new ReviewService();

            int memberId = ((Member)session.getAttribute("loginId")).getMemberId();
            String content = request.getParameter("content");

            Review r = new Review(0, memberId, recipeId, content, null);
            service.addReview(r);
            view = "redirect:/recipe/detail.do?recipeId=" + recipeId + "#review";
        }
        return view;
    }
}
