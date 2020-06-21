package dongduk.cs.ssd.controller.groupBuy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

/**
 * @author HK
 * @since 2020.06.12
 */



@Controller
/*
@SessionAttributes("groupBuySession")
@RequestMapping({"/groupBuy/create.do", "/groupBuy/update.do"})
*/
@RequestMapping("/groupBuy")
public class GroupBuyFormController {
	
	private static final String GROUPBUY_LIST = "groupBuy/groupBuy_list";
	private static final String GROUPBUY_FORM = "groupBuy/groupBuy_form";
	private static final String GROUPBUY_DETAIL = "groupBuy/groupBuy_detail";
	
	
	@Autowired
	private GroupBuyService groupBuyService;
	/*
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
	
	
	@RequestMapping(value="/form.do")
	public String groupBuyForm(){
		return GROUPBUY_FORM;
	}
	
	
	
	@RequestMapping(value="/detail.do", method={RequestMethod.GET, RequestMethod.POST})
	public String updateOrSubmit(HttpServletRequest request,
								@ModelAttribute("groupBuyForm") GroupBuyForm groupBuyForm, 
								Model model) {
		
		HttpSession session = request.getSession();
		UserSession user  = (UserSession)session.getAttribute("userSession");
		
		String reqPage = request.getServletPath();
		
		if (reqPage.trim().equals("groupBuy_form")) { // update
			groupBuyService.updateGroupBuy(groupBuyForm.getGroupBuy());
			return GROUPBUY_FORM;
		} else { // show after create

			groupBuyForm.getGroupBuy().initGroupBuy(user.getUser());
			if (groupBuyForm.getGroupBuy().getImg().trim() == "") {
				groupBuyForm.getGroupBuy().initImg(request.getContextPath());
            }
			
			groupBuyService.createGroupBuy(groupBuyForm.getGroupBuy());
			groupBuyService.createOptions(groupBuyForm.getGroupBuy());
			
			int groupBuyId = groupBuyForm.getGroupBuy().getGroupBuyId();
			GroupBuy groupBuy = groupBuyService.getGroupBuy(groupBuyId);
			model.addAttribute("groupBuy", groupBuy);
			model.addAttribute("writer", user.getUser().getNickname());
			
			long timeLength = groupBuy.getEndDate().getTime() - groupBuy.getUploadDate().getTime();
			long dDay = timeLength / ( 24*60*60*1000); 
			dDay = Math.abs(dDay);
			model.addAttribute("dDay", dDay);
	       

			
			return GROUPBUY_DETAIL;
		}
	}
	
	/*
	public void setGroupBuyService(GroupBuyService groupBuyService) {
		this.groupBuyService = groupBuyService;
	}
	*/

}
