package memberrecipe.handler;

import handler.Handler;
import memberrecipe.MemberRecipe;
import memberrecipe.MemberRecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DetailHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        MemberRecipeService service = new MemberRecipeService();
        int memberRecipeId = Integer.parseInt(request.getParameter("memberRecipeId"));

        MemberRecipe memberRecipe = service.getById(memberRecipeId);
        String[] ingredients = memberRecipe.getIngredientInfo().split(",");

        request.setAttribute("r", memberRecipe);
        request.setAttribute("ingredients", ingredients);
        request.setAttribute("view", "/memberrecipe/detail.jsp");

        return view;
    }
}
