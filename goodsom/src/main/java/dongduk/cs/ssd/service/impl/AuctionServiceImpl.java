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
 * @author Hyekyung Kim
 * @since 2020.05.05
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

	public void createAuction(Auction auction) {
		auctionDao.createAuction(auction);
	}

	public void updateAuction(Auction auction) {
		auctionDao.updateAuction(auction);
	}

	public void deleteAuction(int auctionId) {
		auctionDao.deleteAuction(auctionId);
	}

	public List<Bid> getBidByAuctionId(int auctionId) {
		return auctionDao.getBidByAuctionId(auctionId);
	}

	public boolean isAuctionClosed(int auctionId, Date endDate) {
		return auctionDao.isAuctionClosed(auctionId, endDate);
	}
}
