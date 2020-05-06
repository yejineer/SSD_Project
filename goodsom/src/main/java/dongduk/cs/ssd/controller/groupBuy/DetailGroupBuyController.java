package dongduk.cs.ssd.controller.groupBuy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */

@Controller
public class DetailGroupBuyController {
	@Autowired
	GroupBuyService groupBuyService;
	
	@RequestMapping("/groupBuy/detail.do")
	public ModelAndView groupBuyDetail(HttpServletRequest request, 
									@RequestParam("groupBuyId") int groupBuyId,
									@ModelAttribute("sessionLineGroupBuy") GroupBuyForm groupBuyForm) {
		ModelAndView mav = new ModelAndView("groupBuy/groupBuy_detail");
		mav.addObject("groupBuy", groupBuyService.getGroupBuy(groupBuyId));
		return mav;
	}
}
