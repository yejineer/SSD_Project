package dongduk.cs.ssd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author kimdahyee	/ Seonmi-Hwang
 * @since 2020.06.12	/ 2020.06.13
 */

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User getUser(String email, String password) {
		return userDao.getUser(email, password);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(String email) {
		userDao.deleteUser(email);
	}
	
//	@Override
//	public List<Order> getOrderList(int userId) { // 마이페이지 결제 목록 보기
//		return userDao.getOrderList(userId);
//	}

	@Override
	public List<Order> getAuctionOrderList(int userId) { // 마이페이지 결제 목록 보기
		return userDao.getAuctionOrderList(userId);
	}
	
	@Override
	public List<Order> getGroupBuyOrderList(int userId) { // 마이페이지 결제 목록 보기
		return userDao.getGroupBuyOrderList(userId);
	}
	
	@Override	
	public List<GroupBuy> getGroupBuyList(int userId) { // 마이페이지 공동구매 등록 목록 보기
		return userDao.getGroupBuyList(userId);
	}
	
	@Override	
	public List<Auction> getAuctionList(int userId) { // 마이페이지 경매 등록 목록 보기
		return userDao.getAuctionList(userId);
	}
}
