package dongduk.cs.ssd.controller.notification;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.Notification;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.NotiService;

/**
 * @author Yejin Lee
 * @since 2020.05.07
 */
//@Controller
public class DeleteNotiController {
	
	/*
	@Autowired
	NotiService notiService;
	
	@RequestMapping("/noti/delete.do")
	public ModelAndView handleRequest(HttpSession session,
			@RequestParam("notiId") int notiId
			) throws Exception {
		notiService.deleteNoti(notiId);
		User user = (User) session.getAttribute("userSession");
		List<Notification> notiList = notiService.getNotiListByEmailId(user.getEmailId());
		return new ModelAndView("noti_list", "notiList", notiList);
	}
	
	*/
}
