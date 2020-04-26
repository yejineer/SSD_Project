package dongduk.cs.ssd.dao;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;


public interface BidDao {
	Bid getBid(int bidId) throws DataAccessException;
	
	Bid getBid(int bidId, int auctionId) throws DataAccessException;
	
	void createBid(Bid bid) throws DataAccessException;
	
	void updateBid(Bid bid) throws DataAccessException;
	
	User getUserById(int userId) throws DataAccessException;
}
