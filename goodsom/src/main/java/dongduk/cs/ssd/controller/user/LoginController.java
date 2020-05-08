package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee
 * @since 2020.05.08
 */
@Controller
public class LoginController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/user/login.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpSession session,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) throws Exception {
		User user = userService.getUser(email, password); // 로그인 시도
		if (user == null) { // 해당 email과 password를 갖는 사용자가 존재하지 않을 시
			return new ModelAndView("Error", "message", "Invalid email or password. Login failed.");
		} else { // 로그인 성공 시
			UserSession userSession = new UserSession(user);
			session.setAttribute("userSession", userSession);
			return new ModelAndView("home");
		}
	}
}
