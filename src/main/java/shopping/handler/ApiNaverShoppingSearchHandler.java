package shopping.handler;

import handler.Handler;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import shopping.NaverShoppingInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
public class ApiNaverShoppingSearchHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        Dotenv dotenv = Dotenv.load();
        String view = "/index.jsp";
        String clientId = dotenv.get("Naver_Client_Id"); //애플리케이션 클라이언트 아이디
        String clientSecret = dotenv.get("Naver_Client_Secret"); //애플리케이션 클라이언트 시크릿

        String input = request.getParameter("ingredient");
        String text = URLEncoder.encode(input, StandardCharsets.UTF_8);

        String apiURL = "https://openapi.naver.com/v1/search/shop?display=51&query=" + text;    // JSON 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        List<NaverShoppingInfo> shoppingInfos = get(apiURL, requestHeaders);
        log.info("shopping infos : {}", shoppingInfos);

        request.setAttribute("items", shoppingInfos);
        request.setAttribute("view","/recipe/naverShopping.jsp");
        return view;
    }

    private static List<NaverShoppingInfo> get(String apiUrl, Map<String, String> requestHeaders) {
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static List<NaverShoppingInfo> readBody(InputStream body) {
        JSONParser parser = new JSONParser();
        List<NaverShoppingInfo> shoppingInfos = new ArrayList<>();

        try {
            JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(body));
            JSONArray items = (JSONArray) obj.get("items");

            for (Object o : items) {
                JSONObject item = (JSONObject) o;
                String title = getParseValue(item.get("title").toString());
                String link = getParseValue(item.get("link").toString());
                String image = getParseValue(item.get("image").toString());
                String price = getParseValue((String) item.get("lprice"));
                String mallName = getParseValue(item.get("mallName").toString());
                String brand = getParseValue(item.get("brand").toString());
                String maker = getParseValue(item.get("maker").toString());

                shoppingInfos.add(
                        NaverShoppingInfo.builder()
                                .title(title)
                                .link(link)
                                .image(image)
                                .price(price)
                                .mallName(mallName)
                                .brand(brand)
                                .maker(maker)
                                .build()
                );
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return shoppingInfos;
    }

    private static String getParseValue(String value){
        if (Objects.isNull(value) || value.isBlank()) {
            return "";
        }
        return value;
    }
}
