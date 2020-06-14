package dongduk.cs.ssd.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.AuctionDao;
import dongduk.cs.ssd.dao.mybatis.mapper.AuctionMapper;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.Bid;

/**
 * @author Yejin Lee
 * @since 2020.06.12
 */

@Repository
public class MybatisAuctionDao implements AuctionDao {

	private static final String proceeding = "proceeding";
	private static final String closed = "closed";
	
	@Autowired
	protected AuctionMapper auctionMapper;

	@Override
	public Auction getAuction(int auctionId) throws DataAccessException {
		return auctionMapper.getAuction(auctionId);
	}

	@Override
	public int createAuction(Auction auction) throws DataAccessException {
		auctionMapper.createAuction(auction);
		return auction.getAuctionId();
	}

	@Override
	public int updateAuction(Auction auction) throws DataAccessException {
		auctionMapper.updateAuction(auction);
		return auction.getAuctionId();
	}

	@Override
	public void deleteAuction(int auctionId) throws DataAccessException {
		auctionMapper.deleteAuction(auctionId);
	}

	@Override
	public List<Auction> getAuctionList() throws DataAccessException {
		return auctionMapper.getAuctionList();
	}

	@Override
	public List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException {
		return auctionMapper.getAuctionListByKeyword(keyword);
	}

//	@Override
//	public List<Bid> getBidByAuctionId(int auctionId) throws DataAccessException {
//		return null;
//	}

	@Override
	public boolean isAuctionClosed(int auctionId, Date currentTime) throws DataAccessException {
		Auction auction = auctionMapper.getAuction(auctionId);
		if (auction.getEndDate().compareTo(currentTime) == 0) {
			auction.setState(closed);
			updateAuction(auction);
			return true;
		}
		else
			return false;
	}
	
}
