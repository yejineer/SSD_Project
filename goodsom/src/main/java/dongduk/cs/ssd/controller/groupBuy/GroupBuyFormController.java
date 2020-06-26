package dongduk.cs.ssd.controller.groupBuy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang | HK
 * @since 2020.05.06	| 2020.06.26
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
		System.out.println("reqPage: " + reqPage + ", groupBuyId: " + groupBuyId);
//		list -> form : create
		if(groupBuyId == null) { 
			return new GroupBuyForm();	
//		detail -> form :  update or show(after create) GroupBuy
		} else {
			return new GroupBuyForm(groupBuyService.getGroupBuy(Integer.valueOf(groupBuyId)));
		}
	}
	
	@RequestMapping(value="/form.do")
	public String groupBuyForm(){
		return GROUPBUY_FORM;
	}
	
	
	// form -> detail : create & update
	@RequestMapping(value= {"/create.do", "/update.do"}, method=RequestMethod.POST)
	public String updateOrSubmit(HttpServletRequest request,
			@Valid @ModelAttribute("groupBuyForm") GroupBuyForm groupBuyForm,
			BindingResult result, Model model, SessionStatus sessionStatus) {
		int groupBuyId;
		HttpSession session = request.getSession();
		UserSession user  = (UserSession)session.getAttribute("userSession");
		String reqPage = request.getServletPath();
		String requestUrl = reqPage.trim();
		
		if(result.hasErrors()) {
			if(requestUrl.equals("/groupBuy/update.do")) {
				return "redirect:form.do?groupBuyId=" + groupBuyForm.getGroupBuy().getGroupBuyId();
			}else {
				return GROUPBUY_FORM;
			}
		}

//		글 작성자, default img 세팅
		if(user.getUser().getUserId() == groupBuyForm.getGroupBuy().getUserId()) {
			model.addAttribute("isWriter", true);
		}else {
			model.addAttribute("isWriter", false);
		}
		groupBuyForm.getGroupBuy().initGroupBuy(user.getUser());
		if (groupBuyForm.getGroupBuy().getImg().trim() == "") {
			groupBuyForm.getGroupBuy().initImg(request.getContextPath());
        }

		if (reqPage.trim().equals("/groupBuy/update.do")) { 	//		update
//			db: groupBuy update & option 삭제 후, 다시 생성
			groupBuyId = groupBuyService.updateGroupBuy(groupBuyForm.getGroupBuy());
			groupBuyService.deleteOptions(groupBuyId);
			groupBuyForm.getGroupBuy().optionSetting(groupBuyId);
			groupBuyService.createOptions(groupBuyForm.getGroupBuy());
		} else { 												//		create	
//			db: groupBuy create 후, id 받아오기
			groupBuyService.createGroupBuy(groupBuyForm.getGroupBuy());
			groupBuyId = groupBuyForm.getGroupBuy().getGroupBuyId();
			
//			받아온 id와 option 파라미터를 Option객체에 세팅 후, create option
			groupBuyForm.getGroupBuy().optionSetting(groupBuyId);
			groupBuyService.createOptions(groupBuyForm.getGroupBuy());
		}
//		스케줄러 => create / update 시 endDate로 설정
		groupBuyService.deadLineScheduler(groupBuyForm.getGroupBuy().getEndDate());
		
//		detail에 필요한 파라미터 세팅
		GroupBuy groupBuy = groupBuyService.getGroupBuy(groupBuyId);
		model.addAttribute("groupBuy", groupBuy);
		model.addAttribute("writer", user.getUser().getNickname());
		model.addAttribute("dDay", groupBuy.getDday(groupBuy.getUploadDate().getTime(), groupBuy.getEndDate().getTime()));
		
		sessionStatus.setComplete();
		
		return GROUPBUY_DETAIL;
	}
		
	/*
	public void setGroupBuyService(GroupBuyService groupBuyService) {
		this.groupBuyService = groupBuyService;
	}
	*/
		
}
