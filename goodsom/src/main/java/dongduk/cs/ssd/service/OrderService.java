package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */

public interface OrderService {
	
	public User getUser(String emailId);
	
	public Order getOrder(int orderId); // DetailOrderController에서 사용
	
	public void createOrder(Order order);

	public Order getOrderWithLineGroupBuys(int orderId);
	
	public List<Order> setAuctionInfo(List<Order> orderList);
	
	public List<Order> setGroupBuyInfo(List<Order> orderList);
}
