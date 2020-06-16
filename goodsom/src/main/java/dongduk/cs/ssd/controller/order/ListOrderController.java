package dongduk.cs.ssd.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.service.OrderService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */


@Controller
@SessionAttributes("userSession")
public class ListOrderController {
	
//	@Autowired
//	OrderService orderService;
//	
//	@RequestMapping("/order/list.do")
//	public ModelAndView handleRequest(
//			@ModelAttribute("userSession") UserSession userSession) {
//		ModelAndView mav = new ModelAndView("order/payment_list");
//		mav.addObject("orderList", orderService.getOrderList(userSession.getUser().getUserId()));
//		return mav;
//	}
}
