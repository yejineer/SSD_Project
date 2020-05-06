package dongduk.cs.ssd.service;

import java.util.List;
import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

public interface GroupBuyService {
	
	public GroupBuy getGroupBuy(int groupBuyId);
	
	public void createGroupBuy(GroupBuy groupBuy);
	
	public void updateGroupBuy(GroupBuy groupBuy);
	
	public void deleteGroupBuy(int groupBuyId);
	
	public List<GroupBuy> getGroupBuyList();
	
	public List<GroupBuy> getGroupBuyListByKeyword(String keyword);
}
