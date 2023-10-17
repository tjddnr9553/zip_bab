package memberrecipe.handler;

import handler.Handler;
import member.Member;
import memberrecipe.MemberRecipe;
import memberrecipe.MemberRecipeService;
import recipe.RecipePref;
import recipereview.RecipeReviewService;
import recipereview.dto.RecipeReviewMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class DetailHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        MemberRecipeService service = new MemberRecipeService();
        RecipeReviewService rrService = new RecipeReviewService();

        int memberRecipeId = Integer.parseInt(request.getParameter("memberRecipeId"));

        // recipe 선호도 관련
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("loginId") != null && session.getAttribute("r_view_" + memberRecipeId) == null) {
            session.setAttribute("mr_view_" + memberRecipeId, true);
            LocalDate currentDate = LocalDate.now();
            Member m = (Member) session.getAttribute("loginId");
            LocalDate mBirthday = m.getBirthday();
            Period period = Period.between(mBirthday, currentDate);

            RecipePref rp = getRecipePref(period, m);
            rp.setRecipeId(memberRecipeId);

            service.increaseRpCnt(rp);
        }

        MemberRecipe memberRecipe = service.getById(memberRecipeId);
        String[] ingredients = memberRecipe.getIngredientInfo().split(",");

        List<RecipeReviewMember> reviews = rrService.getReviewMember(memberRecipeId);

        request.setAttribute("r", memberRecipe);
        request.setAttribute("reviews", reviews);
        request.setAttribute("ingredients", ingredients);
        request.setAttribute("view", "/memberrecipe/detail.jsp");

        return view;
    }

    private RecipePref getRecipePref(Period period, Member m) {
        RecipePref rp = new RecipePref();

        int age = period.getYears();
        if (age >= 50) {
            rp.setOver_50(1);
        } else if (age >= 40) {
            rp.setOver_40(1);
        } else if (age >= 30) {
            rp.setOver_30(1);
        } else if (age >= 20) {
            rp.setOver_20(1);
        } else {
            rp.setUnder_20(1);
        }

        int g = m.getGender();
        if (g == 0) {
            rp.setFemale(1);
        } else {
            rp.setMale(1);
        }
        return rp;
    }
}
