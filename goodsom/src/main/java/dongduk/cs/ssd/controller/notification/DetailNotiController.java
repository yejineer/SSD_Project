package dongduk.cs.ssd.controller.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.Notification;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.NotiService;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee | HK
 * @since 2020.05.07 | 2020.06.29
 */
@Controller
public class DetailNotiController {
	
	@Value("user/noti_detail")
	private String formViewName;
	
	@Autowired
	NotiService notiService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/noti/detail.do")
	public ModelAndView handleRequest(@RequestParam("notiId") int notiId) throws Exception {
		Notification noti = notiService.getNoti(notiId);
		int userId = notiService.getNoti(notiId).getUserId();
		User user = userService.getUserByUserId(userId);
		ModelAndView mov = new ModelAndView();
		mov.addObject("nickname", user.getNickname());
		mov.addObject("message", "참여한 경매가 낙찰되었습니다. 결제를 진행해주세요!");
		mov.addObject("noti", noti);
		mov.setViewName(formViewName);
		
		return mov;
	}
}
