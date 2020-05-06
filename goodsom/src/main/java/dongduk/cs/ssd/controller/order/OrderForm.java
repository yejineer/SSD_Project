package dongduk.cs.ssd.controller.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */

public class OrderForm implements Serializable {
	private Order order;
	
	private boolean newOrder;
	
	public OrderForm() {
		this.order = new Order();
		this.newOrder = true;
	}
	
	public OrderForm(Order order) {
		this.order = order;
		this.newOrder = false;
	}
	
	public Order getOrder() {
		return order;
	}

	public boolean isNewOrder() {
		return newOrder;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
