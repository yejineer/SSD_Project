package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Notification;

/**
 * @author Yejin Lee
 * @since 2020.05.06
 */
public interface NotiService {
	
	List<Notification> getAuctionNotiByUserId(int userId); //Do sql operations twice.
	
	Notification getAuctionNoti(int notiId); // Two tables share one noti_sequence.

	Notification getGroupBuyNoti(int notiId);
//	void createNoti_g(int groupBuyId); // lineGroupBuys table
	
	void createNoti_a(Bid bid); // successBidders table
	
	void createNoti_g(GroupBuy groupBuy);
	
	List<Notification> getGroupBuyNotiByUserId(int userId);

//	List<Bid> getBidByUserId(int userId);
	
	void deleteAuctionNoti(int notiId);
	
	void deleteGroupBuyNoti(int notiId);
}
