package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.User;

/**
 * @author kimdahyee
 * @since  2020.06.24
 */

public interface BidMapper {

	Bid getBid(int bidId);
	
	Bid getBidByAuctionId(int bidId, int auctionId);
	
	String getMaxPrice(int auctionId);
	
	Bid getBidByMaxPrice(int bidPrice, int auctionId);
	
	void createBid(Bid bid);
	
	List<Bid> getBidByUserId(int userId);
	
	Bid getSuccessBidByAuctionId(int auctionId);
	//void updateBid(Bid bid);
	
	//User getUserById(int userId);
	
}
