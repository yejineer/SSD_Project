package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.NotificationDao;
import dongduk.cs.ssd.dao.mybatis.mapper.NotiMapper;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.Notification;

/**
 * @author HK
 * @since  2020.06.29
 */

@Repository
public class MybatisNotiDao implements NotificationDao {
	
	@Autowired
	private NotiMapper notiMapper;
	
	public void createNoti_a(Bid bid) throws DataAccessException{
		notiMapper.createNoti_a(bid);
	}
	
//	public List<Bid> getBidByUserId(int userId)throws DataAccessException{
//		return notiMapper.getBidByUserId(userId);
//	}
	
	public List<Notification> getNotiByUserId(int userId) throws DataAccessException{
		return notiMapper.getNotiByUserId(userId);
	}
}