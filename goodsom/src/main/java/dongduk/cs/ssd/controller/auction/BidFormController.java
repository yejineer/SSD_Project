package dongduk.cs.ssd.controller.auction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.service.BidService;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;
import dongduk.cs.ssd.controller.user.UserSession;
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
	
	private final String detailViewName = "auction/auction_detail";

	@Autowired
	BidService bidService;
	
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuctionService auctionService;
	
	/*
	 * @ModelAttribute("bidForm") public BidForm formBacking(HttpServletRequest
	 * request,
	 * 
	 * @ModelAttribute("bid") Bid bid) throws Exception{
	 * 
	 * if(bid.getIsBidded()) { // update //배팅한 이력이 있으면 return new
	 * BidForm(bidService.getBid(bid.getBidId())); } else { // create return new
	 * BidForm(); } }
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public String form( ) { return
	 * detailViewName; }
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request, BidForm bidForm, 
			@RequestParam("bidPrice") int bidPrice, @RequestParam("auctionId") int auctionId,
			HttpServletResponse response) throws Exception {
		
		System.out.println("Betting price checking: " + bidPrice);
		System.out.println("Betting auctionId checking: " + auctionId);
		
		ModelAndView mav = new ModelAndView(detailViewName);
		
		HttpSession session = request.getSession(); 
		UserSession userSession = (UserSession)session.getAttribute("userSession");
		int userId = (int) userSession.getUser().getUserId();
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date bidDate = new java.sql.Date(utilDate.getTime());
		
		if(bidPrice < bidService.getMaxPrice(auctionId)) {	
			 response.setCharacterEncoding("UTF-8");
		     PrintWriter writer = response.getWriter();
		     writer.println("<script type='text/javascript'>");
		     writer.println("alert('최고 금액 이상의 금액을 배팅하세요');");
		     writer.println("history.back();");
		     writer.println("</script>");
		     writer.flush();
		}
		
		Bid bid = new Bid(userId, auctionId, bidPrice, bidDate);
		bidService.createBid(bid);
		
		int maxPrice = bidService.getMaxPrice(auctionId);
		auctionService.updateAuctionMaxPrice(maxPrice, auctionId); //auction table maxPrice update
		
		Auction auction = auctionService.getAuction(auctionId);
		
		session.setAttribute("auctionId", auctionId);
		mav.addObject("auction", auction);
		mav.addObject("writer", userService.getUserByUserId(auction.getUserId()).getNickname());
		return mav;
		
		/*
		 * if(bidForm.isNewBid()) { // create
		 * 
		 * HttpSession session = request.getSession(); int userId = (int)
		 * session.getAttribute("userId");
		 * 
		 * bidService.createBid(bidForm.getBid());
		 * 
		 * } else { //update bidService.updateBid(bidForm.getBid()); }
		 */
		
	}

}
