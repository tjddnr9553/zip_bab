package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.cdimascio.dotenv.Dotenv;

public interface Handler {
//	Dotenv dotenv = Dotenv.load();
//	String path = dotenv.get("MY_PATH");
//	String path = "C:\\Users\\USER\\Desktop\\kosta\\webwork\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shopprod\\";
	int size = 100 * 1024 * 1024;
	
	String process(HttpServletRequest request, HttpServletResponse response);
}
