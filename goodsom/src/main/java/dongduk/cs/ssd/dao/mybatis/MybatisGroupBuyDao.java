package dongduk.cs.ssd.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.GroupBuyDao;
import dongduk.cs.ssd.dao.mybatis.mapper.GroupBuyMapper;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Option;


/**
 * @author hk
 * @since 2020.06.13
 */

@Repository
public class MybatisGroupBuyDao implements GroupBuyDao {
	
	@Autowired
	private GroupBuyMapper groupBuyMapper;
	
	public GroupBuy getGroupBuy(int groupBuyId) throws DataAccessException{
		return groupBuyMapper.getGroupBuy(groupBuyId);
	}

	public void createGroupBuy(GroupBuy groupBuy) throws DataAccessException{
		groupBuyMapper.createGroupBuy(groupBuy);
	}

	public void updateGroupBuy(GroupBuy groupBuy) throws DataAccessException{
		groupBuyMapper.updateGroupBuy(groupBuy);
	}
	
	public void deleteOptions(int groupBuyId) throws DataAccessException{
		groupBuyMapper.deleteOptions(groupBuyId);
	}
	
	public void deleteGroupBuy(int groupBuyId) throws DataAccessException{
		groupBuyMapper.deleteGroupBuy(groupBuyId);
	}
	
	public void createOptions(GroupBuy groupBuy) throws DataAccessException{
		groupBuyMapper.createOptions(groupBuy);
	}
	
	public List<GroupBuy> getGroupBuyList() throws DataAccessException{
		return groupBuyMapper.getGroupBuyList();
	}
	
	public List<Option> getOptions(int groupBuyId) throws DataAccessException{
		return groupBuyMapper.getOptions(groupBuyId);
	}
}