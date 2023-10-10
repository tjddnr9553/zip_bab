package recipe.handler;

import handler.Handler;
import member.Member;
import member.MemberService;
import recipe.Recipe;
import recipe.RecipePref;
import recipe.RecipeService;
import review.ReviewMember;
import review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class DetailHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        int id = Integer.parseInt(request.getParameter("recipeId"));
        RecipeService service = new RecipeService();
        ReviewService rService = new ReviewService();
        MemberService mService = new MemberService();

        // recipe 선호도 관련
        HttpSession session = request.getSession(false) ;
        if (session != null && session.getAttribute("loginId") != null && session.getAttribute("r_view_" + id) == null) {
            session.setAttribute("r_view_" + id, true);
            LocalDate currentDate = LocalDate.now();
            Member m = (Member) session.getAttribute("loginId");
            LocalDate mBirthday = m.getBirthday();
            Period period = Period.between(mBirthday, currentDate);

            RecipePref rp = getRecipePref(period, m);
            rp.setRecipeId(id);

            service.increaseRpCnt(rp);
        }

        Recipe r = service.getById(id);
        ArrayList<ReviewMember> reviews = rService.getReviewMember(id);
        System.out.println("rm = ");
        for (ReviewMember rm : reviews) {
            System.out.println("rm = " + rm);
            System.out.println(rm);
        }
        request.setAttribute("r",r);
        request.setAttribute("reviews", reviews);
        request.setAttribute("view","/recipe/detail.jsp");
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
