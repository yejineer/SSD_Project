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
import dongduk.cs.ssd.service.OrderService;
import dongduk.cs.ssd.service.UserService;

/**
 * @author kimdahyee | Seonmi-Hwang
 * @since 05.08.2020 | 2020.06.14
 */


@Controller
@SessionAttributes("userSession")
public class ListMypageController {
	
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
		
//		경매 등록 목록
		mav.addObject("auctionList", userService.getAuctionList(userId));
//		공동구매 등록 목록
		mav.addObject("groupBuyList", userService.getGroupBuyList(userId));
		
		List<Order> auctionOrderList =  userService.getAuctionOrderList(userId);
		List<Order> groupBuyOrderList =  userService.getGroupBuyOrderList(userId);
		
		mav.addObject("auctionOrderList", orderService.setAuctionInfo(auctionOrderList));
		mav.addObject("groupBuyOrderList", orderService.setGroupBuyInfo(groupBuyOrderList));
		
		return mav;
	}
	
}
