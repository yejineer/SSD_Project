package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee
 * @since 2020.05.07
 */
@Controller
@SessionAttributes("userSession")
public class DeleteUserController {

	//@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/user/delete.do")
	public String handleRequest(HttpSession session) throws Exception {
		/* 로그인한 사용자의 userId를 세션에서 가져와 deleteUser(userId)해준다. */
		User user = (User) session.getAttribute("userSession");
		userService.deleteUser(user.getEmailId());
		session.removeAttribute("userSession");
		session.invalidate();
		return "login";
	}
}
