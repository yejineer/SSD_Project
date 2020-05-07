package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.domain.Notification;

public interface NotiService {

	List<Notification> getNotiListByUserId(int userId); //Do sql operations twice.
	
	Notification getNoti(int notiId); // Two tables share one noti_sequence.
	
	void createNoti_g(int groupBuyId); // lineGroupBuys table
	
	void createNoti_a(int auctionId); // successBidders table
	
	void deleteNoti_g(int notiId);
	
	void deleteNoti_a(int notiId);
}
