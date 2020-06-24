package dongduk.cs.ssd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.GroupBuyDao;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Option;
import dongduk.cs.ssd.service.GroupBuyService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

/**
 * @author hk
 * @since 2020.06.14
 */

@Service
public class GroupBuyServiceImpl implements GroupBuyService {
	
	@Autowired
	private GroupBuyDao groupBuyDao;
	
	public GroupBuy getGroupBuy(int groupBuyId) {
		return groupBuyDao.getGroupBuy(groupBuyId);
	}
	
	public void createGroupBuy(GroupBuy groupBuy) {
		groupBuyDao.createGroupBuy(groupBuy);
	}
	
	public void updateGroupBuy(GroupBuy groupBuy) {
		groupBuyDao.updateGroupBuy(groupBuy);
	}
	
	public void deleteOptions(int groupBuyId) {
		groupBuyDao.deleteOptions(groupBuyId);
	}
	
	public void deleteGroupBuy(int groupBuyId) {
		groupBuyDao.deleteGroupBuy(groupBuyId);
	}
	
	public void createOptions(GroupBuy groupBuy) {
		groupBuyDao.createOptions(groupBuy);
	}
	
	public List<GroupBuy> getGroupBuyList() {
		return groupBuyDao.getGroupBuyList();
	}

	/*
	public List<GroupBuy> getGroupBuyListByKeyword(String keyword) {
		return groupBuyDao.getGroupBuyListByKeyword(keyword);
	}
	*/
}
