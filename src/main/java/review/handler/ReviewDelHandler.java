package review.handler;

import handler.Handler;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewDelHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod() == "GET") {
            return null;
        } else {
            int reviewId = Integer.parseInt(request.getParameter("reviewId"));
            ReviewService service = new ReviewService();
            service.delReview(reviewId);
        }
        return null;
    }
}
