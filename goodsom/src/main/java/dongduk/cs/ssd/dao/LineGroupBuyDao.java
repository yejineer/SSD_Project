package dongduk.cs.ssd.dao;

import java.util.List;

import dongduk.cs.ssd.domain.LineGroupBuy;

public interface LineGroupBuyDao {
	
	void insertLineGroupBuy(LineGroupBuy lineGroupBuy);
	
	List<LineGroupBuy> getLineGroupBuys(int orderId);
}
