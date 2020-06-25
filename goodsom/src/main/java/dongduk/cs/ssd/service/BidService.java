package dongduk.cs.ssd.service;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;

/**
 * @author Hyekyung Kim | kimdahyee
 * @since  2020.05.08   | 2020.06.24
 */

public interface BidService {
	
	Bid getBid(int bidId);
	
	Bid getBidByAuctionId(int bidId, int auctionId);
	
	String getMaxPrice(int auctionId);
	
	void createBid(Bid bid);
	
	//void updateBid(Bid bid);
	
	//User getUserById(int userId);

}
