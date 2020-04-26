package dongduk.cs.ssd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class OrderController {
//
//	@ModelAttribute("orderForm")
//	public OrderForm createOrderForm() {
//		return new OrderForm();
//	}
//	
//	@ModelAttribute("creditCardTypes")
//	public List<String> referenceData() {
//		ArrayList<String> creditCardTypes = new ArrayList<String>();
//		creditCardTypes.add("Visa");
//		creditCardTypes.add("MasterCard");
//		creditCardTypes.add("American Express");
//		return creditCardTypes;			
//	}
//	
//	@RequestMapping("/shop/newOrder.do")
//	public String initNewOrder(HttpServletRequest request,
//			@ModelAttribute("sessionCart") Cart cart,
//			@ModelAttribute("orderForm") OrderForm orderForm
//			) throws ModelAndViewDefiningException {
//		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
//		if (cart != null) {
//			// Re-read account from DB at team's request.
//			Account account = petStore.getAccount(userSession.getAccount().getUsername());
//			orderForm.getOrder().initOrder(account, cart);
//			return "NewOrderForm";	
//		}
//		else {
//			ModelAndView modelAndView = new ModelAndView("Error");
//			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
//			throw new ModelAndViewDefiningException(modelAndView);
//		}
//	}
}
