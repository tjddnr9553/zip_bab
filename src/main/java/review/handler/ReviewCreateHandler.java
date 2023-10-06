package review.handler;

import handler.Handler;
import review.Review;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewCreateHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        ReviewService service = new ReviewService();
        if (request.getMethod().equals("GET")) {
            request.setAttribute("view", "/review/create.jsp");

        } else {
            int memberId = Integer.parseInt(request.getParameter("memberId"));
            int recipeId = Integer.parseInt(request.getParameter("recipeId"));
            String content = request.getParameter("content");

            Review r = new Review(0, memberId, recipeId, content, null);
            service.addReview(r);
        }
        return view;
    }
}
