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

public class DeleteAuctionController {
	
	/*
	@Autowired
	AuctionService auctionService;
	
	@RequestMapping("/auction/delete.do")
	public ModelAndView auctionDelete(HttpServletRequest request,
			@ModelAttribute("auction") Auction auction){
		
		ModelAndView mav = new ModelAndView("auction/auction_list");
		auctionService.deleteAuction(auction.getAuctionId());
		// 이름을 auctionList로 바꿀까요?
		mav.addObject("auction", auctionService.getAuctionList());
		
		return mav;
	}
	*/
}
