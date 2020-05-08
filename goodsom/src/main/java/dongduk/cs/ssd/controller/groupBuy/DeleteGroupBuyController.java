package dongduk.cs.ssd.controller.groupBuy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

@Controller
@SessionAttributes("groupBuySession")
public class DeleteGroupBuyController {

	@Autowired
	GroupBuyService groupBuyService;
	
	@RequestMapping("/groupBuy/delete.do")
	public ModelAndView groupBuyDelete(HttpServletRequest request, 
									@ModelAttribute("groupBuySession") LineGroupBuyCommand groupBuySession,
									SessionStatus status) {
		ModelAndView mav = new ModelAndView("groupBuy/groupBuy_list");
		groupBuyService.deleteGroupBuy(groupBuySession.getGroupBuyId());
		mav.addObject("groupBuy", groupBuyService.getGroupBuyList());
		status.setComplete();
		return mav;
	}
	
}
