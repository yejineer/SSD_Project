package dongduk.cs.ssd.controller.auction;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import dongduk.cs.ssd.domain.Auction;

/**
 * @author Hyekyung Kim | Yejin Lee
 * @since 2020.05.08	| 2020.06.13
 */

@SuppressWarnings("serial")
public class AuctionForm implements Serializable{
	
	@Valid
	private Auction auction;
	@NotEmpty @Pattern(regexp="^[1-9][0-9]*")
	private String price;
	
	private boolean newAuction;
	
	public AuctionForm() {
		this.auction = new Auction();
		this.newAuction = true;
	}
	
	public AuctionForm(Auction auction) {
		this.auction = auction;
		this.newAuction = false;
	}
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
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
