package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dongduk.cs.ssd.dao.GroupBuyDao;
import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.01
 */

public class GroupBuyServiceImpl {
	@Autowired
	private GroupBuyDao groupBuyDao;
	
	public GroupBuy getGroupBuy(int groupBuyId) {
		return groupBuyDao.getGroupBuy(groupBuyId);
	}
	
	public List<GroupBuy> getGroupBuyList() {
		return groupBuyDao.getGroupBuyList();
	}
	
	public List<GroupBuy> getGroupBuyListByKeyword(String keyword) {
		return groupBuyDao.getGroupBuyListByKeyword(keyword);
	}
}
