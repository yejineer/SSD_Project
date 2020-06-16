package dongduk.cs.ssd.controller.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.GroupBuyService;
import dongduk.cs.ssd.service.OrderService;
import dongduk.cs.ssd.service.ScrapService;
import dongduk.cs.ssd.service.UserService;

/**
 * @author kimdahyee	/ Seonmi-Hwang
 * @since 05.08.2020	/ 2020.06.14
 */


@Controller
@SessionAttributes("userSession")
public class ListMypageController {
	
//	@Autowired
//	ScrapService scrapService;
	@Autowired
	UserService userService;
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/mypage/list.do")
	public ModelAndView handleRequest(
			@ModelAttribute("userSession") UserSession userSession,
			@RequestParam(required = false) Integer menuId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/mypage_list");
		int userId = userSession.getUser().getUserId();
		
		if (menuId == null) {
			menuId = 1;
		}
		mav.addObject("menuId", menuId);
		mav.addObject("groupBuyList", userService.getGroupBuyList(userId));
		mav.addObject("auctionList", userService.getAuctionList(userId));
		
//		List<Order> orderList =  userService.getOrderList(userId);
//		mav.addObject("orderList", orderService.setInfo(orderList));
		
//		mav.addObject("scrap_aList", scrapService.getScrap_aList());
//		mav.addObject("scrap_gList", scrapService.getScrap_gList());
		return mav;
	}
	

	
}
