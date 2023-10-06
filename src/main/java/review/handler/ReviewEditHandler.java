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
        ReviewService service = new ReviewService();
        if (request.getMethod().equals("GET")) {
            request.setAttribute("view", "/review/edit.jsp");

        } else {
            int reviewId = Integer.parseInt(request.getParameter("reviewId"));
            String content = request.getParameter("content");

            Review r = new Review(reviewId, 0, 0, content, null);
            service.editReview(r);
        }
        return view;
    }
}
