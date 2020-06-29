package dongduk.cs.ssd.controller.auction;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.AuctionService;
import dongduk.cs.ssd.service.BidService;
import dongduk.cs.ssd.service.UserService;
import dongduk.cs.ssd.service.impl.AuctionServiceImpl;

/**
 * @author Hyekyung Kim | Yejin Lee  | kimdahyee
 * @since 2020.05.08	| 2020.06.13 | 2020.06.25
 */

@Controller
@SessionAttributes("auctionForm")
@RequestMapping("/auction/*.do")
public class AuctionFormController implements ApplicationContextAware  {
	
	private static final String AUCTION_FORM = "auction/auction_form";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	private WebApplicationContext context;	
	private String uploadDir;

	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/resources/images/");
	}
	
	@Autowired
	private AuctionService auctionService;
	@Autowired
	private UserService userService;
	@Autowired
	private BidService bidService;

	@ModelAttribute("auctionForm")
	public AuctionForm formBacking(HttpServletRequest request, Model model, SessionStatus sessionStatus) throws Exception{
		String reqPage = request.getServletPath();
		System.out.println(reqPage);
		String auctionId = request.getParameter("auctionId");
		System.out.println(auctionId);
		if(auctionId == null) { //create: /auction/form.do
			return new AuctionForm();
		} else { // update: /auction/form.do?auctionId=
			Auction auction = auctionService.getAuction(Integer.valueOf(auctionId));
			System.out.println(auction.toString());
			return new AuctionForm(auction);
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showAuctionForm(@ModelAttribute("auctionForm") AuctionForm auctionForm) {
		return AUCTION_FORM;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(HttpServletRequest request, @Valid @ModelAttribute("auctionForm") AuctionForm auctionForm, BindingResult result,
			Model model, SessionStatus sessionStatus, HttpSession session) {
		System.out.println(auctionForm.toString());
//		/auction/create.do인지 /auction/update.do인지 구분하기 위해 필요!
		String reqPage = request.getServletPath();
		String requestUrl = reqPage.trim();

//		대표 이미지 선택 안 했을 시
		if (auctionForm.getAuction().getReport().getSize() == 0) {
			result.rejectValue("auction.report", "notSelected");
		}
//		AuctionForm객체 validation
		if (result.hasErrors()) {
			if (requestUrl.equals("/auction/update.do")) {
				return "redirect:form.do?auctionId=" + auctionForm.getAuction().getAuctionId();
			} else {
				return AUCTION_FORM;
			}
		}
		
//		경매 create시 작성자 번호(userId)를 넣어야하고, view에서 작성자를 출력해야 하므로 현재 접속 중인 사용자의 정보를 Session에서 가져온다.
		UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
		System.out.println(user.toString());
//		시간세팅
		auctionForm.getAuction().timeSet();
		auctionForm.getAuction().setMaxPrice(auctionForm.getAuction().getStartPrice());

//		파일 업로드 기능
		System.out.println("uploadDir: " + uploadDir);
		String savedFileName = uploadFile(auctionForm.getAuction().getReport());
		auctionForm.getAuction().setImg(request.getContextPath() + "/resources/images/" + savedFileName);
		
//		경매 update/create 작업
//		auctionForm.getAuction().setStartPrice(Integer.valueOf(auctionForm.getInputPrice()));
		if (requestUrl.equals("/auction/update.do")) { // update
			System.out.println(auctionForm.getAuction().toString());
//			if (auctionForm.getReport().getSize() == 0) { // 파일 새로 업로드 안 하면 원래 이미지 사용
//				auctionForm.getAuction().setImg(request.getContextPath() + "/resources/images/" + savedFileName);
//			}

			int auctionId = auctionService.updateAuction(auctionForm.getAuction());
			Auction auction = auctionService.getAuction(auctionId);
			Bid maxPriceBid = bidService.getBidByMaxPrice(auction.getMaxPrice(), auctionId);
			
			model.addAttribute("auction", auction);
			model.addAttribute("date_maxBid", maxPriceBid.getBidDate());
			User user_maxBid = userService.getUserByUserId(maxPriceBid.getUserId());
			model.addAttribute("user_maxBid", user_maxBid.getNickname());
		} else { // create
//			if (report.getSize() == 0) { // 파일 업로드 하지 않았을 때 SqlException이 나므로 기본 이미지 설정
//				auctionForm.getAuction().initImg(request.getContextPath());
//			} else {
//			}
            auctionForm.getAuction().initAuction(user.getUser());
			System.out.println("[AuctionFormController] auctionForm 값: " + auctionForm.toString());
			auctionService.createAuction(auctionForm.getAuction());
			
			model.addAttribute("auction", auctionForm.getAuction());
			model.addAttribute("date_maxBid", "");
			model.addAttribute("user_maxBid", "아직 입찰자가 없습니다.");
		}
		
//		스케줄러 => create / update 시 endDate로 설정
		auctionService.deadLineScheduler(auctionForm.getAuction().getEndDate());
		session.setAttribute("bidForm", new BidForm());

//		작성자만 수정/삭제 버튼 보이게 하기 위해 isWriter, 작성자 출력 위해 writer값을 넘겨준다.
		model.addAttribute("isWriter", true);
		model.addAttribute("writer", user.getUser().getNickname());
		model.addAttribute("bidForm", session.getAttribute("bidForm"));
		sessionStatus.setComplete();
		return AUCTION_DETAIL;
	}
	
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
//	파일명 랜덤생성 메서드
	private String uploadFile(MultipartFile report) {
//		uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
		UUID uuid = UUID.randomUUID();
//		랜덤생성 + 파일이름 저장
		String savedName = uuid.toString() + "_" + report.getOriginalFilename();
//		임시디렉토리에 저장된 업로드된 파일을 지정된 디렉토리로 복사
		File file = new File(uploadDir + savedName);
		try {
			report.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return savedName;
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	    binder.registerCustomEditor(MultipartFile.class, "auction.report",new StringTrimmerEditor(true));
//	} 
	
	@ModelAttribute("hourData")
	protected List<Hour> referenceData1() throws Exception {
		List<Hour> hour = new ArrayList<Hour>();
		for (int i = 1; i <= 12; i++) {
			hour.add(new Hour(i, i+"시"));			
		}
		return hour;
	}
	
	@ModelAttribute("minuteData")
	protected List<Minute> referenceData2() throws Exception {
		List<Minute> minute = new ArrayList<Minute>();
		minute.add(new Minute(00, "00분"));
		minute.add(new Minute(10, "10분"));
		minute.add(new Minute(20, "20분"));
		minute.add(new Minute(30, "30분"));
		minute.add(new Minute(40, "40분"));
		minute.add(new Minute(50, "50분"));
		return minute;
	}
	
	@ModelAttribute("amPm")
	protected List<String> referenceData3() throws Exception {
		List<String> amPm = new ArrayList<String>();
		amPm.add("am");
		amPm.add("pm");
		return amPm;
	}
}
