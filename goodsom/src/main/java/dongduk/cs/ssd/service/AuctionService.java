package dongduk.cs.ssd.service;

import java.util.Date;
import java.util.List;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;


/**
 * @author Hyekyung Kim
 * @since 2020.05.05
 */

public interface AuctionService {
	
	Auction getAuction(int auctionId);
	
	int createAuction(Auction auction);
	
	int updateAuction(Auction auction);
	
	void deleteAuction(int auctionId);
	
	
	List<Auction> getAuctionList();
	
	List<Auction> getAuctionListByKeyword(String keyword);
	
//	List<Bid> getBidByAuctionId(int auctionId);
	
	boolean isAuctionClosed(int auctionId, Date endDate);
	
	void increaseCount(Auction auction);
	
}
