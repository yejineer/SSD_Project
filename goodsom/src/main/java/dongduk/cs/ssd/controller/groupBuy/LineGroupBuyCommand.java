package dongduk.cs.ssd.controller.groupBuy;

import java.util.List;
import dongduk.cs.ssd.domain.LineGroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

public class LineGroupBuyCommand {
	private List<LineGroupBuy> lineGroupBuyList;
	private int groupBuyId;

	public int getGroupBuyId() {
		return groupBuyId;
	}

	public void setGroupBuyId(int groupBuyId) {
		this.groupBuyId = groupBuyId;
	}

	public List<LineGroupBuy> getLineGroupBuyList() {
		return lineGroupBuyList;
	}
	
	public void setLineGroupBuyList(List<LineGroupBuy> lineGroupBuyList) {
		this.lineGroupBuyList = lineGroupBuyList;
	}
	
	public void addLineGroupBuy(LineGroupBuy lineGroupBuy) {
		lineGroupBuyList.add(lineGroupBuy);
	}
	
	public void removeLineGroupBuyById(int lineId) {
		lineGroupBuyList.remove(lineId);
	}
	
	public int getTotalPrice() {
		int totalPrice = 0;

		for (LineGroupBuy lineGroupBuy : lineGroupBuyList) {
			totalPrice += lineGroupBuy.getUnitPrice();
		}
		return totalPrice;
	}

}
