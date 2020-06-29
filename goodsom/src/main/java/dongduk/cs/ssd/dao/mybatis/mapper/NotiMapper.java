package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;


import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.Notification;

public interface NotiMapper {
	void createNoti_a(Bid bid); // successBidders table

//	List<Bid> getBidByUserId(int userId);
	Notification getNoti(int notiId);
	
	List<Notification> getNotiByUserId(int userId);
	
	void deleteNoti(int notiId);
}
