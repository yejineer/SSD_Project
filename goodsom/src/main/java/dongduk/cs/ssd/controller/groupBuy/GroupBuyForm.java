package dongduk.cs.ssd.controller.groupBuy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

public class GroupBuyForm implements Serializable {
	
	private GroupBuy groupBuy;
	
	private boolean newGroupBuy;
	
	public GroupBuyForm() {
		this.groupBuy = new GroupBuy();
		this.newGroupBuy = true;
	}
	
	public GroupBuyForm(GroupBuy groupBuy) {
		this.groupBuy = groupBuy;
		this.newGroupBuy = false;
	}
	
	public GroupBuy getGroupBuy() {
		return groupBuy;
	}

	public boolean isNewGroupBuy() {
		return newGroupBuy;
	}
}
