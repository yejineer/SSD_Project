package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.NotificationDao;
import dongduk.cs.ssd.dao.mybatis.mapper.NotiMapper;
import dongduk.cs.ssd.domain.Bid;

/**
 * @author HK
 * @since  2020.06.29
 */

@Repository
public class MybatisNotiDao implements NotificationDao {
	
	@Autowired
	private NotiMapper notiMapper;
	
	public void createNoti_a(int auctionId) throws DataAccessException{
		notiMapper.createNoti_a(auctionId);
	}
	
	public List<Bid> getBidByUserId(int userId)throws DataAccessException{
		return notiMapper.getBidByUserId(userId);
	}
}