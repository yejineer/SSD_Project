package dongduk.cs.ssd.controller.notification;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Notification;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.NotiService;

/**
 * @author Yejin Lee | HK
 * @since 2020.05.07 | 2020.06.29
 */
@Controller
public class DeleteNotiController {
	
	@Value("user/noti_list")
	private String formViewName;
	
	@Autowired
	NotiService notiService;
	
	@RequestMapping("/noti/delete.do")
	public ModelAndView handleRequest(HttpSession session,
			@RequestParam("notiId") int notiId) throws Exception {
		UserSession userSession  = (UserSession)session.getAttribute("userSession");
		User user = userSession.getUser();
		
		notiService.deleteNoti(notiId);
		List<Notification> userNotiList = notiService.getNotiByUserId(user.getUserId());
		
		ModelAndView mov = new ModelAndView();
		mov.addObject("nickname", user.getNickname());
		mov.addObject("message", "참여한 경매가 낙찰되었습니다. 결제를 진행해주세요!");
		mov.addObject("userNotiList", userNotiList);
		mov.setViewName(formViewName);
		
		return mov;
	}
	
}
