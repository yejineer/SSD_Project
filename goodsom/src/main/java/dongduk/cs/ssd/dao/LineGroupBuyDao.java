package dongduk.cs.ssd.dao;

import java.util.List;

import dongduk.cs.ssd.domain.LineGroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.06.27
 */

public interface LineGroupBuyDao {
	
	void insertLineGroupBuy(LineGroupBuy lineGroupBuy);
	
	List<LineGroupBuy> getLineGroupBuys(int orderId);
}
