package dongduk.cs.ssd.service;

import java.util.Date;
import java.util.List;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;


/**
 * @author Hyekyung Kim | Yejin Lee  | kimdahyee
 * @since 2020.05.05	| 2020.06.13 | 2020.06.25
 */

public interface AuctionService {
	
	Auction getAuction(int auctionId);
	
	int createAuction(Auction auction);
	
	int updateAuction(Auction auction);
	
	void updateAuctionMaxPrice(int maxPrice, int auctionId);
	
	List<Auction> deleteAuction(int auctionId);
	
	List<Auction> getAuctionList();
	
	List<Auction> getAuctionListByKeyword(String keyword);
	
//	List<Bid> getBidByAuctionId(int auctionId);
	
	boolean isAuctionClosed(int auctionId, Date endDate);
	
	void increaseCount(Auction auction);
	
//	스케줄러
	public void deadLineScheduler(Date endDate);
	
}
