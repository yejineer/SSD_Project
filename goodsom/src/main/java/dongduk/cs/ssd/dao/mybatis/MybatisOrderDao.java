package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.mybatis.mapper.OrderMapper;
import dongduk.cs.ssd.domain.Order;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;
	
	public List<Order> getOrderList(int userId) throws DataAccessException {
		return orderMapper.getOrderList(userId); 
	}

	public Order getOrder(int orderId) throws DataAccessException {
	    return orderMapper.getOrder(orderId);
	}

	public void createOrder(Order order) throws DataAccessException {
		orderMapper.createOrder(order);
	}

}
