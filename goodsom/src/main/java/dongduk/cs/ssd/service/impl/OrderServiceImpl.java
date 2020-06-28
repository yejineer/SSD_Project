package dongduk.cs.ssd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.dao.AuctionDao;
import dongduk.cs.ssd.dao.GroupBuyDao;
import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.OrderService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

@Service
@Transactional
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
	public int createOrder(Order order) {
		return orderDao.createOrder(order);
	}
	
	@Override
	public Order getOrderWithLineGroupBuys(int orderId) {
		return orderDao.getOrderWithLineGroupBuys(orderId);
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
	
	public List<Order> setAuctionInfo(List<Order> auctionOrderList) {
		
		if (auctionOrderList == null) {
			return null;
		}
		
		for (Order order : auctionOrderList) {
			int auctionId = order.getAuctionId();
			order.setAuction(auctionDao.getAuction(auctionId));
			order.setMenuId(1);
		}
		return auctionOrderList;
	}
	
	public List<Order> setGroupBuyInfo(List<Order> groupBuyOrderList) {
		
		if (groupBuyOrderList == null) {
			return null;
		}
		
		for (Order order : groupBuyOrderList) {
			int groupBuyId = order.getGroupBuyId();
			order.setGroupBuy(groupBuyDao.getGroupBuy(groupBuyId));
			order.setMenuId(2);
		}
		return groupBuyOrderList;
	}

}
