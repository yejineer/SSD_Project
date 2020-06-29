package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee | Seonmi-Hwang
 * @since 2020.05.07 | 2020.06.21
 */


@Controller
public class DeleteUserController {
	
	@Autowired
	private UserService userService;
	
	@Value("user/login")
	private String formViewName;
	@Value("user/user_detail")
	private String detailViewName;
	
	private int NOT_ALLOWED = -1;
	private int FAIL = 0;
	private int SUCCESS = 1;
	
	@RequestMapping("/user/delete.do")
	public ModelAndView handleRequest(HttpSession session,
			HttpServletResponse response) throws Exception {
		//로그인한 사용자의 userId를 세션에서 가져와 deleteUser(userId)해준다.
		ModelAndView mav = new ModelAndView();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		User user = userSession.getUser();
		
		// 작성한 경매, 공동구매 중에 마감되지 않은 것이 있다면 회원탈퇴 불가
		if (userService.isUnClosedExist(user.getUserId())) {
			mav.addObject("deleteComplete", NOT_ALLOWED);
			mav.addObject("userForm", new UserForm(userService.getUserByEmail(userSession.getUser().getEmail())));
			mav.setViewName(detailViewName);
			return mav;
		} 
		
		// User 삭제
		int result = userService.deleteUser(userSession.getUser());
		
		if (result != SUCCESS) {
			mav.addObject("deleteComplete", FAIL);
			mav.setViewName(detailViewName);
		} else {
			mav.setViewName(formViewName);
			mav.addObject("loginForm", new LoginForm());
			mav.addObject("deleteComplete", SUCCESS);
			session.removeAttribute("userSession");
			session.invalidate();
		}
		return mav;
	}
	
}
