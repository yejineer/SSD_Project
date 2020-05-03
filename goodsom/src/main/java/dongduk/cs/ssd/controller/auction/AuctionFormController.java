package dongduk.cs.ssd.controller.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dongduk.cs.ssd.service.AuctionService;

/**
 * @author Hyekyung Kim
 * @since 2020.05.03
 */

@Controller
public class AuctionFormController {
	
	@Autowired
	private AuctionService auctionSercice;
	
	
	private final String listViewName = "auction/list";
	private final String createViewName = "auction/create";
	private final String updateViewName = "auction/update";
	private final String detailViewName = "auction/detail";

	

	
}
