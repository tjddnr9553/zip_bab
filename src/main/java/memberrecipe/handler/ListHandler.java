package memberrecipe.handler;

import handler.Handler;
import member.Member;
import memberrecipe.MemberRecipeService;
import memberrecipe.dto.MemberRecipePrefDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

public class ListHandler implements Handler {
    private final int RECIPES_PER_PAGE = 30; // 페이지 당 레시피 수
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        int amount = RECIPES_PER_PAGE;
        MemberRecipeService mrService = new MemberRecipeService();

        // 비로그인 처리
        int memberId = 0;
        HttpSession session = request.getSession(true);
        if (Objects.nonNull(session.getAttribute("loginId"))) {
            memberId = ((Member) session.getAttribute("loginId")).getMemberId();
        }

        // 파라미터 처리
        String paramPageNum = request.getParameter("pageNum");
        String title = request.getParameter("title");
        String ingredient = request.getParameter("ingredient");
        String paramOrder = request.getParameter("order");

        int pageNum = 1;
        if (Objects.nonNull(paramPageNum) && !paramPageNum.isEmpty()) {
            pageNum = Integer.parseInt(paramPageNum);
        }
        int startRow = (pageNum - 1) * amount + 1;
        int endRow = pageNum * amount;

        // list 분기
        List<MemberRecipePrefDto> list;
        String queryStr = "";
        if (Objects.nonNull(title) && !title.isEmpty()) {
            list = mrService.getMemberRecipesByTitle(startRow, endRow, memberId, title);
            queryStr = "title=" + title;
        } else if (Objects.nonNull(ingredient) && !ingredient.isEmpty()) {
            list = mrService.getMemberRecipesByIngred(startRow, endRow, memberId, ingredient);
            queryStr = "ingredient=" + ingredient;
        } else if (Objects.nonNull(paramOrder) && !paramOrder.isEmpty()) {
            int order = Integer.parseInt(paramOrder);
            if (order > 8 || order < 1) {
                order = 1;
            } else {
                order += 36;
            }
            System.out.println("order = " + order);
            list = mrService.getMemberRecipesByPrefOrder(startRow, endRow, memberId, order);
            queryStr = "order=" + order;
        } else {
            list = mrService.getAllByPage(startRow, endRow, memberId);
        }

        int totalPage = 0;
        if (!list.isEmpty()) {
            totalPage = (int) Math.ceil((double) list.get(0).getTotalCnt() / RECIPES_PER_PAGE);
        }

        if (pageNum < 1 || pageNum > totalPage) {
            String msg = "존재하지 않는 페이지입니다. 1페이지로 이동합니다.";
            String url = request.getContextPath() + "/recipe/listByPage.do?pageNum=1&" + queryStr;
            return "responsebody/<script>alert('" + msg + "');location.href='" + url + "';</script>";
        }


        String path = request.getServletContext().getRealPath("/images/memberrecipe/");
        request.setAttribute("path", path);
        request.setAttribute("list", list);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("queryStr", queryStr);
        request.setAttribute("view", "/memberrecipe/list.jsp");

        return "/index.jsp";
    }
}
