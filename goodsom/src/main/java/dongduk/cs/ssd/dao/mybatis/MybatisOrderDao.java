package dongduk.cs.ssd.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.SequenceDao;
import dongduk.cs.ssd.dao.mybatis.mapper.LineGroupBuyMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.OrderMapper;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;
	@Autowired
	protected LineGroupBuyMapper lineGroupBuyMapper;
	@Autowired
	protected SequenceDao sequenceDao;
	
	public Order getOrder(int orderId) throws DataAccessException {
	    return orderMapper.getOrder(orderId);
	}
	
	public Order getOrderWithLineGroupBuys(int orderId) throws DataAccessException {
		return orderMapper.getOrderWithLineGroupBuys(orderId);
	}

	public void createOrder(Order order) throws DataAccessException {
		order.setOrderId(sequenceDao.getNextId("orderNum"));
		orderMapper.createOrder(order);
		
		if (order.getLineGroupBuys() != null) {
			for (int i = 0; i < order.getLineGroupBuys().size(); i++) {
				LineGroupBuy lineGroupBuy = (LineGroupBuy) order.getLineGroupBuys().get(i);
				lineGroupBuy.setOrderId(order.getOrderId());
				lineGroupBuyMapper.insertLineGroupBuy(lineGroupBuy);
			}
		} 
	}
	
	public int getGroupBuyId(int orderId) throws DataAccessException { // From LineGroupBuys
		return orderMapper.getGroupBuyId(orderId);
	}
	
	public int getAuctionId(int orderId) throws DataAccessException { // From SuccessBidders
		return orderMapper.getAuctionId(orderId);
	}
}
