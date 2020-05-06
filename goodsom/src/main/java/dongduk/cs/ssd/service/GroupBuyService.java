package dongduk.cs.ssd.service;


import java.util.List;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

import dongduk.cs.ssd.domain.GroupBuy;
public interface GroupBuyService {
	
	public GroupBuy getGroupBuy(int groupBuyId);
	
	public void deleteGroupBuy(int groupBuyId);
	
	public List<GroupBuy> getGroupBuyList();
	
	public List<GroupBuy> getGroupBuyListByKeyword(String keyword);
}
