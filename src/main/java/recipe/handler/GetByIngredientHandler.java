package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetByIngredientHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        String ingredient = request.getParameter("ingredient");
        RecipeService service = new RecipeService();
        ArrayList<Recipe> list = service.getByIngredientInfo(ingredient);

        request.setAttribute("list",list);
        request.setAttribute("view","/recipe/list.jsp");
        return view;
    }
}
