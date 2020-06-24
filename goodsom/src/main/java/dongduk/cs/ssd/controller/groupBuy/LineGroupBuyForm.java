package dongduk.cs.ssd.controller.groupBuy;

import java.util.List;

import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.LineGroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

public class LineGroupBuyForm {

	int groupBuyId;
	int quantity;
	String option;
	int unitPrice;
	GroupBuy groupBuy = new GroupBuy();
	
	public int getGroupBuyId() {
		return groupBuyId;
	}

	public void setGroupBuyId(int groupBuyId) {
		this.groupBuyId = groupBuyId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public GroupBuy getGroupBuy() {
		return groupBuy;
	}

	public void setGroupBuy(GroupBuy groupBuy) {
		this.groupBuy = groupBuy;
	}
	
	@Override
	public String toString() {
		return "LineGroupBuyForm [groupBuyId=" + groupBuyId + ", quantity=" + quantity + ", option=" + option
				+ ", unitPrice=" + unitPrice + ", groupBuy=" + groupBuy + "]";
	}

	
//	private String[] item; // (option, quantity)쌍의 배열 from groupBuy_detail.jsp
//
//	private List<LineGroupBuy> lineGroupBuyList;
//	
//	private int groupBuyId;
//	
//	GroupBuy groupBuy = new GroupBuy();
//	
//	public GroupBuy getGroupBuy() {
//		return groupBuy;
//	}
//
//	public void setGroupBuy(GroupBuy groupBuy) {
//		this.groupBuy = groupBuy;
//	}
//	
//	public void setLineGroupBuyListByItems() {
//		String[] items = getItem();
//		
//		for (int i = 0; i < items.length; i++) {
//			LineGroupBuy lineGroupBuy = new LineGroupBuy();
//			
//			String option = items[i].split(", ")[0];
//			int quantity = Integer.parseInt(items[i].split(", ")[1]);
//			
//			lineGroupBuy.setOption(option);
//			lineGroupBuy.setQuantity(quantity);
//		}
//	}
//	
//	public String[] getItem() {
//		return item;
//	}
//
//	public void setItem(String[] item) {
//		this.item = item;
//	}
//	
//	public int getGroupBuyId() {
//		return groupBuyId;
//	}
//
//	public void setGroupBuyId(int groupBuyId) {
//		this.groupBuyId = groupBuyId;
//	}
//
//	public List<LineGroupBuy> getLineGroupBuyList() {
//		return lineGroupBuyList;
//	}
//	
//	public void setLineGroupBuyList(List<LineGroupBuy> lineGroupBuyList) {
//		this.lineGroupBuyList = lineGroupBuyList;
//	}
//	
//	public void addLineGroupBuy(LineGroupBuy lineGroupBuy) {
//		lineGroupBuyList.add(lineGroupBuy);
//	}
//	
//	public void removeLineGroupBuyById(int lineId) {
//		lineGroupBuyList.remove(lineId);
//	}
//	
//	public int getTotalPrice() {
//		int totalPrice = 0;
//
//		for (LineGroupBuy lineGroupBuy : lineGroupBuyList) {
//			totalPrice += lineGroupBuy.getUnitPrice();
//		}
//		return totalPrice;
//	}
	
}
