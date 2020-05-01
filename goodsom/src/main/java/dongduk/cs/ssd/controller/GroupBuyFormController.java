package dongduk.cs.ssd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.01
 */

@Controller
@SessionAttributes("sessionLineGroupBuy")
public class GroupBuyFormController {
	
	@Autowired
	private GroupBuyService groupBuyService;
	
	private final String formViewName = "groupBuy/form";
	private final String detailViewName = "groupBuy/detail";
	
	@RequestMapping("/groupBuy/detail.do")
	public ModelAndView groupBuyDetail(HttpServletRequest request, 
									@RequestParam("groupBuyId") int groupBuyId,
									@ModelAttribute("sessionLineGroupBuy") GroupBuyForm groupBuyForm) {
		return new ModelAndView();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@ModelAttribute
	public GroupBuyForm formBacking() {
		return new GroupBuyForm();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(GroupBuyForm groupBuyForm) {
		// log 표시해줄거면 추가
		return detailViewName;
	}
	
	public void setGroupBuyService(GroupBuyService groupBuyService) {
		this.groupBuyService = groupBuyService;
	}
	

}
