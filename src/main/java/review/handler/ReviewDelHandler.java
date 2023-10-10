package review.handler;

import handler.Handler;
import member.Member;
import review.Review;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class ReviewDelHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int recipeId = Integer.parseInt(request.getParameter("recipeId"));
        String view = "redirect:/recipe/detail.do?recipeId=" + recipeId + "#review";
        
        ReviewService service = new ReviewService();
        Review r = service.getReview(reviewId);
        HttpSession session = request.getSession(false);
        
        if (Objects.isNull(session.getAttribute("loginId"))) {
            return "responsebody/<script>alert('로그인 해주세요.');history.back();</script>";
        }
        if (r.getMemberId() != ((Member) session.getAttribute("loginId")).getMemberId()) {
            return "responsebody/<script>alert('자신의 글만 삭제할 수 있습니다.');history.back();</script>";
        }
        
        if (request.getMethod().equals("POST")) {
            service.delReview(reviewId);
        }
        return view;
    }
}
