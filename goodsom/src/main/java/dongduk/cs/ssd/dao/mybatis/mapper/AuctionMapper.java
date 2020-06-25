package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;

/**
 * @author Yejin Lee | kimdahyee
 * @since 2020.06.12 | 2020.06.25
 */
public interface AuctionMapper { // AuctionMapper.xml에서 구현한 method 이름과 일치해야함!
	
	Auction getAuction(int auctionId) throws DataAccessException;
	
	int createAuction(Auction auction) throws DataAccessException;
	
	int updateAuction(Auction auction) throws DataAccessException;
	
	void updateAuctionMaxPrice(int maxPrice, int auctionId) throws DataAccessException;
	
	void deleteAuction(int auctionId) throws DataAccessException;
	
	List<Auction> getAuctionList() throws DataAccessException;
	
	List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException;
	
	
//	List<Bid> getBidByAuctionId(int auctionId) throws DataAccessException;
	
//	boolean isAuctionClosed(int auctionId, Date endDate) throws DataAccessException;
	void increaseCount(Auction auction) throws DataAccessException;
	
//	스케줄러
	void closeEvent(Date curTime);
}
