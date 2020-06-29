package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

/**
 * @author kimdahyee | Seonmi-Hwang
 * @since 2020.06.12 | 2020.06.13
 */

public interface UserMapper {

	User getUser(String email, String passwd);
	
	User getUserByEmail(String email);
	
	User getUserByUserId(int userId);
	
	void createUser(User user);

	void updateUser(User user);

	int deleteUser(User user);
	
	List<Order> getAuctionOrderList(int userId);
	
	List<Order> getGroupBuyOrderList(int userId);
	
	List<GroupBuy> getGroupBuyList(int userId); // 마이페이지 공동구매 등록 목록 보기
	
	List<Auction> getAuctionList(int userId); // 마이페이지 경매 등록 목록 보기
}
