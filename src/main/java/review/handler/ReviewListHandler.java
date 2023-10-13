package review.handler;

import handler.Handler;
import review.Review;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReviewListHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        ReviewService service = new ReviewService();
        if (request.getMethod().equals("GET")) {
            List<Review> list = service.getAll();
            Review r = list.get(0);
            request.setAttribute("r", r);

//            request.setAttribute("view", "responsebody/member/edit.jsp");
            return "responsebody/" + r.toString();
        }
        return view;
    }
}
