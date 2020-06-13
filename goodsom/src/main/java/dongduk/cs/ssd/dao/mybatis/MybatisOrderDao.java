package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.mybatis.mapper.OrderMapper;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;

	public Order getOrder(int orderId) throws DataAccessException {
	    return orderMapper.getOrder(orderId);
	}
	
	public List<LineGroupBuy> getLineGroupBuys(int orderId) throws DataAccessException {
		return orderMapper.getLineGroupBuys(orderId);
	}

	public void createOrder(Order order) throws DataAccessException {
		orderMapper.createOrder(order);
	}
	
	
	public int getGroupBuyId(int orderId) throws DataAccessException { // From LineGroupBuys
		return orderMapper.getGroupBuyId(orderId);
	}
	
	public int getAuctionId(int orderId) throws DataAccessException { // From SuccessBidders
		return orderMapper.getAuctionId(orderId);
	}
}
