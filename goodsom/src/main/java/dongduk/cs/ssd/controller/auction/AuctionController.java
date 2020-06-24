package dongduk.cs.ssd.controller.auction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Hyekyung Kim	& Yejin Lee
 * @since 2020.05.08	& 2020.06.14
 */


@Controller

public class AuctionController {
	
	private static final String AUCTION_LIST = "auction/auction_list";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	AuctionService auctionService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/auction/list.do", method=RequestMethod.GET)
	public ModelAndView auctionList(){
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = null;
		auctionList = auctionService.getAuctionList();
		if (auctionList == null) {
			System.out.println("[DetailAuctionController] auctionList가 null");
		} else {
			mav.addObject("auctionList", auctionList);			
		}
		return mav;
	}
	
	@RequestMapping(value="/auction/detail.do")
	public ModelAndView auctionDetail(HttpServletRequest request,
			@RequestParam("auctionId") int auctionId) {
		ModelAndView mav = new ModelAndView(AUCTION_DETAIL);
		Auction auction = auctionService.getAuction(auctionId);

		UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
		if (user.getUser().getUserId() == auction.getUserId()) {
			mav.addObject("isWriter", true);
		} else {
			auction.setCount(auction.getCount()+1);
			auctionService.increaseCount(auction);
			mav.addObject("isWriter", false);
		}
		mav.addObject("auction", auction);
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
