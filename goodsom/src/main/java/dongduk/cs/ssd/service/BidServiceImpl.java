package dongduk.cs.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.BidDao;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;

/**
 * @author Hyekyung Kim
 * @since 2020.05.08
 */

@Service
public class BidServiceImpl implements BidService{
	@Autowired
	private BidDao bidDao;
	
	public Bid getBid(int bidId) {
		return bidDao.getBid(bidId);
	}

	public Bid getBid(int bidId, int auctionId) {
		return bidDao.getBid(bidId, auctionId);
	}

	public void createBid(Bid bid) {
		bidDao.createBid(bid);
	}

	public void updateBid(Bid bid) {
		bidDao.updateBid(bid);
	}

	public User getUserById(int userId) {
		return bidDao.getUserById(userId);
	}
}
