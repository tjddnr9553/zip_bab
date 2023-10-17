package recipe.handler;

import bookmark.Bookmark;
import bookmark.BookmarkService;
import handler.Handler;
import member.Member;
import recipe.RecipeService;
import recipe.dto.RecipePrefDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;

public class ListByPageHandler implements Handler {
    private final int RECIPES_PER_PAGE = 30; // 페이지 당 레시피 수

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        int amount = RECIPES_PER_PAGE;
        String view = "/index.jsp";
        RecipeService service = new RecipeService();
        BookmarkService bservice = new BookmarkService();
        ArrayList<RecipePrefDto> list;

//        ArrayList<Recipe> allRecipe = service.getAll();

        //북마크 여부 확인, 비로그인 처리
        int memberId = 0;
        HttpSession session = request.getSession(true);
        if (Objects.nonNull(session.getAttribute("loginId"))) {
            memberId = ((Member) session.getAttribute("loginId")).getMemberId();
        }
        ArrayList<Bookmark> blist = bservice.getByMemberId(memberId);

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
        String queryStr = "";
        if (Objects.nonNull(title) && !title.isEmpty()) {
            list = service.getAllByTitle(startRow, endRow, title, memberId);
            queryStr = "title=" + title;
        } else if (Objects.nonNull(ingredient) && !ingredient.isEmpty()) {
            list = service.getAllByIngred(startRow, endRow, ingredient, memberId);
            queryStr = "ingredient=" + ingredient;
        } else if (Objects.nonNull(paramOrder) && !paramOrder.isEmpty()) {
            int order = Integer.parseInt(paramOrder);
            if (order > 8 || order < 1) {
                order = 1;
            } else {
                order += 40;
            }
            list = service.getAllByPrefOrder(startRow, endRow, order, memberId);
            queryStr = "order=" + order;
        } else {
            list = service.getAllByPage(startRow, endRow, memberId);
        }

        int totalPage = 0;
        if (!list.isEmpty()) {
            totalPage = (int) Math.ceil((double) list.get(0).getTotalCnt() / RECIPES_PER_PAGE);
        }

//        if(request.getParameter("pageNum") == null){
//            String msg = "존재하지 않는 페이지입니다. 1페이지로 이동합니다.";
//            String url = request.getContextPath()+"/recipe/listByPage.do?pageNum=1";
//            return "responsebody/<script>alert('"+msg+"');location.href='"+url+"';</script>";
//        }
        if (pageNum < 1 || pageNum > totalPage) {
            String msg = "존재하지 않는 페이지입니다. 1페이지로 이동합니다.";
            String url = request.getContextPath() + "/recipe/listByPage.do?pageNum=1&" + queryStr;
            return "responsebody/<script>alert('" + msg + "');location.href='" + url + "';</script>";
        }


        request.setAttribute("list", list);
        request.setAttribute("blist", blist);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("queryStr", queryStr);
        request.setAttribute("view", "/recipe/list.jsp");
        return view;
    }
}