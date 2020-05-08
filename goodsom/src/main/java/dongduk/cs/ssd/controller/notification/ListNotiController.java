package dongduk.cs.ssd.controller.notification;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.Notification;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.NotiService;

public class ListNotiController {
	
	@Autowired
	private NotiService notiService;
	public void setNotiService(NotiService notiService) {
		this.notiService = notiService;
	}
	
	/* 세션에서 로그인한 사용자 정보를 받아와 해당 사용자의 notification list들을 보여주면 된다. */
	@RequestMapping("/noti/list.do")  // ex) /user/detail.do?userId=2
	public ModelAndView handleRequest(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("userSession");
		List<Notification> notiList = notiService.getNotiListByEmailId(user.getEmailId());
		return new ModelAndView("noti_list", "notiList", notiList);
	}
}
