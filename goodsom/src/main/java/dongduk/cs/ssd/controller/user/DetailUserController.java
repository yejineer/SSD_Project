package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.User;

/**
 * @author Yejin Lee
 * @since 2020.05.07
 */
//@Controller
public class DetailUserController {
	
	/*
	// 세션에서 로그인한 사용자를 user_detail로 보내주면 된다. 
	@RequestMapping("/user/detail.do")  // ex) /user/detail.do?userId=2
	public ModelAndView handleRequest(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("userSession");
		return new ModelAndView("user_detail", "user", user);
	}
	*/
}
