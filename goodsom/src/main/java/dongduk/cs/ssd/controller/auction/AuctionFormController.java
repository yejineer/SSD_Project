package dongduk.cs.ssd.controller.auction;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.impl.AuctionServiceImpl;

/**
 * @author Hyekyung Kim &
 * @since 2020.05.08	& 2020.06.13
 */

@Controller
//@SessionAttributes("auction")
@RequestMapping("/auction/*.do")
public class AuctionFormController {
	
	private static final String AUCTION_FORM = "auction/auction_form";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	private static final String PROCEEDING = "proceeding";
//	private static final String CLOSED = "closed";
	private static final int MENUID_AUCTION = 1;
	
	@Autowired
	private AuctionService auctionService;
	
//	private final String formViewName = "auction/form";
//	private final String detailViewName = "auction/detail";

	@ModelAttribute("auctionForm")
	public AuctionForm formBacking(HttpServletRequest request, Model model) throws Exception{
		String reqPage = request.getServletPath();
		System.out.println(reqPage);
		String auctionId = request.getParameter("auctionId");
		System.out.println(auctionId);
		if(auctionId == null) { //create
			model.addAttribute("createAuction", true);
			return new AuctionForm();
		} else { // update
			model.addAttribute("createAuction", false);
			return new AuctionForm(auctionService.getAuction(Integer.valueOf(auctionId)));
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showAuctionForm() {
		return AUCTION_FORM;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(HttpServletRequest request, 
			@ModelAttribute("auctionForm") AuctionForm auctionForm, Model model) {
		String reqPage = request.getServletPath();
		System.out.println(reqPage);
		HttpSession session = request.getSession();
		UserSession user  = (UserSession)session.getAttribute("userSession");
		int userId = user.getUser().getUserId();
		if(reqPage.trim().equals("/auction/update.do")) { // update
//			auctionService.updateAuction(auctionForm.getAuction());
			return AUCTION_DETAIL;
//			return AUCTION_FORM;
		}else { // show after create
			System.out.println("[AuctionFormController]-submit()");
			Calendar calendar = Calendar.getInstance();
            java.util.Date date = calendar.getTime();
            System.out.println(date);
            
			auctionForm.getAuction().setUploadDate(date);
			auctionForm.getAuction().setUserId(userId);
			auctionForm.getAuction().setState(PROCEEDING);
			auctionForm.getAuction().setCount(0);
			auctionForm.getAuction().setMenuId(MENUID_AUCTION);
			System.out.println(auctionForm.toString());
//			int auctionId = auctionService.createAuction(auctionForm.getAuction());
			model.addAttribute("writer", user.getUser().getNickname());
			model.addAttribute("auction", auctionForm.getAuction()); 
//			return "rediect:/auction/detail.do?auctionId="+auctionId;
			return AUCTION_DETAIL;
		}
	}
	
	
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	
	
}
