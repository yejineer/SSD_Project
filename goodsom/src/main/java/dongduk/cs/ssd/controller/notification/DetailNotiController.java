package dongduk.cs.ssd.controller.notification;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.User;

public class DetailNotiController {
	/* 세션에서 로그인한 사용자 정보를 받아와 해당 사용자의 user_detail로 보내주면 된다. */
	@RequestMapping("/user/detail.do")  // ex) /user/detail.do?userId=2
	public ModelAndView handleRequest(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("userSession");
		return new ModelAndView("user_detail", "user", user);
	}
}
