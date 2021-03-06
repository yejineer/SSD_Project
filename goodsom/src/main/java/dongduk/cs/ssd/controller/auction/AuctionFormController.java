package dongduk.cs.ssd.controller.auction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.service.AuctionService;

/**
 * @author Hyekyung Kim | Yejin Lee  | kimdahyee
 * @since 2020.05.08	| 2020.06.13 | 2020.06.25
 */

@Controller
@SessionAttributes("auctionForm")
@RequestMapping("/auction/*.do")
public class AuctionFormController implements ApplicationContextAware  {
	
//	request handler가 보내줄 view이름 지정
	private static final String AUCTION_FORM = "auction/auction_form";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
//	파일 업로드 위한 변수
	private WebApplicationContext context;	
	private String uploadDir;
//	Service 객체
	@Autowired
	private AuctionService auctionService;

	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/resources/images/");
	}

	@ModelAttribute("auctionForm")
	public AuctionForm formBacking(HttpServletRequest request, Model model, SessionStatus sessionStatus) throws Exception{
		String reqPage = request.getServletPath();
		System.out.println(reqPage);
		String auctionId = request.getParameter("auctionId");
		if(auctionId == null) { //create: '/auction/form.do' 로 들어옴
			return new AuctionForm();
		} else { // update: '/auction/form.do?auctionId=' 로 들어옴
			Auction auction = auctionService.getAuction(Integer.valueOf(auctionId));
			System.out.println("수정 전 auction 객체: " + auction.toString());
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
				model.addAttribute("auctionId", auctionForm.getAuction().getAuctionId());
				return AUCTION_FORM;
			} else {
				return AUCTION_FORM;
			}
		}
		
//		경매 create시 작성자 번호(userId)를 넣어야하고, view에서 작성자를 출력해야 하므로 현재 접속 중인 사용자의 정보를 Session에서 가져온다.
		UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
		System.out.println(user.toString());
//		시간세팅
		auctionForm.getAuction().timeSet();

//		경매 update/create 작업
		if (requestUrl.equals("/auction/update.do")) { // update
			Auction oldAuction = auctionService.getAuction(auctionForm.getAuction().getAuctionId());
//			기존 파일 삭제 후 파일 업로드
			String[] oldFileName = oldAuction.getImg().split("/");
			if (deleteFile(uploadDir + oldFileName[4])) {
				System.out.println("파일 삭제 성공! 이제부터 파일 업로드.");
			}
//			파일 업로드 기능
			String savedFileName = uploadFile(auctionForm.getAuction().getReport());
			auctionForm.getAuction().setImg(request.getContextPath() + "/resources/images/"+ savedFileName);
			
			System.out.println(auctionForm.getAuction().toString());
			auctionForm.getAuction().setState("proceeding");
			int auctionId = auctionService.updateAuction(auctionForm.getAuction());
			model.addAttribute("auction", auctionService.getAuction(auctionId));
		} else { // create
//			파일 업로드 기능
			String savedFileName = uploadFile(auctionForm.getAuction().getReport());
			auctionForm.getAuction().setImg(request.getContextPath() + "/resources/images/" + savedFileName);
			
            auctionForm.getAuction().initAuction(user.getUser());
			System.out.println("[AuctionFormController] auctionForm 값: " + auctionForm.toString());
			auctionService.createAuction(auctionForm.getAuction());
			model.addAttribute("auction", auctionForm.getAuction());
		}
		
//		스케줄러 => create / update 시 endDate로 설정
		auctionService.deadLineScheduler(auctionForm.getAuction().getEndDate(), auctionForm.getAuction().getAuctionId());
		
//		view에 전송할 attribute
		session.setAttribute("bidForm", new BidForm());
		model.addAttribute("date_maxBid", "");
		model.addAttribute("user_maxBid", "아직 입찰자가 없습니다.");
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
	
//	파일명 삭제 메서드
	private boolean deleteFile(String oldFileSavedName) {
//		서버에 저장된 업로드된 파일을 삭제
		boolean result = new File(oldFileSavedName).delete();
		return result;
	}
	
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
