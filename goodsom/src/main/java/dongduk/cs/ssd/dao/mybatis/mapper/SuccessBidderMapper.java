package dongduk.cs.ssd.dao.mybatis.mapper;

import dongduk.cs.ssd.domain.SuccessBidder;

public interface SuccessBidderMapper {
	
	int insertSuccessBidder(SuccessBidder successBidder);
	
	SuccessBidder getSuccessBidderByAuctionId(int auctionId);
}
