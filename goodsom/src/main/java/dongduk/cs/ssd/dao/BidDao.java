package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;


/**
 * @author Hyekyung Kim | kimdahyee		| Yejin Lee
 * @since  2020.05.08   | 2020.06.24	| 2020.06.29
 */

public interface BidDao {
	
	Bid getBid(int bidId) throws DataAccessException;
	
	Bid getBidByAuctionId(int bidId, int auctionId) throws DataAccessException;
	
	String getMaxPrice(int auctionId);
	
	Bid getBidByMaxPrice(int bidPrice, int auctionId);
	
	void createBid(Bid bid) throws DataAccessException;	
	
	List<Bid> getBidByUserId(int userId) throws DataAccessException;
	
	Bid getBidByUserIdAndAuctionId(int userId, int auctionId);
	
	void updateBid(Bid bid) throws DataAccessException;
	
}
