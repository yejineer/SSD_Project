package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;


import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Notification;

public interface NotiMapper {
	void createNoti_a(Bid bid); // successBidders table

//	List<Bid> getBidByUserId(int userId);
	Notification getAuctionNoti(int notiId);
	
	Notification getGroupBuyNoti(int notiId);
	
	List<Notification> getAuctionNotiByUserId(int userId);
	
	List<Notification> getGroupBuyNotiByUserId(int userId);
	
	void deleteAuctionNoti(int notiId);
	
	void createNoti_g(GroupBuy groupBuy);
	
	void deleteGroupBuyNoti(int notiId);
	
}
