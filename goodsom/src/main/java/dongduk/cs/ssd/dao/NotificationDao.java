package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Notification;

public interface NotificationDao {
	
	List<Notification> getNotiListByUserId(String userId) throws DataAccessException;
	
	void createNoti() throws DataAccessException;
	
	void sendNoti() throws DataAccessException;
	
	
}
