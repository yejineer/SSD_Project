package dongduk.cs.ssd.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.mybatis.mapper.OrderMapper;
import dongduk.cs.ssd.domain.Order;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	protected OrderMapper orderMapper;
	
	public List<Order> getOrderList(int userId) throws DataAccessException {
		return new ArrayList<Order>(); 
	}

	public Order getOrder(int orderId) throws DataAccessException {
		return sqlSession.getMapper(OrderMapper.class).getOrder(orderId);
//		Order order = orderMapper.getOrder(orderId);
//		if (order != null) {
//			order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
//		}
//	    return order;
	}

	public void createOrder(Order order) throws DataAccessException {
		
	}



//	@Transactional
//	public Order getOrder(int orderId) throws DataAccessException {
//		Order order = orderMapper.getOrder(orderId);
//		if (order != null) {
//			order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
//		}
//	    return order;
//	}
//	
//	@Transactional
//	public void insertOrder(Order order) throws DataAccessException {  
//    	order.setOrderId(sequenceDao.getNextId("ordernum"));
//    	orderMapper.createOrder(order);
//    	orderMapper.insertOrderStatus(order);
//    	for (int i = 0; i < order.getLineItems().size(); i++) {
//    		LineItem lineItem = (LineItem) order.getLineItems().get(i);
//    		lineItem.setOrderId(order.getOrderId());
//    		lineItemMapper.insertLineItem(lineItem);
//    	}
//	}
}
