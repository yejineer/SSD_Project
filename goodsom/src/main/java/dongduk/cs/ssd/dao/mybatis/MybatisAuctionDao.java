package dongduk.cs.ssd.dao.mybatis;

import java.util.Date;
import java.util.List;

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

	protected AuctionMapper auctionMapper;

	@Override
	public Auction getAuction(int auctionId) throws DataAccessException {
		return auctionMapper.getAuction(auctionId);
	}

	@Override
	public int createAuction(Auction auction) throws DataAccessException {
//		ReturnType : int (auctionId) 주는것이 어떨까? 생성하고 상세보기 보여주니까
		return auctionMapper.createAuction(auction);
		
	}

	@Override
	public int updateAuction(Auction auction) throws DataAccessException {
//		ReturnType : int (auctionId) 주는것이 어떨까? 수정하고 상세보기 보여주니까
		return auctionMapper.updateAuction(auction);
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

	@Override
	public List<Bid> getBidByAuctionId(int auctionId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuctionClosed(int auctionId, Date endDate) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
