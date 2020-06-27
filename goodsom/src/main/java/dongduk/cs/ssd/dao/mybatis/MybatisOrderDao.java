package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

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
	    Order order = orderMapper.getOrder(orderId);
	    return order;
	}

	@Override	
	public Order getOrderWithLineGroupBuys(int orderId) throws DataAccessException {
		return orderMapper.getOrderWithLineGroupBuys(orderId);
	}

	@Override
	public int createOrder(Order order) throws DataAccessException {
		int orderSuccess = orderMapper.createOrder(order);
		
		List<LineGroupBuy> lineGroupBuys = order.getLineGroupBuys();
		for (LineGroupBuy lineGroupBuy : lineGroupBuys) {
			lineGroupBuy.setOrderId(order.getOrderId());
			orderSuccess += lineGroupBuyMapper.insertLineGroupBuy(lineGroupBuy);
		}
		
		if (orderSuccess == lineGroupBuys.size() + 1) {
			return 1;
		} else {
			return 0;
		}
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
