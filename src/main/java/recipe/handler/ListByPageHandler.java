package recipe.handler;

import bookmark.Bookmark;
import bookmark.BookmarkService;
import handler.Handler;
import member.Member;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListByPageHandler implements Handler {
    private final int RECIPES_PER_PAGE = 30; // 페이지 당 레시피 수
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        RecipeService service = new RecipeService();
        ArrayList<Recipe> allRecipe = service.getAll();

        //북마크 여부 확인
        BookmarkService bservice = new BookmarkService();
        HttpSession session = request.getSession(false);
        int memberId = ((Member)session.getAttribute("loginId")).getMemberId();
        ArrayList<Bookmark> blist = bservice.getByMemberId(memberId);

        int total = (int) Math.ceil((double) allRecipe.size() / RECIPES_PER_PAGE);
        if(request.getParameter("pageNum")==null){
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter w = response.getWriter();
                String msg = "존재하지 않는 페이지입니다. 1페이지로 이동합니다.";
                String url = request.getContextPath()+"/recipe/listByPage.do?pageNum=1";
                w.write("<script>alert('"+msg+"');location.href='"+url+"';</script>");
                w.flush();
                w.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        if (pageNum <1 || pageNum >total) {
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter w = response.getWriter();
                String msg = "존재하지 않는 페이지입니다. 1페이지로 이동합니다.";
                String url = request.getContextPath()+"/recipe/listByPage.do?pageNum=1";
                w.write("<script>alert('"+msg+"');location.href='"+url+"';</script>");
                w.flush();
                w.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int amount = RECIPES_PER_PAGE;
        int startRow = (pageNum - 1) * amount + 1;
        int endRow = pageNum * amount;


        ArrayList<Recipe> list = service.getByPage(endRow, startRow);
        request.setAttribute("blist",blist);
        request.setAttribute("total",total);
        request.setAttribute("list", list);
        request.setAttribute("view", "/recipe/list.jsp");
        return view;
    }
}