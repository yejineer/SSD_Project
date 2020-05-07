package dongduk.cs.ssd.controller.auction;

import dongduk.cs.ssd.domain.Bid;

/**
 * @author Hyekyung Kim
 * @since 2020.05.08
 */

public class BidForm {

	private Bid bid;
	
	public BidForm() {
		
	}
	
	public BidForm(Bid bid) {
		this.bid = bid;
	}
	
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	
	public Bid getBid() {
		return bid;
	}
}
