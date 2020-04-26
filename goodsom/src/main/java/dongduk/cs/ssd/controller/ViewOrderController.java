package dongduk.cs.ssd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.Order;

@Controller
@SessionAttributes("userSession")
public class ViewOrderController {
//	@RequestMapping("/order/detail.do")
//	public ModelAndView handleRequest(
//			@ModelAttribute("userSession") UserSession userSession,
//			@RequestParam("orderId") int orderId
//			) throws Exception {
//		Order order = getOrder(orderId);
//		if (userSession.getUserId().equals(order.getUserId())) {
//			return new ModelAndView("ViewOrder", "order", order);
//		}
//		else {
//			return new ModelAndView("Error", "message", "You may only view your own orders.");
//		}
//	}
}
