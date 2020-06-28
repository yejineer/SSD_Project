package dongduk.cs.ssd.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import dongduk.cs.ssd.controller.groupBuy.LineGroupBuyForm;
import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.OrderService;
import dongduk.cs.ssd.validator.OrderFormValidator;

/**
 * @author Seonmi Hwang	| HK
 * @since 2020.05.04	| 2020.06.26
 */


@Controller
@SessionAttributes({"lineGroupBuyForm", "orderForm"})
public class OrderFormController {
	
	@Autowired
	private OrderService orderService;

	private int FAIL = 0;
	
	@ModelAttribute("orderForm")
	public OrderForm formBacking(HttpServletRequest request) {
		return new OrderForm();
	}
	
	@ModelAttribute("cardBanks")
	public List<String> cardBanksData() {
		ArrayList<String> cardBanks = new ArrayList<String>();
		cardBanks.add("신한");
		cardBanks.add("하나");
		cardBanks.add("우리");
		cardBanks.add("농협");
		cardBanks.add("국민"); 
		// add more
		return cardBanks;			
	}
	
	@RequestMapping(value = "/order/groupBuy/create.do", method = RequestMethod.GET) // form 출력
	public ModelAndView groupBuyOrderForm(HttpServletRequest request,
			@ModelAttribute("lineGroupBuyForm") LineGroupBuyForm lineGroupBuyForm,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		ModelAndView mav = new ModelAndView("order/order_create");
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		User user = userSession.getUser();

		orderForm.getOrder().initOrder(user, lineGroupBuyForm, null);
		return mav;
	}
	
	@RequestMapping(value = "/order/groupBuy/create.do", method = RequestMethod.POST) // 결과 출력
	protected ModelAndView groupBuyOrderSubmit(
			@ModelAttribute("orderForm") OrderForm orderForm,
			BindingResult bindingResult,
			SessionStatus status) {
		System.out.println("command 객체: " + orderForm);
		new OrderFormValidator().validate(orderForm, bindingResult);
		
		// 검증 오류 발생 시 다시 form view로 이동
		if (bindingResult.hasErrors()) {
			return new ModelAndView("order/order_create");
		}

		int totalQuantity = orderForm.getOrder().getTotalQuantity();
		orderForm.getOrder().getGroupBuy().orderSet(totalQuantity);
		
		int orderSuccess = orderService.createOrder(orderForm.getOrder());
		
		ModelAndView mav = new ModelAndView("order/payment_detail");
		mav.addObject("order", orderForm.getOrder());
		
		if (orderSuccess == FAIL) {
			mav.addObject("message", "결제에 실패했습니다.");
		} else {
			mav.addObject("message", "결제가 성공적으로 완료되었습니다.");
		}
		status.setComplete();  // remove sessionLineGroupBuy and orderForm from session
		return mav;
	}
	
	
//	@RequestMapping(value = "/order/auction/create.do", method = RequestMethod.GET) // form 출력
//	public String auctionOrderForm(HttpServletRequest request,
//			@ModelAttribute("groupBuySession") LineGroupBuyCommand groupBuySession,
//			@ModelAttribute("orderForm") OrderForm orderForm
//			) throws ModelAndViewDefiningException {
//		
//		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
//		User user = userSession.getUser();
//		Object auctionIdObj = request.getAttribute("auctionId");
//		
//		if (groupBuySession != null) { // groupBuy에서 결제하는 경우
//			// Re-read account from DB at team's request.
//			// User user = orderService.getUser(userSession.getUser().getUserId());
//			orderForm.getOrder().initOrder(user, groupBuySession, null);
//			return "order/order_create";
//		} else if (auctionIdObj != null) { 
//			orderForm.getOrder().initOrder(user, null, orderService.getAuction((int)auctionIdObj));
//			return "order/order_create";
//		} else { // 선택한 상품이 없을 경우
//			ModelAndView modelAndView = new ModelAndView("Error");
//			modelAndView.addObject("message", "An order could not be created because products could not be found.");
//			throw new ModelAndViewDefiningException(modelAndView);
//		}
//	}
//	
//	@RequestMapping(value = "/order/auction/create.do", method = RequestMethod.POST) // 결과 출력
//	protected ModelAndView auctionOrderSubmit(
//			@ModelAttribute("orderForm") OrderForm orderForm, 
//			SessionStatus status) {
//		orderService.createOrder(orderForm.getOrder());
//		ModelAndView mav = new ModelAndView("payment_detail");
//		mav.addObject("order", orderForm.getOrder());
////		mav.addObject("message", "Thank you, your order has been submitted.");
//		status.setComplete();  // remove sessionLineGroupBuy and orderForm from session
//		return mav;
//	}
	
}
