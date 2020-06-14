package dongduk.cs.ssd.controller.auction;

import java.io.Serializable;
import java.util.Date;

import dongduk.cs.ssd.domain.Auction;

/**
 * @author Hyekyung Kim
 * @since 2020.05.08
 */

@SuppressWarnings("serial")
public class AuctionForm implements Serializable{
	private Auction auction;
	
	private boolean newAuction;
	
	public AuctionForm() {
		this.auction = new Auction();
		this.newAuction = true;
	}
	
	public AuctionForm(Auction auction) {
		this.auction = auction;
		this.newAuction = false;
	}
	
	public Auction getAuction() {
		return auction;
	}
	
	public boolean isNewAuction() {
		return newAuction;
	}
	
	public String toString() {
		return auction.toString();
	}
}
