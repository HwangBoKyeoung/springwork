package co.micol.prj.user.serviceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class)
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
//		로그인 이후 추가적으로 처리할 내용
		log.debug("로그인 완료");
		System.out.println("로그인 완료");
		response.sendRedirect("top.jsp");
	}
	
}
