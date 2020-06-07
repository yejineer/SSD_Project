package dongduk.cs.ssd.controller.order;

import java.io.Serializable;
import dongduk.cs.ssd.domain.Order;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */

@SuppressWarnings("serial")
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
