package dongduk.cs.ssd.controller.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Hyekyung Kim
 * @since 2020.05.05
 */


@Controller
public class MenuController {
	
	@Value("home")
	private String formViewName;
	
	@Autowired
	private GroupBuyService groupBuyService;
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping("/home.do")
	public ModelAndView goHome(Model model) throws Exception{
		List<GroupBuy> recentGroupBuy = groupBuyService.getRecentGroupBuyList();
		List<Auction> recentAuction = auctionService.getRecentAuctionList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("recentGroupBuy", recentGroupBuy);
		mav.addObject("recentAuction", recentAuction);
		
		mav.setViewName(formViewName); // home 이동
		
		return mav;
	}
}
