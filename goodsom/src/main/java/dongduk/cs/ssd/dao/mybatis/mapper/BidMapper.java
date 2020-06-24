package dongduk.cs.ssd.dao.mybatis.mapper;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;

/**
 * @author kimdahyee
 * @since  2020.06.24
 */

public interface BidMapper {

	Bid getBid(int bidId);
	
	Bid getBidByAuctionId(int bidId, int auctionId);
	
	void createBid(Bid bid);
	
	//void updateBid(Bid bid);
	
	//User getUserById(int userId);
	
}
