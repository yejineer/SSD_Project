package dongduk.cs.ssd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.AuctionDao;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.service.AuctionService;


/**
 * @author Hyekyung Kim | Yejin Lee  | kimdahyee
 * @since 2020.05.05	| 2020.06.13 | 2020.06.25
 */

@Service
public class AuctionServiceImpl implements AuctionService{
	
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

	public int createAuction(Auction auction) {
		return auctionDao.createAuction(auction);
	}

	public int updateAuction(Auction auction) {
		return auctionDao.updateAuction(auction);
	}
	
	public void updateAuctionMaxPrice(int maxPrice, int auctionId) {
		auctionDao.updateAuctionMaxPrice(maxPrice, auctionId);
	}

	public List<Auction> deleteAuction(int auctionId) {
		auctionDao.deleteAuction(auctionId);			
		return auctionDao.getAuctionList();
	}

//	public List<Bid> getBidByAuctionId(int auctionId) {
//		return auctionDao.getBidByAuctionId(auctionId);
//	}
//
	public boolean isAuctionClosed(int auctionId, Date endDate) {
		return auctionDao.isAuctionClosed(auctionId, endDate);
	}

	public void increaseCount(Auction auction) {
		auctionDao.increaseCount(auction);
	}
	
	
	
}
