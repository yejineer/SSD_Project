package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee | Seonmi-Hwang
 * @since 2020.05.07 | 2020.06.21
 */

@Controller
public class DetailUserController {

	private static final String detailViewName = "user/user_detail";
	
	@Autowired
	UserService userService; 
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		return new UserForm(userService.getUserByEmail(userSession.getUser().getEmail()));
	}
	
	@RequestMapping("/user/detail.do")
	public String showForm() {
		return detailViewName;
	}
}
