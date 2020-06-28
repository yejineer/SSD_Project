package dongduk.cs.ssd.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.GroupBuyService;
import dongduk.cs.ssd.service.UserService;

/**
 * @author kimdahyee	| HK
 * @since  2020.06.12	| 2020.6.28
 */

@Controller
@SessionAttributes("userSession")
public class LoginController {
	
	@Value("login")
	private String formViewName;
	
	private UserService userService;
	
	@Autowired
	private GroupBuyService groupBuyService;
	
	@Autowired
	private AuctionService auctionService;
	
	@Autowired
	public void setUserService(UserService userService) { //setter method를 통한 DI
		this.userService = userService;
	}
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	//forward : 주소 변경 X, 화면 전환, 대량의 데이터 전달
	//redirect : 주소 변경 O, 화면 전환, 소량의 데이터 전달 (get 방식만 가능)
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpSession session,
			@RequestParam("emailId") String email,
			@RequestParam("password") String password,
			Model model) throws Exception {
		List<GroupBuy> recentGroupBuy = null;
		List<Auction> recentAuction = null;
		
		User user = userService.getUser(email, password);// 로그인 시도
		recentGroupBuy = groupBuyService.getRecentGroupBuyList();
		recentAuction = auctionService.getRecentAuctionList();
		
		if (user == null) { // 해당 email과 password를 갖는 사용자가 존재하지 않을 시
			
			return new ModelAndView("/user/login", "message", "Invalid email or password. Login failed.");
		
		} else {
			
			UserSession userSession = new UserSession(user);
			session.setAttribute("userSession", userSession);
			model.addAttribute("userSession", userSession); // 필요한가??
			model.addAttribute("recentGroupBuy", recentGroupBuy);
			model.addAttribute("recentAuction", recentAuction);
			return new ModelAndView("home");
			
		}
	}
}
