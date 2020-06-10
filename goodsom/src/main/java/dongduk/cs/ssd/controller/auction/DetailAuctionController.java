package dongduk.cs.ssd.controller.auction;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;

/**
 * @author Hyekyung Kim
 * @since 2020.05.08
 */

/*
@Controller
@SessionAttributes("auction")
*/
public class DetailAuctionController {
	
	/*
	@Autowired
	AuctionService auctionService;
	
	@RequestMapping("/auction/detail.do")
	public ModelAndView auctionDetail(HttpServletRequest request,
			@ModelAttribute("auction") Auction auction) {
		ModelAndView mav = new ModelAndView("auction/auction_detail");
		// 이름이 헷갈리지 않을까요?
		mav.addObject("auction", auctionService.getAuction(auction.getAuctionId()));
		return mav;
	}
	*/
}
