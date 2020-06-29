package dongduk.cs.ssd.service;

import java.util.Date;
import java.util.List;

import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author Seonmi Hwang | HK
 * @since 2020.05.06	| 2020.06.26
 */

public interface GroupBuyService {
	
	public GroupBuy getGroupBuy(int groupBuyId);
	
	public void createGroupBuy(GroupBuy groupBuy);
	
	public int updateGroupBuy(GroupBuy groupBuy);
	
	public void deleteOptions(int groupBuyId);
	
	public void deleteGroupBuy(int groupBuyId);

	public void createOptions(GroupBuy groupBuy);
	
	public void updateOptions(GroupBuy groupBuy);
	
	public List<GroupBuy> getGroupBuyList();
	
	public void increaseCount(GroupBuy groupBuy);
	
//	public List<GroupBuy> getGroupBuyListByKeyword(String keyword);
	
	public void deadLineScheduler(Date endDate, int groupBuyId);
	
	public List<GroupBuy> getRecentGroupBuyList();
	
}
