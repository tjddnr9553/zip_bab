package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ListHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        RecipeService service = new RecipeService();
        ArrayList<Recipe> list = service.getAll();
        request.setAttribute("list",list);
        return "/recipe/test.jsp";
    }
}
