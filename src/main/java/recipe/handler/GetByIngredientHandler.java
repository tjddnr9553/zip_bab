package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetByIngredientHandler implements Handler {
    private final int RECIPES_PER_PAGE = 30; // 페이지 당 레시피 수
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        String ingredient = request.getParameter("ingredient");
        RecipeService service = new RecipeService();
        ArrayList<Recipe> getIngredient = service.getByIngredientInfo(ingredient);
        int total = (int) Math.ceil((double) getIngredient.size() / RECIPES_PER_PAGE);
        int pageNum;
        if (request.getParameter("pageNum") == null) {
            pageNum = 1;
        } else {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        int amount = RECIPES_PER_PAGE;
        int startRow = (pageNum - 1) * amount + 1;
        int endRow = pageNum * amount;
        ArrayList<Recipe> list = service.getByIngredientInfoPage(ingredient, endRow, startRow);
        request.setAttribute("ingredient",ingredient);
        request.setAttribute("list", list);
        request.setAttribute("total", total);
        request.setAttribute("view","/recipe/list.jsp");
        return view;
    }
}
