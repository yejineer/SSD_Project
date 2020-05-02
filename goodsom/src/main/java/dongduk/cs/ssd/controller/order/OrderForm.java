package dongduk.cs.ssd.controller.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.LineGroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

/**
 * @author Seonmi Hwang
 * @since 2020.05.01
 */

public class OrderForm implements Serializable {
	String cardBank;
	String cardNo;
	String validDate;
	String cvc;
	String address1;
	String address2;
	String address3;
	String phone;
	String refundBank;
	String refundAccount;
	int userId;
	List<LineGroupBuy> lineGroupBuy = new ArrayList<LineGroupBuy>();
	Bid bid = new Bid();
	User user = new User();
	
}
