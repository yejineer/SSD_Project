package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dongduk.cs.ssd.dao.AuctionDao;
import dongduk.cs.ssd.domain.Auction;


/**
 * @author Hyekyung Kim
 * @since 2020.05.03
 */

public class AuctionService {
	@Autowired
	private AuctionDao auctionDao;
	
	public Auction getAuction(int auctionId) {
		return auctionDao.getAuction(auctionId);
	}
	
	public List<Auction> getAuctionList() {
		return auctionDao.getAuctionList();
	}
	
	public List<Auction> getAuctionListByKeyword(String keyword) {
		return auctionDao.getAuctionListByKeyword(keyword);
	}
}
