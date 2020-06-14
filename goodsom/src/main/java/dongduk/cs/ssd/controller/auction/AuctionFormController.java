package dongduk.cs.ssd.controller.auction;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.impl.AuctionServiceImpl;

/**
 * @author Hyekyung Kim
 * @since 2020.05.08
 */
/**
 * @author Yejin Lee
 * @since 2020.06.13
 */

@Controller
//@SessionAttributes("auction")
@RequestMapping("/auction")
public class AuctionFormController {
	
	private static final String AUCTION_LIST = "auction/auction_list";
	private static final String AUCTION_FORM = "auction/auction_form";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	private AuctionService auctionService;
	
//	private final String formViewName = "auction/form";
//	private final String detailViewName = "auction/detail";

//	@ModelAttribute("auctionForm")
//	public AuctionForm formBacking(HttpServletRequest request, 
//			@ModelAttribute("auction") Auction auction) throws Exception{
//		String reqPage = request.getServletPath();
//		
//		//create
//		if(reqPage.trim().equals("/auction/form.do") && request.getMethod().equals("GET")) {
//			return new AuctionForm();
//		}else { // update or show
//			return new AuctionForm(auctionService.getAuction(auction.getAuctionId()));
//		}
//		
//	}

	@RequestMapping(value="/form.do")
	public String auctionForm() {
		return AUCTION_FORM;
	}
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String auctionList(){
		return AUCTION_LIST;
	}
	
	
	@RequestMapping(value="/detail.do", method = RequestMethod.POST)
	public String updateOrSubmit(HttpServletRequest request,
			@ModelAttribute("auctionForm") AuctionForm auctionForm) {
		String reqPage = request.getServletPath();
		System.out.println(reqPage);
		HttpSession session = request.getSession();
		UserSession user  = (UserSession)session.getAttribute("userSession");
		int userId = user.getUser().getUserId();
//		if(reqPage.trim().equals("auction_form")) { // update
//			auctionService.updateAuction(auctionForm.getAuction());
//			return AUCTION_FORM;
//		}else { // show after create
			System.out.println("[AuctionFormController]-updateOrSubmit()");
			Calendar calendar = Calendar.getInstance();
            java.util.Date date = calendar.getTime();
            System.out.println(date);
//            endDate (String) -> (Date)
//            auctionForm.getAuction().getEndDate()
            
			auctionForm.getAuction().setUploadDate(date);
			auctionForm.getAuction().setUserId(userId);
			auctionService.createAuction(auctionForm.getAuction());
			return AUCTION_DETAIL;
//		}
	}
	
	
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	
	
}
