package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

public interface OrderDao {
	
	  List<Order> getOrderList(int userId) throws DataAccessException;

	  Order getOrder(int orderId) throws DataAccessException;

	  void createOrder(Order order) throws DataAccessException;

}
