package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Order;

/**
 * @author Seonmi Hwang
 * @since 2020.06.11
 */

public interface OrderMapper { // xml과 method 이름이 일치해야함!
	
	  List<Order> getOrderList(int userId) throws DataAccessException;

	  Order getOrder(int orderId) throws DataAccessException;

	  void createOrder(Order order) throws DataAccessException;

	  // 추가할 메소드 있나?
}