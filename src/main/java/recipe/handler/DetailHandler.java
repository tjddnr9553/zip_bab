package recipe.handler;

import handler.Handler;
import recipe.Recipe;
import recipe.RecipeService;
import review.ReviewMember;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class DetailHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        int id = Integer.parseInt(request.getParameter("recipeId"));
        RecipeService service = new RecipeService();
        ReviewService rService = new ReviewService();

        Recipe r = service.getById(id);
        ArrayList<ReviewMember> reviews = rService.getReviewMember(id);

        request.setAttribute("r",r);
        request.setAttribute("reviews", reviews);
        request.setAttribute("view","/recipe/detail.jsp");
        return view;
    }
}
