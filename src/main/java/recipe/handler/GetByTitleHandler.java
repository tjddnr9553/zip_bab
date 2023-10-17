package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetByTitleHandler implements Handler {
    private final int RECIPES_PER_PAGE = 30; // 페이지 당 레시피 수

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        String title = request.getParameter("title");
        RecipeService service = new RecipeService();
        ArrayList<Recipe> getTitle = service.getByTitle(title);
        int total = (int) Math.ceil((double) getTitle.size() / RECIPES_PER_PAGE);
        int pageNum;
        if (request.getParameter("pageNum") == null) {
            pageNum = 1;
        } else {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        int amount = RECIPES_PER_PAGE;
        int startRow = (pageNum - 1) * amount + 1;
        int endRow = pageNum * amount;
        ArrayList<Recipe> list = service.getByTitlePage(title, endRow, startRow);
        System.out.println("total = " + total);
        System.out.println("list.size() = " + list.size());
        request.setAttribute("title", title);
        request.setAttribute("list", list);
        request.setAttribute("total", total);
        request.setAttribute("view", "/recipe/list.jsp");
        return view;
    }
}
