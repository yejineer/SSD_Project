package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.dao.mybatis.mapper.AuctionMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.GroupBuyMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.OrderMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.UserMapper;

/**
 * @author kimdahyee  | Seonmi-Hwang
 * @since  2020.06.12 | 2020.06.13
 */

@Repository
public class MybatisUserDao implements UserDao {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private GroupBuyMapper groupBuyMapper;
	@Autowired
	private AuctionMapper auctionMapper;
	
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

	@Transactional
	public int deleteUser(int userId) throws DataAccessException {
		// USERS 테이블에 userId에 해당하는 유저 삭제
		int deleteSuccess =  userMapper.deleteUser(userId);
		
		// ORDERS 테이블에 userId에 해당하는 결제정보 삭제
		deleteSuccess += orderMapper.deleteOrderByUserId(userId);
		
		// GROUPBUYS 테이블에 userId에 해당하는 공동구매 삭제
		deleteSuccess += groupBuyMapper.deleteGroupBuyByUserId(userId);
		
		// AUCTIONS 테이블에 userId에 해당하는 경매 삭제
		deleteSuccess += auctionMapper.deleteAuctionByUserId(userId);
		
		return deleteSuccess;
	}

	public List<Order> getAuctionOrderList(int orderId) throws DataAccessException { // 마이페이지 결제 목록 보기
		return userMapper.getAuctionOrderList(orderId);
	}
	
	public List<Order> getGroupBuyOrderList(int orderId) throws DataAccessException { // 마이페이지 결제 목록 보기
		return userMapper.getGroupBuyOrderList(orderId);
	}
	
	public List<GroupBuy> getGroupBuyList(int orderId) throws DataAccessException { // 마이페이지 공동구매 등록 목록 보기
		return userMapper.getGroupBuyList(orderId);
	}
	
	public List<Auction> getAuctionList(int orderId) throws DataAccessException { // 마이페이지 경매 등록 목록 보기
		return userMapper.getAuctionList(orderId);
	}
}
