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
//@SessionAttributes("groupBuySession")
@SessionAttributes("groupBuyForm")
@RequestMapping("/groupBuy")
public class GroupBuyFormController {
	
	private static final String GROUPBUY_FORM = "groupBuy/groupBuy_form";
	private static final String GROUPBUY_DETAIL = "groupBuy/groupBuy_detail";
	
	@Autowired
	private GroupBuyService groupBuyService;

	@ModelAttribute("groupBuyForm")
	public GroupBuyForm formBacking(HttpServletRequest request,
									@ModelAttribute("groupBuySession") LineGroupBuyForm groupBuySession,
									Model model) // 없으면 null?
			throws Exception {
		String reqPage = request.getServletPath();
		String groupBuyId = request.getParameter("groupBuyId");
		System.out.println("reqPage: " + reqPage);
		
//		list -> form : create
		if(groupBuyId == null) { 
			GroupBuyForm groupBuyForm = new GroupBuyForm();
//			newGroupBuy 이용
			model.addAttribute("createGroupBuy", groupBuyForm.getNewGroupBuy());
			return groupBuyForm;
			
//		detail -> form :  update or show(after create) GroupBuy
		} else {
			GroupBuyForm groupBuyForm = new GroupBuyForm(groupBuyService.getGroupBuy(Integer.valueOf(groupBuyId)));
			model.addAttribute("createGroupBuy", groupBuyForm.getNewGroupBuy());
			return groupBuyForm;
		}
	}

	
	/*
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return GROUPBUY_FORM;
	}
	*/
	
	@RequestMapping(value="/form.do")
	public String groupBuyForm(){
		return GROUPBUY_FORM;
	}
	
	
	// form -> detail : create & update
	@RequestMapping(value= {"/create.do", "/update.do"}, method=RequestMethod.POST)
	public String updateOrSubmit(HttpServletRequest request,
								@ModelAttribute("groupBuyForm") GroupBuyForm groupBuyForm, 
								Model model) {
		
		HttpSession session = request.getSession();
		UserSession user  = (UserSession)session.getAttribute("userSession");
		
		String reqPage = request.getServletPath();
		int groupBuyId;
		
		if(user.getUser().getUserId() == groupBuyForm.getGroupBuy().getUserId()) {
			model.addAttribute("isWriter", true);
		}else {
			model.addAttribute("isWriter", false);
		}
		groupBuyForm.getGroupBuy().initGroupBuy(user.getUser());
		if (groupBuyForm.getGroupBuy().getImg().trim() == "") {
			groupBuyForm.getGroupBuy().initImg(request.getContextPath());
        }
		
//		update
		if (reqPage.trim().equals("/groupBuy/update.do")) {
			// db
			System.out.println("before: " + groupBuyForm.getGroupBuy().toString());
			
			groupBuyId = groupBuyService.updateGroupBuy(groupBuyForm.getGroupBuy());
			groupBuyService.deleteOptions(groupBuyId);
			groupBuyForm.getGroupBuy().optionSetting(groupBuyId);
			System.out.println("after: " + groupBuyForm.getGroupBuy().toString());
			groupBuyService.createOptions(groupBuyForm.getGroupBuy());
			
//		create	
		} else {
			// db
			groupBuyService.createGroupBuy(groupBuyForm.getGroupBuy());
			
			groupBuyId = groupBuyForm.getGroupBuy().getGroupBuyId();
			
			groupBuyForm.getGroupBuy().optionSetting(groupBuyId);
			groupBuyService.createOptions(groupBuyForm.getGroupBuy());
			
		}
		GroupBuy groupBuy = groupBuyService.getGroupBuy(groupBuyId);
		model.addAttribute("groupBuy", groupBuy);
		model.addAttribute("writer", user.getUser().getNickname());
		
		// D-day 계산: 더 좋은 위치 없나..
		long timeLength = groupBuy.getEndDate().getTime() - groupBuy.getUploadDate().getTime();
		long dDay = timeLength / ( 24*60*60*1000); 
		dDay = Math.abs(dDay);
		model.addAttribute("dDay", dDay);
		return GROUPBUY_DETAIL;
	}
		
	/*
	public void setGroupBuyService(GroupBuyService groupBuyService) {
		this.groupBuyService = groupBuyService;
	}
	*/
		
}
