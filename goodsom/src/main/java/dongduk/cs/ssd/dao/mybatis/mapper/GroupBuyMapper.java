package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author hk
 * @since 2020.06.13
 */
public interface GroupBuyMapper { // GroupBuyMapper.xml에서 구현한 method 이름과 일치해야함!
	
	GroupBuy getGroupBuy(int groupBuyId) throws DataAccessException;

	void createGroupBuy(GroupBuy groupBuy) throws DataAccessException;

	void updateGroupBuy(GroupBuy groupBuy) throws DataAccessException;
	
	void deleteGroupBuy(int groupBuyId) throws DataAccessException;
	
	void createOptions(GroupBuy groupBuy) throws DataAccessException;
	
	List<GroupBuy> getGroupBuyList() throws DataAccessException;
}
