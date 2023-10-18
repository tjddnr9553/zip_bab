package memberrecipe.handler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import handler.Handler;
import memberrecipe.MemberRecipe;
import memberrecipe.MemberRecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        String view = "/index.jsp";
        MemberRecipeService service = new MemberRecipeService();

        int memberRecipeId;

        if (request.getMethod().equals("GET")) {//get 방식 처리
            memberRecipeId = Integer.parseInt(request.getParameter("memberRecipeId"));
            MemberRecipe memberRecipe = service.getById(memberRecipeId);
            request.setAttribute("memberRecipe", memberRecipe);
            request.setAttribute("view", "/memberrecipe/edit.jsp");
        } else {//post 방식 처리
            String path = request.getServletContext().getRealPath("/images/memberrecipe/");
            try {
                MultipartRequest req = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());

                memberRecipeId = Integer.parseInt(req.getParameter("memberRecipeId"));
                int memberId = Integer.parseInt(req.getParameter("memberId"));
                String title = req.getParameter("title");
                String subTitle = req.getParameter("subTitle");
                String way = req.getParameter("way");
                String ingredientInfo = req.getParameter("ingredientInfo");
                String manual_01 = req.getParameter("manual_01");
                String manual_02 = req.getParameter("manual_02");
                String manual_03 = req.getParameter("manual_03");
                String manual_04 = req.getParameter("manual_04");
                String manual_05 = req.getParameter("manual_05");
                String manual_06 = req.getParameter("manual_06");
                String manual_07 = req.getParameter("manual_07");
                String manual_08 = req.getParameter("manual_08");
                String manual_09 = req.getParameter("manual_09");
                String manual_10 = req.getParameter("manual_10");
                String manual_11 = req.getParameter("manual_11");
                String manual_12 = req.getParameter("manual_12");
                String calorie = req.getParameter("calorie");

                service.editMemberRecipe(
                        MemberRecipe.builder()
                                .memberRecipeId(memberRecipeId)
                                .memberId(memberId)
                                .title(title)
                                .subTitle(subTitle)
                                .way(way)
                                .ingredientInfo(ingredientInfo)
                                .manual_01(manual_01)
                                .manual_02(manual_02)
                                .manual_03(manual_03)
                                .manual_04(manual_04)
                                .manual_05(manual_05)
                                .manual_06(manual_06)
                                .manual_07(manual_07)
                                .manual_08(manual_08)
                                .manual_09(manual_09)
                                .manual_10(manual_10)
                                .manual_11(manual_11)
                                .manual_12(manual_12)
                                .calorie(calorie)
                                .build()
                );

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            view = "redirect:/memberrecipe/list.do?memberRecipeId=" + memberRecipeId;
        }

        return view;
    }
}
