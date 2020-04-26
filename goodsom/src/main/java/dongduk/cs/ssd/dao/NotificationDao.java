package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Notification;

public interface NotificationDao {
	
	List<Notification> getNotiListByUserId(int userId) throws DataAccessException; //Do sql operations twice.
	
	Notification getNoti(int notiId) throws DataAccessException; // Two tables share one noti_sequence.
	
	void createNoti_g(int groupBuyId) throws DataAccessException; // lineGroupBuys table
	
	void createNoti_a(int auctionId) throws DataAccessException; // successBidders table
	
	void deleteNoti_g(int notiId) throws DataAccessException;
	
	void deleteNoti_a(int notiId) throws DataAccessException;
	
}
