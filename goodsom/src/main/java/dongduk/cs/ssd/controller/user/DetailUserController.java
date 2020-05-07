package dongduk.cs.ssd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee
 * @since 2020.05.07
 */
@Controller
@SessionAttributes("userSession")
public class DetailUserController {
	
//	private UserService userService;
//	
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//	
	/* 세션에서 로그인한 사용자를 user_detail로 보내주면 된다. */
	@RequestMapping("/user/detail.do")  // ex) /user/detail.do?userId=2
	public ModelAndView handleRequest(
			@ModelAttribute("userSession") UserSession userSession) throws Exception {
		User user = userSession.getUser();
		return new ModelAndView("user_detail", "user", user);
	}
}
