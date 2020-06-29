package dongduk.cs.ssd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.BidDao;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.BidService;

/**
 * @author Hyekyung Kim | kimdahyee
 * @since  2020.05.08   | 2020.06.24
 */

@Service
public class BidServiceImpl implements BidService{

	@Autowired
	private BidDao bidDao;
	
	public Bid getBid(int bidId) {
		return bidDao.getBid(bidId);
	}

	public Bid getBidByAuctionId(int bidId, int auctionId) {
		return bidDao.getBidByAuctionId(bidId, auctionId);
	}
	
	public String getMaxPrice(int auctionId) {
		return bidDao.getMaxPrice(auctionId);
	}
	
	public Bid getBidByMaxPrice(int bidPrice, int auctionId) {
		return bidDao.getBidByMaxPrice(bidPrice, auctionId);
	}

	public void createBid(Bid bid) {
		bidDao.createBid(bid);
	}

	public List<Bid> getBidByUserId(int userId) {
		return bidDao.getBidByUserId(userId);
	}
	/*
	 * public void updateBid(Bid bid) { bidDao.updateBid(bid); }
	 * 
	 * public User getUserById(int userId) { return bidDao.getUserById(userId); }
	 */

}
