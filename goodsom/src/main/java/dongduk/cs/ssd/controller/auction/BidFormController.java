package dongduk.cs.ssd.controller.auction;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.service.BidService;

/**
 * @author Hyekyung Kim
 * @since 2020.05.08
 */

@Controller
@SessionAttributes("bid")
@RequestMapping("/auction/detail.do")
public class BidFormController {
	@Autowired
	BidService bidService;
	
	private final String formViewName = "/auction/form";
	private final String detailViewName = "/auction/detail";
	
	@ModelAttribute("bidForm")
	public BidForm formBacking(HttpServletRequest request,
			@ModelAttribute("bid") Bid bid) throws Exception{
		
		if(bid.getIsBidded()) { // update 
			return new BidForm(bidService.getBid(bid.getBidId()));
		} else { // create
			return new BidForm();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createOrUpdate(HttpServletRequest request,
			BidForm bidForm) {
		
		if(bidForm.isNewBid()) { // create
			bidService.createBid(bidForm.getBid());
		} else { // update
			bidService.updateBid(bidForm.getBid());
		}
	
		return detailViewName;
	}

	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
}
