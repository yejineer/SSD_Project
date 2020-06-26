package dongduk.cs.ssd.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.BidDao;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.dao.mybatis.mapper.BidMapper;

/**
 * @author kimdahyee
 * @since  2020.06.24
 */

@Repository
public class MybatisBidDao implements BidDao {
	
	@Autowired
	private BidMapper bidMapper;
	
	public Bid getBid(int bidId) throws DataAccessException {
		return bidMapper.getBid(bidId);
	}
	
	public Bid getBidByAuctionId(int bidId, int auctionId) throws DataAccessException {
		return bidMapper.getBidByAuctionId(bidId, auctionId);
	}
	
	public String getMaxPrice(int auctionId) throws DataAccessException {
		return bidMapper.getMaxPrice(auctionId);
	}
	
	public Bid getBidByMaxPrice(int bidPrice, int auctionId) throws DataAccessException {
		return bidMapper.getBidByMaxPrice(bidPrice, auctionId);
	}
	
	public void createBid(Bid bid) throws DataAccessException {
		bidMapper.createBid(bid);
	}
	
	/*
	 * public void updateBid(Bid bid) throws DataAccessException {
	 * bidMapper.updateBid(bid); }
	 * 
	 * public User getUserById(int userId) throws DataAccessException { return
	 * bidMapper.getUserById(userId); }
	 */
}
