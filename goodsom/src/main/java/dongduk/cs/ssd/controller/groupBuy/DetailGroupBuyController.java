package dongduk.cs.ssd.controller.groupBuy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.service.GroupBuyService;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */
/**
 * @author HK
 * @since 2020.06.22
 */

@Controller
@SessionAttributes("lineGroupBuyForm")
public class DetailGroupBuyController {
	private static final String GROUPBUY_LIST = "groupBuy/groupBuy_list";
	private static final String GROUPBUY_DETAIL = "groupBuy/groupBuy_detail";
	
	@Autowired
	GroupBuyService groupBuyService;
	@Autowired
	UserService userService;

	// home -> list
	// form -> list : 이 경우, 생성됐던 객체를 없애야함
	@RequestMapping("/groupBuy/list.do")
	public ModelAndView groupBuyDetail(HttpServletRequest request){
		HttpSession session = request.getSession();
		GroupBuyForm groupBuyForm  = (GroupBuyForm)session.getAttribute("groupBuyForm");
		
		if(groupBuyForm != null) {
			System.out.println("groupBuyForm: " + groupBuyForm.toString());
			groupBuyForm = null;
		}
		
		ModelAndView mav = new ModelAndView(GROUPBUY_LIST);
		List<GroupBuy> groupBuyList = null;
		
		// db
		groupBuyList = groupBuyService.getGroupBuyList();
		
		if (groupBuyList == null) {
			System.out.println("[DetailGroupBuyController] groupBuyList가 null");
		} else {
			mav.addObject("groupBuyList", groupBuyList);		
		}
		return mav;
	}
	
	// list -> detail
	@RequestMapping("/groupBuy/detail.do")
	public ModelAndView groupBuyDetail(HttpServletRequest request,
										@RequestParam("groupBuyId") int groupBuyId,
										Model model)	{
		ModelAndView mav = new ModelAndView(GROUPBUY_DETAIL);
		HttpSession session = request.getSession();
		UserSession user  = (UserSession)session.getAttribute("userSession");
		
		// db : option & groupBuy
		GroupBuy groupBuy = groupBuyService.getGroupBuy(groupBuyId);
		
		if (user.getUser().getUserId() == groupBuy.getUserId()) {
			model.addAttribute("isWriter", true);
		} else {
			model.addAttribute("isWriter", false);
		}
		
		// LineGroupBuyForm 생성 및 넘겨주기
		LineGroupBuyForm lineGroupBuyForm = new LineGroupBuyForm();
		lineGroupBuyForm.setGroupBuyId(groupBuyId);
		lineGroupBuyForm.setGroupBuy(groupBuy);
		session.setAttribute("lineGroupBuyForm", lineGroupBuyForm);
		mav.addObject("lineGroupBuyForm", lineGroupBuyForm);
		
		mav.addObject("groupBuy", groupBuy);
		mav.addObject("writer", userService.getUserByUserId(groupBuy.getUserId()).getNickname());
		return mav;
	}
	
}
