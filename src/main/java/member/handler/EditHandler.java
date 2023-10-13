package member.handler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import handler.Handler;
import lombok.extern.slf4j.Slf4j;
import member.Member;
import member.MemberService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Slf4j
public class EditHandler implements Handler {
    //private final String path = "C:\\Users\\김현주\\OneDrive\\바탕 화면\\집밥\\zip_bab\\src\\main\\webapp\\images\\profile";
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        // FIX Auto-generated method stub
        ServletContext context = request.getServletContext();
        String path = context.getRealPath("/images/profile/");

        System.out.println("path = " + path);

        String view = "/index.jsp";

        MemberService service = new MemberService();
        if (request.getMethod().equals("GET")) {
            String loginId = request.getParameter("loginId");
            log.info("loginId : {}", loginId);
            Member m = service.getMember(loginId);
            log.info("member : {}", m);
            request.setAttribute("m", m);
            request.setAttribute("view", "/member/projection/edit.jsp");
        } else {
            try {

                MultipartRequest req = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
                File f = req.getFile("profile");

                String profile;//업로드된 파일의 파일명을 저장할 배열
                if (f != null && f.length() != 0) {
                    profile = f.getName();
                } else {
                    profile = "";
                }
                String nickname = req.getParameter("nickname");
                String loginId = req.getParameter("loginId");
                Member m = Member.builder()
                        .memberId(0)
                        .loginId(loginId)
                        .nickname(nickname)
                        .email("")
                        .password("")
                        .birthday(null)
                        .gender(0)
                        .profile(profile)
                        .build();
                service.editMember(m);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            view = "redirect:/index.jsp";
        }

        return view;
    }
}
