package review.handler;

import handler.Handler;
import member.Member;
import review.Review;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class ReviewEditHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";

        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        ReviewService service = new ReviewService();
        Review r = service.getReview(reviewId);
        HttpSession session = request.getSession(false);

        if (Objects.isNull(session.getAttribute("loginId"))) {
            return "responsebody/<script>alert('로그인 해주세요.');history.back();</script>";
        }
        if (r.getMemberId() != ((Member) session.getAttribute("loginId")).getMemberId()) {
            return "responsebody/<script>alert('자신의 글만 수정할 수 있습니다.');history.back();</script>";
        }

        if (request.getMethod().equals("GET")) {
            Review review = service.getReview(reviewId);
            request.setAttribute("review", review);
            request.setAttribute("view", "/review/edit.jsp");
        } else {
            String content = request.getParameter("content");
            int recipeId = Integer.parseInt(request.getParameter("recipeId"));

            Review review = new Review(reviewId, 0, 0, content, null);
            service.editReview(review);
            view = "redirect:/recipe/detail.do?recipeId=" + recipeId + "#review";

        }
        return view;
    }
}
