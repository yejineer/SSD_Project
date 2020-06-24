package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

/**
 * @author Yejin Lee | kimdahyee	| Seonmi-Hwang
 * @since 2020.05.06 | 2020.06.12	| 2020.06.13
 */

public interface UserService {

	User getUser(String emailId, String password); // 로그인 시 사용
	
	User getUserByEmail(String email);
	
	User getUserByUserId(int userId) throws DataAccessException;
	
	void createUser(User user);

	void updateUser(User user);

	int deleteUser(int userId);
	
//	List<Order> getOrderList(int userId); // 마이페이지 결제 목록 보기
	
	List<Order> getAuctionOrderList(int userId);
	
	List<Order> getGroupBuyOrderList(int userId);
	
	List<GroupBuy> getGroupBuyList(int userId); // 마이페이지 공동구매 등록 목록 보기
	
	List<Auction> getAuctionList(int userId); // 마이페이지 경매 등록 목록 보기
}
