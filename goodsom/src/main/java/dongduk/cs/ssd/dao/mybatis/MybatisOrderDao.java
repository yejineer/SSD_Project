package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.dao.OrderDao;
import dongduk.cs.ssd.dao.mybatis.mapper.GroupBuyMapper;
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
	@Autowired
	protected GroupBuyMapper groupBuyMapper;
	
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
	@Transactional
	public int createOrder(Order order) throws DataAccessException {
		// ORDERS 테이블에 order 삽입
		int orderSuccess = orderMapper.createOrder(order);
		
		// LINEGROUPBUYS 테이블에 lineGroupBuy들 삽입
		List<LineGroupBuy> lineGroupBuys = order.getLineGroupBuys();
		for (LineGroupBuy lineGroupBuy : lineGroupBuys) {
			lineGroupBuy.setOrderId(order.getOrderId());
			orderSuccess += lineGroupBuyMapper.insertLineGroupBuy(lineGroupBuy);
		}
		
		// GROUPBUYS 테이블에 참여자, 달성률, 상태 update
		orderSuccess += groupBuyMapper.updateState(order.getGroupBuy());
		
		return orderSuccess;
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
