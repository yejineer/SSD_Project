package dongduk.cs.ssd.controller.search;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.service.SearchService;

/**
 * @author Hyekyung Kim
 * @since 2020.05.05
 */

@Controller
public class SearchController {
	final int GROUPBUY = 1; // 일단 임의로 정함
	final int AUCTION = 2;
	
	private SearchService searchService;
	
	@Autowired
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	
	@RequestMapping("/search.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="type", required=false) int type) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if (keyword != null) {	
			if (!StringUtils.hasLength(keyword)) {	// no input
				return new ModelAndView("Error", "message", "검색어를 입력해주세요.");
			}
			
			PagedListHolder<GroupBuy> groupBuyList = null;
			PagedListHolder<Auction> auctionList;
			
			if(type == GROUPBUY) {	// search by type
				groupBuyList = new PagedListHolder<GroupBuy>(this.searchService.groupBuyListByKeyword(keyword.toLowerCase()));
				groupBuyList.setPageSize(3);
				
				mav.addObject("groupBuyList", groupBuyList);
				
			}else if(type == AUCTION) {
				auctionList = new PagedListHolder<Auction>(this.searchService.auctionListByKeyword(keyword.toLowerCase()));
				auctionList.setPageSize(3);
				
				mav.addObject("auctionList", auctionList);
			}else {	
				groupBuyList = new PagedListHolder<GroupBuy>(this.searchService.groupBuyListByKeyword(keyword.toLowerCase()));
				groupBuyList.setPageSize(3);
				auctionList = new PagedListHolder<Auction>(this.searchService.auctionListByKeyword(keyword.toLowerCase()));
				auctionList.setPageSize(3);
				
				mav.addObject("groupBuyList", groupBuyList);
				mav.addObject("auctionList", auctionList);
			}
			
			return mav;
		}
		else {
			@SuppressWarnings("unchecked")
			PagedListHolder<GroupBuy> groupBuyList = (PagedListHolder<GroupBuy>)request.getSession().getAttribute("SearchController_groupBuyList");
			@SuppressWarnings("unchecked")
			PagedListHolder<Auction> auctionList = (PagedListHolder<Auction>)request.getSession().getAttribute("SearchController_auctionList");
			if (groupBuyList == null || auctionList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			mav.addObject("groupBuyList", groupBuyList);
			mav.addObject("auctionList", auctionList);
			return mav;
		}
	}
}
