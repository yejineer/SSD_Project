package dongduk.cs.ssd.controller.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.controller.user.AuthenticationException;
import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Menu;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.GroupBuyService;
import dongduk.cs.ssd.service.MenuService;

/**
 * @author Hyekyung Kim
 * @since 2020.05.05
 */


@Controller
//@SessionAttributes({"menuId", "menuList"})
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
	/*
	private MenuService menuService;
	
	@Autowired
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@RequestMapping("/groupBuy/list.do")
	public String handleRequest(
			@RequestParam("menuId") int menuId,
			ModelMap model) throws Exception{
		Menu menu = this.menuService.getMenu(menuId);
		List<Menu> menuList = new ArrayList<Menu>();
		
		model.put("menu", menu);
		model.put("menuList", menuList);
		
		return "groupBuy_list";
	}
	
	@RequestMapping("/auction/list.do")
	public String handleRequest2(
			@RequestParam("menuId") int menuId,
			ModelMap model) throws Exception{
		Menu menu = this.menuService.getMenu(menuId);
		List<Menu> menuList = new ArrayList<Menu>();
		
		model.put("menu", menu);
		model.put("menuList", menuList);
		
		return "auction_list";
	}
	
	@RequestMapping("/community/list.do")
	public String handleRequest3(
			@RequestParam("menuId") int menuId,
			ModelMap model) throws Exception{
		Menu menu = this.menuService.getMenu(menuId);
		List<Menu> menuList = new ArrayList<Menu>();
		
		model.put("menu", menu);
		model.put("menuList", menuList);
		
		return "community_list";
	}
	*/
}
