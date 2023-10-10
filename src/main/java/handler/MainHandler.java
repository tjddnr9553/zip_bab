package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainHandler implements Handler{
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        return "/index.jsp";
    }
}
