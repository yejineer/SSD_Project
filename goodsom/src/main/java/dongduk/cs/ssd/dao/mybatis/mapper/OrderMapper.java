package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;

/**
 * @author Seonmi Hwang
 * @since 2020.06.11
 */

public interface OrderMapper {

	  Order getOrder(int orderId) throws DataAccessException;

	  void createOrder(Order order) throws DataAccessException;
	  
	  List<LineGroupBuy> getLineGroupBuys(int orderId) throws DataAccessException; 

	// orderList에서 공동구매 정보 출력을 위해서 필요
	  int getGroupBuyId(int orderId) throws DataAccessException; // From LineGroupBuys

	// orderList에서 경매 정보 출력을 위해서 필요
	  int getAuctionId(int orderId) throws DataAccessException; // From SuccessBidders
}
