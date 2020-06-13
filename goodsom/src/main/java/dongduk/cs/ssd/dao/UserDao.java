package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

/**
 * @author Yejin Lee
 * @since 2020.05.06
 */

public interface UserDao {

	User getUser(String emailId, String password) throws DataAccessException; // login시 필요
	
	User getUserByEmailId(String emailId) throws DataAccessException; // email로 user객체 얻어와서
	
	void createUser(User user) throws DataAccessException;

	void updateUser(User user) throws DataAccessException;

	void deleteUser(String emailId) throws DataAccessException;
	
	List<Order> getOrderList(int userId); // 마이페이지 결제 목록 보기
	
	List<GroupBuy> getGroupBuyList(int userId); // 마이페이지 공동구매 등록 목록 보기
	
	List<Auction> getAuctionList(int userId); // 마이페이지 경매 등록 목록 보기
	
}
