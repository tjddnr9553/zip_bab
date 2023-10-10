package review.handler;

import handler.Handler;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewDelHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int recipeId = Integer.parseInt(request.getParameter("recipeId"));
        String view = "redirect:/recipe/detail.do?recipeId=" + recipeId + "#review";

        if (request.getMethod() == "GET") {

        } else {
            ReviewService service = new ReviewService();
            service.delReview(reviewId);
        }
        return view;
    }
}
