package dongduk.cs.ssd.controller.notification;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.Notification;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.BidService;
import dongduk.cs.ssd.service.NotiService;

/**
 * @author Yejin Lee 	| HK
 * @since 2020.05.07	| 2020.6.29
 */
@Controller
public class ListNotiController {
	
	@Value("user/noti_list")
	private String formViewName;
	
	@Autowired
	private NotiService notiService;
	
	@Autowired
	private BidService bidService;
	
	@Autowired
	private AuctionService auctionService;
	
	public void setNotiService(NotiService notiService) {
		this.notiService = notiService;
	}
	
	/* 세션에서 로그인한 사용자 정보를 받아와 해당 사용자의 notification list들을 보여주면 된다. */
//	user_detail -> noti_list
	@RequestMapping("/noti/list.do")  // ex) /user/detail.do?userId=2
	public ModelAndView handleRequest(HttpSession session) throws Exception {
		UserSession userSession  = (UserSession)session.getAttribute("userSession");
		User user = userSession.getUser();
//		List<Bid> userBidList = null;
		List<Notification> userNotiList = null;
		
		// user가 배팅한 경매 && 마감된 경매 && 최고금액인 경매
//		해당 유저가 배팅한 모든 Bid 정보
		userNotiList = notiService.getNotiByUserId(user.getUserId());	// bidService에 추가
		
//		for(int i=0; i<userNotiList.size(); i++) {
//			System.out.println(userNotiList.get(i).toString());
//		}
		
		ModelAndView mov = new ModelAndView();
		mov.addObject("nickname", user.getNickname());
		mov.addObject("message", "참여한 경매가 낙찰되었습니다. 결제를 진행해주세요!");
		mov.addObject("userNotiList", userNotiList);
		mov.setViewName(formViewName);
		
		return mov;
//		List<Notification> notiList = notiService.getNotiListByEmailId(user.getEmailId());
//		return new ModelAndView("noti_list", "notiList", notiList);
	}
	
	
	
}
