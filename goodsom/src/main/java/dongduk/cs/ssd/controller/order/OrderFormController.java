package dongduk.cs.ssd.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import dongduk.cs.ssd.controller.groupBuy.LineGroupBuyCommand;
import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.OrderService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */

/*
@Controller
@SessionAttributes({"userSession", "groupBuySession"})
@RequestMapping("/order/create.do")
*/
public class OrderFormController {
	/*
	@Autowired
	private OrderService orderService;
	
	@ModelAttribute("orderForm")
	public OrderForm formBacking(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return new OrderForm();
		} else {
			int orderId = (int)request.getAttribute("orderId");
			return new OrderForm(orderService.getOrder(orderId));
		}
	}
	
	@ModelAttribute("cardBanks")
	public List<String> referenceData() {
		ArrayList<String> cardBanks = new ArrayList<String>();
		cardBanks.add("신한");
		cardBanks.add("하나");
		cardBanks.add("우리");
		cardBanks.add("농협");
		cardBanks.add("국민"); 
		// add more
		return cardBanks;			
	}
	
	@RequestMapping(method = RequestMethod.GET) // form 출력
	public String form(HttpServletRequest request,
			@ModelAttribute("groupBuySession") LineGroupBuyCommand groupBuySession,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		User user = userSession.getUser();
		Object auctionIdObj = request.getAttribute("auctionId");
		
		if (groupBuySession != null) { // groupBuy에서 결제하는 경우
			// Re-read account from DB at team's request.
			// User user = orderService.getUser(userSession.getUser().getUserId());
			orderForm.getOrder().initOrder(user, groupBuySession, null);
			return "order/order_create";
		} else if (auctionIdObj != null) { 
			orderForm.getOrder().initOrder(user, null, orderService.getAuction((int)auctionIdObj));
			return "order/order_create";
		} else { // 선택한 상품이 없을 경우
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because products could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST) // 결과 출력
	protected ModelAndView submit(
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status) {
		orderService.createOrder(orderForm.getOrder());
		ModelAndView mav = new ModelAndView("payment_detail");
		mav.addObject("order", orderForm.getOrder());
//		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionLineGroupBuy and orderForm from session
		return mav;
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	*/
}
