package dongduk.cs.ssd.controller.order;

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

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */

@Controller
@SessionAttributes("userSession")
public class DetailOrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/groupBuy/detail.do")
	public ModelAndView groupBuyHandleRequest(
			@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId
			) throws Exception {
		// UserSession의 userId와 orderId에 해당하는 Order의 userId가 같은지 판단하는 코드 추가
			ModelAndView mav = new ModelAndView("order/payment_detail");
			Order order = orderService.getOrderWithLineGroupBuys(orderId);
			
			// 공동구매
			order.setGroupBuy(orderService.getGroupBuy(orderId));
			
			mav.addObject("order", order);
			return mav;
	}
	
	@RequestMapping("/order/auction/detail.do")
	public ModelAndView auctionHandleRequest(
			@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId
			) throws Exception {
		// UserSession의 userId와 orderId에 해당하는 Order의 userId가 같은지 판단하는 코드 추가
			ModelAndView mav = new ModelAndView("order/payment_detail");
			Order order = orderService.getOrder(orderId);

			// 경매
			order.setAuction(orderService.getAuction(orderId));
			
			mav.addObject("order", order);
			return mav;
	}
	
}
