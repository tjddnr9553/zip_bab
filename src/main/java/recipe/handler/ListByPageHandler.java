package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ListByPageHandler implements Handler {
    private static final int TOTAL_RECIPES = 1115; // 전체 레시피 수
    private static final int RECIPES_PER_PAGE = 30; // 페이지 당 레시피 수
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        RecipeService service = new RecipeService();
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
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