package dongduk.cs.ssd.service;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;

/**
 * @author Hyekyung Kim
 * @since 2020.05.08
 */

public interface BidService {
	Bid getBid(int bidId);
	
	Bid getBid(int bidId, int auctionId);
	
	void createBid(Bid bid);
	
	void updateBid(Bid bid);
	
	User getUserById(int userId);

}
