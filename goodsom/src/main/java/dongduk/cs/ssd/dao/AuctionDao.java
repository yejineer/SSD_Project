package dongduk.cs.ssd.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.GroupBuy;

public interface AuctionDao {
	Auction getAuction(int auctionId) throws DataAccessException;
	
	void createAuction(Auction auction) throws DataAccessException;
	
	void updateAuciton(Auction auction) throws DataAccessException;
	
	void deleteAuction(Auction auction) throws DataAccessException;
	
	
	List<Auction> getAuctionList() throws DataAccessException;
	
	List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException;
	
	List<Bid> getBidByAuctionId(int auctionId) throws DataAccessException;
	
	boolean isAuctionClosed(int auctionId, Date endDate) throws DataAccessException;
}
