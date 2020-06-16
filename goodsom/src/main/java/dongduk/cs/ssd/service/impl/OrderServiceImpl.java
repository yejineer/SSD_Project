package dongduk.cs.ssd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.AuctionDao;
import dongduk.cs.ssd.dao.GroupBuyDao;
import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.OrderService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private GroupBuyDao groupBuyDao;
	@Autowired
	private AuctionDao auctionDao;
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String emailId) {
		return userDao.getUserByEmail(emailId);
	}

	@Override
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	@Override
	public void createOrder(Order order) {
		orderDao.createOrder(order);
	}
	
	@Override
	public List<LineGroupBuy> getLineGroupBuys(int orderId) {
		return orderDao.getLineGroupBuys(orderId);
	}
	
	
	/* 추가 메소드 */
	
	public GroupBuy getGroupBuy(int orderId) {
		int groupBuyId = orderDao.getGroupBuyId(orderId);
		return groupBuyDao.getGroupBuy(groupBuyId);
	}
	
	public Auction getAuction(int orderId) {
		int auctionId = orderDao.getAuctionId(orderId);
		return auctionDao.getAuction(auctionId);
	}
	
	
	/* Business Logic (?) */
	
	public List<Order> setInfo(List<Order> orderList) {
		if (orderList == null) {
			return null;
		}
		
		for (Order order : orderList) {
			int orderId = order.getOrderId();
			order.setGroupBuy(getGroupBuy(orderId));
			order.setAuction(getAuction(orderId));
		}
		return orderList;
	}
	

	
}
