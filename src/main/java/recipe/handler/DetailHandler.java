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
        String input = r.getIngredientInfo();

        ArrayList<String> ingredient = new ArrayList<>();

        if (input.startsWith("●")) {
            String[] splitInput = input.split("●");
            for (String str : splitInput) {
                if (!str.trim().isEmpty()) {
                    String[] colonSplit = str.split(":");
                    if (colonSplit.length > 1) {
                        String[] commaSplit = colonSplit[1].split(",");
                        for (String s : commaSplit) {
                            ingredient.add(s.trim());
                        }
                    }
                }
            }
        } else if (input.startsWith("•")) {
            String[] splitInput = input.split("•");
            for (String str : splitInput) {
                if (!str.trim().isEmpty()) {
                    String[] colonSplit = str.split(":");
                    if (colonSplit.length > 1) {
                        String[] commaSplit = colonSplit[1].split(",");
                        for (String s : commaSplit) {
                            ingredient.add(s.trim());
                        }
                    }
                }
            }
        }
//        else if (input.startsWith("")) {
//            String[] splitInput = input.split("");
//            for (String str : splitInput) {
//                if (!str.trim().isEmpty()) {
//                    String[] colonSplit = str.split(":");
//                    if (colonSplit.length > 1) {
//                        String[] commaSplit = colonSplit[1].split(",");
//                        for (String s : commaSplit) {
//                            ingredient.add(s.trim());
//                        }
//                    }
//                }
//            }
//        }

        ArrayList<ReviewMember> reviews = rService.getReviewMember(id);

        request.setAttribute("ingredient", ingredient);
        request.setAttribute("r", r);
        request.setAttribute("reviews", reviews);
        request.setAttribute("view", "/recipe/detail.jsp");
        return view;
    }
}
