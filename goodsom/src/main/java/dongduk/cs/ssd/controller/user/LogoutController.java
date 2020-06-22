package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yejin Lee
 * @since 2020.05.08
 */

@Controller
public class LogoutController {
	@RequestMapping("/user/logout.do")
	public String handleRequest(HttpSession session) throws Exception {
		session.removeAttribute("userSession");
		session.invalidate();
		return "user/login";
	}
}
