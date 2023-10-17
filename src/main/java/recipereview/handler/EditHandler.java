package recipereview.handler;

import handler.Handler;
import member.Member;
import org.json.simple.JSONObject;
import recipereview.RecipeReview;
import recipereview.RecipeReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class EditHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";

        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        RecipeReviewService service = new RecipeReviewService();
        RecipeReview r = service.getReview(reviewId);
        HttpSession session = request.getSession(false);
        JSONObject obj = new JSONObject();
        obj.put("result", false);

        if (request.getMethod().equals("GET")) {
            obj.put("message", "잘못된 접근!");
            String res = obj.toJSONString();
            return "responsebody/" + res;
        } else {
            if (Objects.isNull(session.getAttribute("loginId"))) {
                obj.put("message", "로그인 해주세요.");
                String res = obj.toJSONString();
                return "responsebody/" + res;
            }

            if (r.getMemberId() != ((Member) session.getAttribute("loginId")).getMemberId()) {
                obj.put("message", "자신의 글만 수정할 수 있습니다.");
                String res = obj.toJSONString();
                return "responsebody/" + res;
            }

            String content = request.getParameter("content");

            RecipeReview review = new RecipeReview(reviewId, 0, 0, content, null);
            service.editReview(review);
            obj.put("result", true);
            obj.put("reviewId", reviewId);
            obj.put("content", content);
        }

        String res = obj.toJSONString();
        return "responsebody/" + res;
    }
}
