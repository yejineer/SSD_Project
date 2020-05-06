package dongduk.cs.ssd.controller.groupBuy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

@Controller
public class DeleteGroupBuyController {

	@Autowired
	GroupBuyService groupBuyService;
	
	@RequestMapping("/groupBuy/delete.do")
	public ModelAndView groupBuyDelete(HttpServletRequest request, 
									@RequestParam("groupBuyId") int groupBuyId) {
		ModelAndView mav = new ModelAndView("groupBuy/groupBuy_list");
		groupBuyService.deleteGroupBuy(groupBuyId);
		mav.addObject("groupBuy", groupBuyService.getGroupBuyList());
		return mav;
	}
	
	
}
