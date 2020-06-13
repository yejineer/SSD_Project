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
public class OrderServiceImpl {//implements OrderService {

//	@Autowired
//	private OrderDao orderDao;
//	@Autowired
//	private GroupBuyDao groupBuyDao;
//	@Autowired
//	private AuctionDao auctionDao;
//	@Autowired
//	private UserDao userDao;
//
//	public User getUser(String emailId) {
//		return userDao.getUserByEmailId(emailId);
//	}
//
//	public GroupBuy getGroupBuy(int groupBuyId) {
//		return groupBuyDao.getGroupBuy(groupBuyId);
//	}
//
//	public Auction getAuction(int auctionId) {
//		return auctionDao.getAuction(auctionId);
//	}
//
//	public Order getOrder(int orderId) {
//		return orderDao.getOrder(orderId);
//	}
//
//	public void createOrder(Order order) {
//		orderDao.createOrder(order);
//	}
//
//	public List<Order> getOrderList(int userId) {
//		return orderDao.getOrderList(userId);
//	}
//	
//	public LineGroupBuy getLineGroupBuy(int orderId) {
//		return orderDao.getLineGroupBuy(orderId);
//	}

}
