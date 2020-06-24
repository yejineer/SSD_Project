package dongduk.cs.ssd.controller.auction;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.impl.AuctionServiceImpl;

/**
 * @author Hyekyung Kim & Yejin Lee
 * @since 2020.05.08	& 2020.06.13
 */

@Controller
@SessionAttributes("auctionForm")
@RequestMapping("/auction/*.do")
public class AuctionFormController {
	
	private static final String AUCTION_FORM = "auction/auction_form";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	private AuctionService auctionService;

	@ModelAttribute("auctionForm")
	public AuctionForm formBacking(HttpServletRequest request, Model model) throws Exception{
		String reqPage = request.getServletPath();
		System.out.println(reqPage);
		String auctionId = request.getParameter("auctionId");
		System.out.println(auctionId);
		if(auctionId == null) { //create: /auction/form.do
			return new AuctionForm();
		} else { // update: /auction/form.do?auctionId=
			return new AuctionForm(auctionService.getAuction(Integer.valueOf(auctionId)));
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showAuctionForm(@ModelAttribute("auctionForm") AuctionForm auctionForm) {
		return AUCTION_FORM;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(HttpServletRequest request, 
			@ModelAttribute("auctionForm") AuctionForm auctionForm, Model model) {
//		/auction/create.do인지 /auction/update.do인지 구분하기 위해 필요!
		String reqPage = request.getServletPath();
		
//		경매 create시 작성자 번호(userId)를 넣어야하고, view에서 작성자를 출력해야 하므로 현재 접속 중인 사용자의 정보를 Session에서 가져온다.
		UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
		
//		경매 이미지 파일 업로드를 하지 않았을 때 null로 들어오므로 SqlException이 나므로 기본 이미지 설정을 위한 작업을 한다.
		if (auctionForm.getAuction().getImg().trim() == "") {
			auctionForm.getAuction().initImg(request.getContextPath());
		}

		if(reqPage.trim().equals("/auction/update.do")) { // update
			System.out.println(auctionForm.getAuction().toString());
			int auctionId = auctionService.updateAuction(auctionForm.getAuction());
			model.addAttribute("auction", auctionService.getAuction(auctionId));
//			System.out.println("update 하고 나서 가져온 auctionId: " + auctionId);
		} else { // show after create
            auctionForm.getAuction().initAuction(user.getUser());
			System.out.println("[AuctionFormController] auctionForm 값: " + auctionForm.toString());
			auctionService.createAuction(auctionForm.getAuction());
			model.addAttribute("auction", auctionForm.getAuction()); 
		}
		
//		작성자만 수정/삭제 버튼 보이게 하기 위해 isWriter, 작성자 출력 위해 writer값을 넘겨준다.
		model.addAttribute("isWriter", true);
		model.addAttribute("writer", user.getUser().getNickname());
		return AUCTION_DETAIL;
	}
	
	
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	
	
}
