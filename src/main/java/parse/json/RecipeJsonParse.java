package parse.json;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class RecipeJsonParse {
    public static void main(String[] args) {
        String urlstr = "";
        URL url;
        log.info("search url : {}", urlstr);

        try {
            File file = new File("src/main/resources/writeFile.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file, true);

            url = new URL(urlstr);

            // 웹 페이지 url 커넥션 수립. 웹 연결
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(in));
            JSONObject cookrcp01 = (JSONObject) obj.get("COOKRCP01");
            JSONArray arr = (JSONArray) cookrcp01.get("row");

            for (Object o : arr) {
                JSONObject item = (JSONObject) o;
                String title = getParseValue(item.get("RCP_NM").toString());
                String way = getParseValue(item.get("RCP_WAY2").toString());
                String ingredientInfo = getParseValue(item.get("RCP_PARTS_DTLS").toString());

                String manual01 = getParseValue(item.get("MANUAL01").toString());
                String manual02 = getParseValue(item.get("MANUAL02").toString());
                String manual03 = getParseValue(item.get("MANUAL03").toString());
                String manual04 = getParseValue(item.get("MANUAL04").toString());
                String manual05 = getParseValue(item.get("MANUAL05").toString());
                String manual06 = getParseValue(item.get("MANUAL06").toString());
                String manual07 = getParseValue(item.get("MANUAL07").toString());
                String manual08 = getParseValue(item.get("MANUAL08").toString());
                String manual09 = getParseValue(item.get("MANUAL09").toString());
                String manual10 = getParseValue(item.get("MANUAL10").toString());
                String manual11 = getParseValue(item.get("MANUAL11").toString());
                String manual12 = getParseValue(item.get("MANUAL12").toString());
                String manualImg01 = getParseValue(item.get("MANUAL_IMG01").toString());
                String manualImg02 = getParseValue(item.get("MANUAL_IMG02").toString());
                String manualImg03 = getParseValue(item.get("MANUAL_IMG03").toString());
                String manualImg04 = getParseValue(item.get("MANUAL_IMG04").toString());
                String manualImg05 = getParseValue(item.get("MANUAL_IMG05").toString());
                String manualImg06 = getParseValue(item.get("MANUAL_IMG06").toString());
                String manualImg07 = getParseValue(item.get("MANUAL_IMG07").toString());
                String manualImg08 = getParseValue(item.get("MANUAL_IMG08").toString());
                String manualImg09 = getParseValue(item.get("MANUAL_IMG09").toString());
                String manualImg10 = getParseValue(item.get("MANUAL_IMG10").toString());
                String manualImg11 = getParseValue(item.get("MANUAL_IMG11").toString());
                String manualImg12 = getParseValue(item.get("MANUAL_IMG12").toString());
                String manualImg13 = getParseValue(item.get("MANUAL_IMG13").toString());
                String manualImg14 = getParseValue(item.get("MANUAL_IMG14").toString());
                String manualImg15 = getParseValue(item.get("MANUAL_IMG15").toString());
                String manualImg16 = getParseValue(item.get("MANUAL_IMG16").toString());
                String manualImg17 = getParseValue(item.get("MANUAL_IMG17").toString());
                String manualImg18 = getParseValue(item.get("MANUAL_IMG18").toString());
                String manualImg19 = getParseValue(item.get("MANUAL_IMG19").toString());
                String manualImg20 = getParseValue(item.get("MANUAL_IMG20").toString());
                String attFileNoMain = getParseValue(item.get("ATT_FILE_NO_MAIN").toString());
                String infoEn = getParseValue(item.get("INFO_ENG").toString());
                log.info("attFileNoMain : {}", attFileNoMain);
                log.info("infoEn : {}", infoEn);

                String str = """
                        insert into "Recipe" ("recipeId", "title", "way", "ingredientInfo", "manual_01",
                         "manual_02", "manual_03","manual_04","manual_05","manual_06","manual_07","manual_08",
                          "manual_09", "manual_10", "manual_11", "manual_12","manual_img_01", "manual_img_02",
                          "manual_img_03", "manual_img_04", "manual_img_05", "manual_img_06", "manual_img_07",
                          "manual_img_08", "manual_img_09", "manual_img_10", "manual_img_11", "manual_img_12",
                          "manual_img_13", "manual_img_14", "manual_img_15", "manual_img_16", "manual_img_17",
                          "manual_img_18", "manual_img_19", "manual_img_20", "completePicture", "calorie") values (
                          %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s,%s,
                          %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);
                        """.formatted("Recipe_seq.nextval", title, way, ingredientInfo, manual01, manual02, manual03, manual04,
                        manual05, manual06, manual07, manual08, manual09, manual10, manual11, manual12,
                        manualImg01, manualImg02, manualImg03, manualImg04, manualImg05, manualImg06, manualImg07,
                        manualImg08, manualImg09, manualImg10, manualImg11, manualImg12, manualImg13, manualImg14,
                        manualImg15, manualImg16, manualImg17, manualImg18, manualImg19, manualImg20, attFileNoMain, infoEn);

                fos.write(str.getBytes());

            }

            fos.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getParseValue(String value) {
        if (Objects.isNull(value) || value.isBlank()) {
            return "null";
        }

        return new StringBuilder().append('\'').append(value).append('\'').toString();
    }
}
