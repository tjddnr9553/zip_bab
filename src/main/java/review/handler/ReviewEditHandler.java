package review.handler;

import handler.Handler;
import review.Review;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewEditHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";

        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        ReviewService service = new ReviewService();

        if (request.getMethod().equals("GET")) {
            Review review = service.getReview(reviewId);
            request.setAttribute("review", review);
            request.setAttribute("view", "/review/edit.jsp");
        } else {
            String content = request.getParameter("content");
            int recipeId = Integer.parseInt(request.getParameter("recipeId"));

            Review r = new Review(reviewId, 0, 0, content, null);
            service.editReview(r);
            view = "redirect:/recipe/detail.do?recipeId=" + recipeId + "#review";
        }
        return view;
    }
}
