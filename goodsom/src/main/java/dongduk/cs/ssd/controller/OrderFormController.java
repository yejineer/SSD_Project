package dongduk.cs.ssd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Seonmi Hwang
 * @since 2020.05.01
 */

@Controller
@SessionAttributes({"userSession", "sessionLineGroupBuy", })
public class OrderFormController {

	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		return new OrderForm();
	}
	
	
	@ModelAttribute("cardBanks")
	public List<String> referenceData() {
		ArrayList<String> cardBanks = new ArrayList<String>();
		cardBanks.add("신한");
		cardBanks.add("하나");
		cardBanks.add("우리");
		cardBanks.add("농협");
		cardBanks.add("국민");
		return cardBanks;			
	}
//	
//	@RequestMapping("/order/create.do")
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
