package dongduk.cs.ssd.dao.mybatis.mapper;

import dongduk.cs.ssd.domain.SuccessBidder;

/**
 * @author Seonmi Hwang
 * @since 2020.06.27
 */

public interface SuccessBidderMapper {
	
	int insertSuccessBidder(SuccessBidder successBidder);
	
	SuccessBidder getSuccessBidderByAuctionId(int auctionId);
}
