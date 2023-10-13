package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListByPageHandler implements Handler {
    private static final int TOTAL_RECIPES = 1115; // 전체 레시피 수
    private static final int RECIPES_PER_PAGE = 30; // 페이지 당 레시피 수
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        RecipeService service = new RecipeService();
        if(request.getParameter("pageNum")==null){
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter w = response.getWriter();
                String msg = "존재하지 않는 페이지입니다. 1페이지로 이동합니다.";
                String url = "http://localhost:8686/recipe/listByPage.do?pageNum=1";
                w.write("<script>alert('"+msg+"');location.href='"+url+"';</script>");
                w.flush();
                w.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        if (pageNum <1 || pageNum >38) {
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter w = response.getWriter();
                String msg = "존재하지 않는 페이지입니다. 1페이지로 이동합니다.";
                String url = "http://localhost:8686/recipe/listByPage.do?pageNum=1";
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
        int total = (int) Math.ceil((double) TOTAL_RECIPES / RECIPES_PER_PAGE);

        ArrayList<Recipe> list = service.getByPage(endRow, startRow);
        request.setAttribute("total",total);
        request.setAttribute("list", list);
        request.setAttribute("view", "/recipe/list.jsp");
        return view;
    }
}