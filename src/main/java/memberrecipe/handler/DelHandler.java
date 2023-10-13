package memberrecipe.handler;

import handler.Handler;
import memberrecipe.MemberRecipe;
import memberrecipe.MemberRecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Objects;

public class DelHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getRealPath("/images/memberrecipe/");

        int memberRecipeId = Integer.parseInt(request.getParameter("memberRecipeId"));
        MemberRecipeService service = new MemberRecipeService();
        MemberRecipe memberRecipe = service.getById(memberRecipeId);

        String[] imgs = {memberRecipe.getManual_img_01(), memberRecipe.getManual_img_02(), memberRecipe.getManual_img_03(),
                memberRecipe.getManual_img_04(), memberRecipe.getManual_img_05(), memberRecipe.getManual_img_06(),
                memberRecipe.getManual_img_07(), memberRecipe.getManual_img_08(), memberRecipe.getManual_img_09(),
                memberRecipe.getManual_img_10(), memberRecipe.getManual_img_11(), memberRecipe.getManual_img_12(),
                memberRecipe.getCompletePicture()};

        for (String f : imgs) {
            if (Objects.nonNull(f)) {
                File file = new File(path + f);
                file.delete();
            }
        }

        service.delMemberRecipe(memberRecipeId);

        return "redirect:/memberrecipe/list.do";
    }
}
