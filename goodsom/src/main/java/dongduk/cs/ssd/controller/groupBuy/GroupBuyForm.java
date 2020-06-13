package dongduk.cs.ssd.controller.groupBuy;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

@SuppressWarnings("serial")
public class GroupBuyForm implements Serializable {
	
	@Autowired
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
		System.out.println("groupBuy 객체: " + groupBuy.toString());
		return groupBuy;
	}
	/*
	public boolean isNewGroupBuy() {
		return newGroupBuy;
	}
	*/
}
