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
	public ModelAndView handleRequest(@RequestParam("notiId") int notiId,
			@RequestParam("type") int type, 
			@RequestParam("content") String content) throws Exception {
		
		ModelAndView mov = new ModelAndView();
		Notification noti;
		int userId;
		User user;
		if(type == 1) {
			noti = notiService.getAuctionNoti(notiId);
			userId = noti.getUserId();
			user = userService.getUserByUserId(userId);
			
		}else {
			noti = notiService.getGroupBuyNoti(notiId);
			userId = noti.getUserId();
			user = userService.getUserByUserId(userId);
		}
		System.out.println("type: " + type);
		mov.addObject("nickname", user.getNickname());
		mov.addObject("noti", noti);
		mov.addObject("content", content);
		mov.addObject("type", type);
		mov.setViewName(formViewName);
		
		return mov;
	}
}
