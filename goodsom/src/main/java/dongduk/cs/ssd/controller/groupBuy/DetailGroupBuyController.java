package dongduk.cs.ssd.controller.groupBuy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailGroupBuyController {
	
	@RequestMapping("/groupBuy/detail.do")
	public ModelAndView groupBuyDetail(HttpServletRequest request, 
									@RequestParam("groupBuyId") int groupBuyId,
									@ModelAttribute("sessionLineGroupBuy") GroupBuyForm groupBuyForm) {
		return new ModelAndView();
	}
}
