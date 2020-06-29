package dongduk.cs.ssd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.GroupBuyDao;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.service.SearchService;
import dongduk.cs.ssd.dao.AuctionDao;

/**
 * @author Hyekyung Kim
 * @since 2020.05.05
 */

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private GroupBuyDao groupBuy;
	@Autowired
	private AuctionDao auction;	
	
	@Override
	public List<GroupBuy> groupBuyListByKeyword(String keyword) {
		return groupBuy.groupBuyListByKeyword(keyword);
	}

	@Override
	public List<Auction> auctionListByKeyword(String keyword) {
		return auction.auctionListByKeyword(keyword);
	}
	
}
