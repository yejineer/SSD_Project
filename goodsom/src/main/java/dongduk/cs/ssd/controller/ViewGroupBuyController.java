package dongduk.cs.ssd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.GroupBuyService;

public class ViewGroupBuyController {
	@Autowired
	private GroupBuyService groupBuyService;
	
	@RequestMapping("groupBuy/detail")
	public ModelAndView groupBuyDetail(HttpServletRequest request, int groupBuyId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("groupBuy_detail");
		mav.addObject("groupBuy", groupBuyService.getGroupBuy(groupBuyId));
		return mav;
	}
	
}
