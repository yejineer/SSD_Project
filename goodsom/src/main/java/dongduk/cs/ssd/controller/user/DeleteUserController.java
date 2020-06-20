package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee	/ Seonmi-Hwang
 * @since 2020.05.07	/ 2020.06.21
 */


@Controller
@SessionAttributes("userSession")
public class DeleteUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/delete.do")
	public ModelAndView handleRequest(HttpSession session,
			HttpServletResponse response,
			@ModelAttribute("userSession") UserSession userSession) throws Exception {
		//로그인한 사용자의 userId를 세션에서 가져와 deleteUser(userId)해준다.
		ModelAndView mav = new ModelAndView("user/login");
		mav.addObject("deleteComplete", userService.deleteUser(userSession.getUser().getUserId()));
		session.removeAttribute("userSession");
		session.invalidate();
		return mav;
	}
	
}
