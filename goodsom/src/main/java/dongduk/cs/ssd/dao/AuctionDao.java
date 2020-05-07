package dongduk.cs.ssd.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;

/**
 * @author Hyekyung Kim
 * @since 2020.05.05
 */

public interface AuctionDao {
	Auction getAuction(int auctionId) throws DataAccessException;
	
	void createAuction(Auction auction) throws DataAccessException;
	
	void updateAuction(Auction auction) throws DataAccessException;
	
	void deleteAuction(int auctionId) throws DataAccessException;
	
	
	List<Auction> getAuctionList() throws DataAccessException;
	
	List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException;
	
	List<Bid> getBidByAuctionId(int auctionId) throws DataAccessException;
	
	boolean isAuctionClosed(int auctionId, Date endDate) throws DataAccessException;
}
