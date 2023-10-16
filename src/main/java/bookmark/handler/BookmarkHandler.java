package bookmark.handler;

import bookmark.Bookmark;
import bookmark.BookmarkService;
import handler.Handler;
import member.Member;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class BookmarkHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view="/index.jsp";
        BookmarkService service = new BookmarkService();
        RecipeService rservice = new RecipeService();
        HttpSession session = request.getSession();

        if ((session.getAttribute("loginId")) == null) {
            return "responsebody/<script>alert('로그인 해주세요.');history.back();</script>";
        }
        int memberId = ((Member)session.getAttribute("loginId")).getMemberId();
        int recipeId = Integer.parseInt(request.getParameter("recipeId"));

        String referer = request.getHeader("Referer");
        URL preUrl = null;
        try {
            preUrl = new URL(referer);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        String path = preUrl.getPath();
        String query = URLDecoder.decode(preUrl.getQuery(), StandardCharsets.UTF_8);
        String url = path + "?" + query;

        Recipe r = rservice.getById(recipeId);
        Bookmark b = service.checkBookmark(recipeId, memberId);
        if (b == null) {
                service.addBookmark(new Bookmark(0, recipeId, memberId));
                String msg = r.getTitle() + " 레시피가 북마크에 추가됐습니다.";
                return "responsebody/<script>alert('" + msg + "'); window.location.href='" + url + "';</script>";
        } else {
            service.delBookmark(recipeId, memberId);
            String msg = r.getTitle() + " 레시피가 북마크에서 삭제됐습니다.";
            return "responsebody/<script>alert('" + msg + "'); window.location.href='" + url + "';</script>";
        }
    }
}
