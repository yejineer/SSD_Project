package dongduk.cs.ssd.controller.auction;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.service.BidService;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;

/**
 * @author Hyekyung Kim | kimdahyee
 * @since  2020.05.08   | 2020.06.25
 */

/*
@Controller
@SessionAttributes("bid")
@RequestMapping("/auction/detail.do")
*/

@Controller
@RequestMapping("/auction/bid/create.do")
public class BidFormController {

	@Autowired
	BidService bidService;
	
	@Autowired
	UserService userService;
	
	private final String detailViewName = "auction/auction_detail";
	
	@ModelAttribute("bidForm")
	public BidForm formBacking(HttpServletRequest request,
			@ModelAttribute("bid") Bid bid) throws Exception{
		
		if(bid.getIsBidded()) { // update  //배팅한 이력이 있으면
			return new BidForm(bidService.getBid(bid.getBidId()));
		} else { // create
			return new BidForm();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET) 
	public String form( ) {
		 return detailViewName; 
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(HttpServletRequest request, BidForm bidForm) {
		
		if(bidForm.isNewBid()) { // create
			//System.out.println("Betting price checking: " + bidPrice);
			
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			
			bidService.createBid(bidForm.getBid());
			
		} else { 
			//update bidService.updateBid(bidForm.getBid()); 
		}
	
		return detailViewName;
		//return "redirect:/view/auction/detail.do?autionId=" + auctionId;
	}

	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}

}
