package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import dongduk.cs.ssd.domain.Bid;

public interface NotiMapper {
	void createNoti_a(int auctionId); // successBidders table

	List<Bid> getBidByUserId(int userId);
}
