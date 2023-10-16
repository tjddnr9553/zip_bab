package recipe.handler;

import handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;

public class NaverShoppingHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String view = "/index.jsp";
        String ingredient = request.getParameter("ingredient");

        // 네이버 쇼핑 검색 API 요청 URL 생성
        String apiUrl = "https://openapi.naver.com/v1/search/shop.json";
        String clientId = "clientId";  // 본인의 클라이언트 ID로 변경
        String clientSecret = "clientSecret";  // 본인의 클라이언트 Secret으로 변경

        try {
            URL url = new URL(apiUrl + "?query=" + ingredient);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: 예외 처리 로직 추가
        }
        return view;
    }
}