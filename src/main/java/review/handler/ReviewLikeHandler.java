package review.handler;

import handler.Handler;
import member.Member;
import org.json.simple.JSONObject;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class ReviewLikeHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Member m = (Member) session.getAttribute("loginId");

        JSONObject obj = new JSONObject(); // {}
        obj.put("result", false);
        if (Objects.nonNull(m)) {
            if (Objects.equals(request.getMethod(), "POST")) {
                ReviewService service = new ReviewService();
                int memberId = m.getMemberId();
                int reviewId = Integer.parseInt(request.getParameter("reviewId"));
                System.out.println("reviewId = " + reviewId);
                boolean isLiked = service.isLiked(memberId, reviewId);
                System.out.println("isLiked = " + isLiked);
                if (isLiked) {
                    service.delLike(memberId, reviewId);
                    int cnt = service.getLikeCnt(reviewId);
                    obj.put("result", true);
                    obj.put("cnt", cnt);
                } else {
                    service.addLike(memberId, reviewId);
                    int cnt = service.getLikeCnt(reviewId);
                    obj.put("result", true);
                    obj.put("cnt", cnt);
                }
            }
        }

        String res = obj.toJSONString();
        return "responsebody/" + res;
    }
}
