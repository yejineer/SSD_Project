package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import dongduk.cs.ssd.domain.LineGroupBuy;

public interface LineGroupBuyMapper {
	
	int insertLineGroupBuy(LineGroupBuy lineGroupBuy);
	
	List<LineGroupBuy> getLineGroupBuys(int orderId);
}
