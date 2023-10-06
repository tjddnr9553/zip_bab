package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("recipeId"));
        RecipeService service = new RecipeService();
        Recipe r = service.getById(id);
        request.setAttribute("r",r);
        return "/recipe/detail.jsp";
    }
}
