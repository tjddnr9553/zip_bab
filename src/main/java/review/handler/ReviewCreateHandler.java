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

        int recipeId = Integer.parseInt(request.getParameter("recipeId"));

        if (request.getMethod().equals("GET")) {
            request.setAttribute("recipeId", recipeId);
            request.setAttribute("view", "/review/create.jsp");
        } else {
            ReviewService service = new ReviewService();

            int memberId = Integer.parseInt(request.getParameter("memberId"));
            String content = request.getParameter("content");

            Review r = new Review(0, memberId, recipeId, content, null);
            service.addReview(r);
            view = "redirect:/recipe/detail.do?recipeId=" + recipeId + "#review";
        }
        return view;
    }
}
