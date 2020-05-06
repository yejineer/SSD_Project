package dongduk.cs.ssd.controller.groupBuy;

import java.util.List;

import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.LineGroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

public class LineGroupBuyCommand {
	private List<LineGroupBuy> lineGroupBuys;

//	public LineGroupBuy getLineGroupBuy 다시 만들자.
	
	public void addLineGroupBuy(LineGroupBuy lineGroupBuy) {
		lineGroupBuys.add(lineGroupBuy);
	}
}
