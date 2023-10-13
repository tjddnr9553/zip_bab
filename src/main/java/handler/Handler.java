package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.cdimascio.dotenv.Dotenv;

public interface Handler {

//    String path = Dotenv.load().get("IMG_PATH");
    int size = 100 * 1024 * 1024;

    String process(HttpServletRequest request, HttpServletResponse response);
}
