package review.handler;

import handler.Handler;
import member.Member;
import review.Review;
import review.ReviewService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ReviewListHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        ReviewService service = new ReviewService();
        if (request.getMethod().equals("GET")) {
            ArrayList<Review> list = service.getAll();
            Review r = list.get(0);
            request.setAttribute("r", r);

//            request.setAttribute("view", "/member/edit.jsp");
            return "responsebody/" + r.toString();
        }
        return view;
    }
}
