package memberrecipe.handler;

import handler.Handler;
import memberrecipe.MemberRecipe;
import memberrecipe.MemberRecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class ImgDelHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getRealPath("/images/memberrecipe/");
        int memberRecipeId = Integer.parseInt(request.getParameter("memberRecipeId"));
        int imgNum = Integer.parseInt(request.getParameter("imgNum").split("_")[2]);

        MemberRecipeService memberRecipeService = new MemberRecipeService();
        MemberRecipe memberRecipe = memberRecipeService.getById(memberRecipeId);

        String[] imgs = {memberRecipe.getManual_img_01(), memberRecipe.getManual_img_02(), memberRecipe.getManual_img_03()
                , memberRecipe.getManual_img_04(), memberRecipe.getManual_img_05(), memberRecipe.getManual_img_06()
                , memberRecipe.getManual_img_07(), memberRecipe.getManual_img_08(), memberRecipe.getManual_img_09()
                , memberRecipe.getManual_img_10(), memberRecipe.getManual_img_11(), memberRecipe.getManual_img_12()
                , memberRecipe.getCompletePicture()
        };

        File delf = new File(path + imgs[imgNum - 1]);
        delf.delete();

        imgs[imgNum - 1] = null;
        for (int i = 0; i < imgs.length; i++) {
            if (imgs[i] == null) {
                imgs[i] = "";
            }
        }

        memberRecipeService.editMemberRecipeImg(
                MemberRecipe.builder()
                        .memberRecipeId(memberRecipeId)
                        .manual_img_01(imgs[0])
                        .manual_img_02(imgs[1])
                        .manual_img_03(imgs[2])
                        .manual_img_04(imgs[3])
                        .manual_img_05(imgs[4])
                        .manual_img_06(imgs[5])
                        .manual_img_07(imgs[6])
                        .manual_img_08(imgs[7])
                        .manual_img_09(imgs[8])
                        .manual_img_10(imgs[9])
                        .manual_img_11(imgs[10])
                        .manual_img_12(imgs[11])
                        .completePicture(imgs[12])
                        .build()
        );

        return "redirect:/memberrecipe/detail.do?memberRecipeId=" + memberRecipeId;
    }
}
