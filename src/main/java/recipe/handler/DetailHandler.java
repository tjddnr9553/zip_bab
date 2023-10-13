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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        int id = Integer.parseInt(request.getParameter("recipeId"));
        RecipeService service = new RecipeService();
        ReviewService rService = new ReviewService();
        MemberService mService = new MemberService();

        // recipe 선호도 관련
        HttpSession session = request.getSession(false);
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
        String input = r.getIngredientInfo();
        input = input.replaceAll("재료","");
        input = input.replaceAll("[()]","");
        input = input.replaceAll("[\\[\\]]", "");

        ArrayList<String> ingredient = new ArrayList<>();

        // 정규 표현식을 사용하여 "●"로 시작하고 ":"로 끝나는 부분을 제거
        Pattern pattern = Pattern.compile("●(.*?)\\s:");
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, "");
        }
        matcher.appendTail(result);
        String remainingText = result.toString().trim();

        // 숫자 이전의 내용을 출력
        String[] items = remainingText.split(",");
        Pattern wordPattern = Pattern.compile(".*?(?=\\d)");

        for (String item : items) {
            String cleanedItem = item.replaceAll("[^가-힣\\s]", ""); // 한글과 공백만 남김
            cleanedItem = cleanedItem.trim(); // 양 옆의 공백 제거
            Matcher wordMatcher = wordPattern.matcher(item);
            if (wordMatcher.find()) {
                ingredient.add(wordMatcher.group().trim());
            }
        }

//        if (input.startsWith("●")) {
//            String[] splitInput = input.split("●");
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
//        } else if (input.startsWith("•")) {
//            String[] splitInput = input.split("•");
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
//        } else {
//            String[] enterSplit = input.split("\n");
//            for (String str : enterSplit) {
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

        List<ReviewMember> reviews = rService.getReviewMember(id);
        request.setAttribute("ingredient", ingredient);
        request.setAttribute("r", r);
        request.setAttribute("reviews", reviews);
        request.setAttribute("view", "/recipe/detail.jsp");
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
