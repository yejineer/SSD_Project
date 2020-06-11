package dongduk.cs.ssd.controller.groupBuy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

/**
 * @author HK
 * @since 2020.06.12
 */


/*
@Controller
@SessionAttributes("groupBuySession")
@RequestMapping({"/groupBuy/create.do", "/groupBuy/update.do"})
*/
@RequestMapping("/groupBuy")
public class GroupBuyFormController {
	
	private static final String GROUPBUY_LIST = "groupBuy/groupBuy_list";

	/*
	@Autowired
	private GroupBuyService groupBuyService;
	
	private final String formViewName = "groupBuy/groupBuy_form";
	private final String detailViewName = "groupBuy/groupBuy_detail";

	@ModelAttribute("groupBuyForm")
	public GroupBuyForm formBacking(HttpServletRequest request,
									@ModelAttribute("groupBuySession") LineGroupBuyCommand groupBuySession) // 없으면 null?
			throws Exception {
		String reqPage = request.getServletPath();

		if (reqPage.trim().equals("/groupBuy_form") && request.getMethod().equals("GET")) { // create
			return new GroupBuyForm(); // create a new GroupBuy
		} else { // update or show(after create) GroupBuy
			return new GroupBuyForm(groupBuyService.getGroupBuy(groupBuySession.getGroupBuyId()));
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	*/
	
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String groupBuyList(){
		return GROUPBUY_LIST;
	}
	
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	public String updateOrSubmit(HttpServletRequest request,
						GroupBuyForm groupBuyForm) {
		String reqPage = request.getServletPath();
		
		if (reqPage.trim().equals("groupBuy_form")) { // update
			groupBuyService.updateGroupBuy(groupBuyForm.getGroupBuy());
			return formViewName;
		} else { // show after create
			groupBuyService.createGroupBuy(groupBuyForm.getGroupBuy());
			return detailViewName;
		}
	}
	
	public void setGroupBuyService(GroupBuyService groupBuyService) {
		this.groupBuyService = groupBuyService;
	}
	*/

}
