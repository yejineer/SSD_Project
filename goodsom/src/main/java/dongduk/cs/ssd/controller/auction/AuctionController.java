package dongduk.cs.ssd.controller.auction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.UserService;
import dongduk.cs.ssd.domain.Bid;
//import dongduk.cs.ssd.domain.SuccessBidder;
import dongduk.cs.ssd.service.BidService;

/**
 * @author Hyekyung Kim	| Yejin Lee   | kimdahyee  | Seonmi Hwang
 * @since 2020.05.08	| 2020.06.14  | 2020.06.25 | 2020.06.29
 */


@Controller
@SessionAttributes("auctionForm")
public class AuctionController {
	
	private static final String AUCTION_LIST = "auction/auction_list";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	AuctionService auctionService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BidService bidService;
	
	
	@RequestMapping(value="/auction/list.do", method=RequestMethod.GET)
	public ModelAndView auctionList(SessionStatus sessionStatus){
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = null;
		auctionList = auctionService.getAuctionList();
		if (auctionList == null) {
			System.out.println("[DetailAuctionController] auctionList가 null");
		} else {
			mav.addObject("auctionList", auctionList);			
		}
		sessionStatus.setComplete();
		return mav;
	}
	
	@RequestMapping(value="/auction/detail.do")
	public ModelAndView auctionDetail(HttpServletRequest request,
			@RequestParam("auctionId") int auctionId, HttpSession session) {
		ModelAndView mav = new ModelAndView(AUCTION_DETAIL);
		Auction auction = auctionService.getAuction(auctionId); //auction 정보 가져오기
		Bid bid = bidService.getBidByMaxPrice(auction.getMaxPrice(), auctionId); //auction의 최고 금액에 해당하는 bid 정보 가져오기
		
		// 낙찰자가 결제까지 완료한 경우
//		SuccessBidder successBidder = auctionService.getSuccessBidderByAuctionId(auctionId);
//		if (successBidder != null) {
//			mav.addObject("completeOrder", 1);
//		} else {
//			mav.addObject("completeOrder", 0);
//		}
		
		UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
		if (user.getUser().getUserId() == auction.getUserId()) {
			mav.addObject("isWriter", true);
		} else {
			auction.setCount(auction.getCount()+1);
			auctionService.increaseCount(auction);
			mav.addObject("isWriter", false);
		}
		
		session.setAttribute("auctionId", auctionId);
		mav.addObject("auction", auction);
		mav.addObject("bid", bid);
		mav.addObject("writer", userService.getUserByUserId(auction.getUserId()).getNickname());
		return mav;
	}
	
	@RequestMapping(value="/auction/delete.do")
	public ModelAndView auctionDelete(HttpServletRequest request,
			@RequestParam("auctionId") int auctionId){
		
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = auctionService.deleteAuction(auctionId);
		mav.addObject("auctionList", auctionList);
		
		return mav;
	}
}
