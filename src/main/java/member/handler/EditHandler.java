package member.handler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import handler.Handler;
import lombok.extern.slf4j.Slf4j;
import member.Member;
import member.MemberService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Slf4j
public class EditHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        // FIX Auto-generated method stub
        ServletContext context = request.getServletContext();
        String path = context.getRealPath("/images/profile/");

        System.out.println("path = " + path);

        File directory = new File(path);
        if (!directory.exists()){
            directory.mkdirs();
        }

        String view = "/index.jsp";

        MemberService service = new MemberService();
        if (request.getMethod().equals("GET")) {
            String loginId = request.getParameter("loginId");
            log.info("loginId : {}", loginId);
            Member m = service.getMember(loginId);
            log.info("member : {}", m);
            request.setAttribute("m", m);
            request.setAttribute("view", "/member/edit.jsp");
        } else {
            try {

                MultipartRequest req = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
                File f = req.getFile("profile");
                String nickname = req.getParameter("nickname");
                String loginId = req.getParameter("loginId");
                log.info("nickname: {}",nickname);
                log.info("loginId: {}",loginId);

                String profile;//업로드된 파일의 파일명을 저장할 배열
                if (f != null && f.length() != 0) {
                    profile = f.getName();
                    log.info("profile: {}",profile);
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
                } else {
                    Member m = Member.builder()
                            .memberId(0)
                            .loginId(loginId)
                            .nickname(nickname)
                            .email("")
                            .password("")
                            .birthday(null)
                            .gender(0)
                            .build();
                    service.editMember2(m);
                    view = "redirect:/member/mypage.do?loginId="+loginId;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return view;
    }
}
