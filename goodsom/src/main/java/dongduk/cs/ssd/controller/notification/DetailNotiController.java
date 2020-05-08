package dongduk.cs.ssd.controller.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.NotiService;

/**
 * @author Yejin Lee
 * @since 2020.05.07
 */
@Controller
public class DetailNotiController {
	@Autowired
	NotiService notiService;
	
	@RequestMapping("/noti/detail.do")
	public ModelAndView handleRequest(
			@RequestParam("notiId") int notiId
			) throws Exception {
			return new ModelAndView("noti_detail", "noti", notiService.getNoti(notiId));
	}
}
