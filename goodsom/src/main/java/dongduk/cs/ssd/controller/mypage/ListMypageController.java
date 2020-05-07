package dongduk.cs.ssd.controller.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.service.ScrapService;

/**
 * @author kimdahyee
 * @since 05.08.2020
 */

@Controller
@SessionAttributes("userSession")
public class ListMypageController {
	
	@Autowired
	ScrapService scrapService;
	
	@RequestMapping("/mypage/list.do")
	public ModelAndView handleRequest(
			@ModelAttribute("userSession") UserSession userSession) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/mypage_list");
		mav.addObject("scrap_aList", scrapService.getScrap_aList());
		mav.addObject("scrap_gList", scrapService.getScrap_gList());
		return mav;
	}
}
