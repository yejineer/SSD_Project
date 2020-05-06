package dongduk.cs.ssd.controller.groupBuy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

@Controller
@SessionAttributes("sessionLineGroupBuy")
@RequestMapping({"/groupBuy/create.do", "/groupBuy/detail.do"})
public class GroupBuyFormController {
	
	@Autowired
	private GroupBuyService groupBuyService;
	
	private final String formViewName = "groupBuy/groupBuy_form";
	private final String detailViewName = "groupBuy/groupBuy_detail";

	@ModelAttribute("groupBuyForm")
	public GroupBuyForm formBacking(HttpServletRequest request) 
			throws Exception {
		String reqPage = request.getServletPath();

		if (reqPage.trim().equals("/groupBuy_form") && request.getMethod().equals("GET")) {
			return new GroupBuyForm(); // create a new GroupBuy
		} else { // update or show GroupBuy
			int groupBuyId = (int)request.getAttribute("groupBuyId");
			return new GroupBuyForm(groupBuyService.getGroupBuy(groupBuyId));
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request,
			@ModelAttribute("sessionLineGroupBuy") LineGroupBuyCommand lineGroupBuyCommand) 
			throws Exception {
		ModelAndView mav = new ModelAndView();
		String reqPage = request.getServletPath();
		
		if (reqPage.trim().equals("/groupBuy_form")) {
			mav.setViewName(formViewName);
			return mav;
		} else {
			mav.addObject("lineGroupBuyCommand", lineGroupBuyCommand);
			mav.setViewName(detailViewName);
			return mav;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(GroupBuyForm groupBuyForm) {
		// log 표시해줄거면 추가
		return formViewName;
	}
	
	public void setGroupBuyService(GroupBuyService groupBuyService) {
		this.groupBuyService = groupBuyService;
	}
	

}
