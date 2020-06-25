package dongduk.cs.ssd.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.mybatis.mapper.LineGroupBuyMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.OrderMapper;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;

/**
 * @author Seonmi Hwang
 * @since 2020.06.12
 */

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;
	@Autowired
	protected LineGroupBuyMapper lineGroupBuyMapper;
	
	@Override
	public Order getOrder(int orderId) throws DataAccessException {
	    return orderMapper.getOrder(orderId);
	}

	@Override	
	public Order getOrderWithLineGroupBuys(int orderId) throws DataAccessException {
		return orderMapper.getOrderWithLineGroupBuys(orderId);
	}

	@Override
	public void createOrder(Order order) throws DataAccessException {
		orderMapper.createOrder(order);
		
		LineGroupBuy lineGroupBuy = order.getLineGroupBuy();
		lineGroupBuy.setOrderId(order.getOrderId());
		lineGroupBuyMapper.insertLineGroupBuy(lineGroupBuy);
		
//		if (order.getLineGroupBuys() != null) {
//			for (int i = 0; i < order.getLineGroupBuys().size(); i++) {
//				LineGroupBuy lineGroupBuy = (LineGroupBuy) order.getLineGroupBuys().get(i);
//				lineGroupBuy.setOrderId(order.getOrderId());
//				lineGroupBuyMapper.insertLineGroupBuy(lineGroupBuy);
//			}
//		} 
	}
	
	@Override
	public int getGroupBuyId(int orderId) throws DataAccessException { // From LineGroupBuys
		return orderMapper.getGroupBuyId(orderId);
	}
	
	@Override
	public int getAuctionId(int orderId) throws DataAccessException { // From SuccessBidders
		return orderMapper.getAuctionId(orderId);
	}
}
