package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.Notification;

/**
 * @author Yejin Lee
 * @since 2020.05.06
 */
public interface NotiService {
	
	List<Notification> getNotiByUserId(int userId); //Do sql operations twice.
	
	Notification getNoti(int notiId); // Two tables share one noti_sequence.
//	
//	void createNoti_g(int groupBuyId); // lineGroupBuys table
	
	void createNoti_a(Bid bid); // successBidders table

//	List<Bid> getBidByUserId(int userId);
	
	void deleteNoti(int notiId);
}
