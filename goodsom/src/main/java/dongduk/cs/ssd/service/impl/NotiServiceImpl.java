package dongduk.cs.ssd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.NotificationDao;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Notification;
import dongduk.cs.ssd.service.NotiService;

/**
 * @author Yejin Lee
 * @since  2020.05.03
 */
@Service
public class NotiServiceImpl implements NotiService {
	
	@Autowired
	private NotificationDao notiDao;
	
	@Override
	public List<Notification> getAuctionNotiByUserId(int userId){
		return notiDao.getAuctionNotiByUserId(userId);
	}

	@Override
	public Notification getAuctionNoti(int notiId) {
		return notiDao.getAuctionNoti(notiId);
	}
	
	@Override
	public Notification getGroupBuyNoti(int notiId) {
		return notiDao.getGroupBuyNoti(notiId);
	}

//	@Override
//	public void createNoti_g(int groupBuyId) {
//		notiDao.createNoti_g(groupBuyId);
//	}

	@Override
	public void createNoti_a(Bid bid) {
		notiDao.createNoti_a(bid);
	}
	
	@Override
	public void createNoti_g(GroupBuy groupBuy) {
		notiDao.createNoti_g(groupBuy);
	}
	
	@Override
	public List<Notification> getGroupBuyNotiByUserId(int userId){
		return notiDao.getGroupBuyNotiByUserId(userId);
	}
	
//	@Override
//	public List<Bid> getBidByUserId(int userId){
//		return notiDao.getBidByUserId(userId);
//	}

	@Override
	public void deleteAuctionNoti(int notiId) {
		notiDao.deleteAuctionNoti(notiId);
	}
	
	@Override
	public void deleteGroupBuyNoti(int notiId) {
		notiDao.deleteGroupBuyNoti(notiId);
	}
}
