package memberrecipe.handler;

import handler.Handler;
import memberrecipe.MemberRecipe;
import memberrecipe.MemberRecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getRealPath("/images/memberrecipe/");
        MemberRecipeService service = new MemberRecipeService();
        List<MemberRecipe> list = service.getAll();
        request.setAttribute("path", path);
        request.setAttribute("list", list);
        request.setAttribute("view", "/memberrecipe/list.jsp");

        return "/index.jsp";
    }
}
