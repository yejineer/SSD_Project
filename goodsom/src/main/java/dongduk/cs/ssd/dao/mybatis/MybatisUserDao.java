package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.dao.mybatis.mapper.UserMapper;

/**
 * @author kimdahyee	/ Seonmi-Hwang
 * @since 2020.06.12	/ 2020.06.13
 */

@Repository
public class MybatisUserDao implements UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUser(String email, String passwd) throws DataAccessException {
		return userMapper.getUser(email, passwd);
	}
	
	public User getUserByEmail(String emailId) throws DataAccessException {
		return userMapper.getUserByEmail(emailId);
	}
	
	public User getUserByUserId(int userId) throws DataAccessException {
		return userMapper.getUserByUserId(userId);
	}
	
	public void createUser(User user) throws DataAccessException {
		userMapper.createUser(user);
	}

	public void updateUser(User user) throws DataAccessException {
		userMapper.updateUser(user);
	}

	public void deleteUser(String emailId) throws DataAccessException {
		userMapper.deleteUser(emailId);
	}
	
	public List<Order> getOrderList(int orderId) throws DataAccessException { // 마이페이지 결제 목록 보기
		return userMapper.getOrderList(orderId);
	}
	
	public List<GroupBuy> getGroupBuyList(int orderId) throws DataAccessException { // 마이페이지 공동구매 등록 목록 보기
		return userMapper.getGroupBuyList(orderId);
	}
	
	public List<Auction> getAuctionList(int orderId) throws DataAccessException { // 마이페이지 경매 등록 목록 보기
		return userMapper.getAuctionList(orderId);
	}
}
