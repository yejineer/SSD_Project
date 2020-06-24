package dongduk.cs.ssd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Option;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */
/**
 * @author HK
 * @since 2020.06.22
 */


public interface GroupBuyService {
	
	public GroupBuy getGroupBuy(int groupBuyId);
	
	public void createGroupBuy(GroupBuy groupBuy);
	
	public int updateGroupBuy(GroupBuy groupBuy);
	
	public void deleteOptions(int groupBuyId);
	
	public void deleteGroupBuy(int groupBuyId);

	public void createOptions(GroupBuy groupBuy);
	
	public List<GroupBuy> getGroupBuyList();
	
	/*
	public List<GroupBuy> getGroupBuyListByKeyword(String keyword);
	*/
}
