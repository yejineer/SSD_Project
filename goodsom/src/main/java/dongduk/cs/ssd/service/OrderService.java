package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.domain.Order;

/**
 * @author Seonmi Hwang
 * @since 2020.05.01
 */

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}
	
	public List<Order> getOrderList(int userId) {
		return orderDao.getOrderList(userId);
	}
}
