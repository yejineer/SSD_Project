package dongduk.cs.ssd.domain;

public class LineGroupBuy {
	int lineId;
	int orderId;
	int groupBuyId;
	int quantity;
	String option;
	int unitPrice;
	GroupBuy groupBuy = new GroupBuy();
	
	public GroupBuy getGroupBuy() {
		return groupBuy;
	}

	public void setGroupBuy(GroupBuy groupBuy) {
		this.groupBuy = groupBuy;
	}
	
	public LineGroupBuy() {
	}
	
	public int getLineId() {
		return lineId;
	}
	
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
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
}
