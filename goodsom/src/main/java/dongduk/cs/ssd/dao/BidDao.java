package dongduk.cs.ssd.dao;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;


/**
 * @author Hyekyung Kim | kimdahyee
 * @since  2020.05.08   | 2020.06.24
 */

public interface BidDao {
	
	Bid getBid(int bidId) throws DataAccessException;
	
	Bid getBidByAuctionId(int bidId, int auctionId) throws DataAccessException;
	
	String getMaxPrice(int auctionId);
	
	Bid getBidByMaxPrice(int bidPrice, int auctionId);
	
	void createBid(Bid bid) throws DataAccessException;
	
	//void updateBid(Bid bid) throws DataAccessException;
	
	//User getUserById(int userId) throws DataAccessException;
	
}
