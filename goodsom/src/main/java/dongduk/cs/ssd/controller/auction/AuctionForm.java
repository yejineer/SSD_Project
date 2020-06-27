package dongduk.cs.ssd.controller.auction;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

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
	private String inputPrice;
//	@NotNull 
//	private Date selectDate;
	
	private boolean newAuction;
	
	public AuctionForm() {
		this.auction = new Auction();
		this.newAuction = true;
	}
	
	public AuctionForm(Auction auction) {
		this.auction = auction;
		this.newAuction = false;
	}
	public String getInputPrice() {
		return inputPrice;
	}
	
	public void setInputPrice(String inputPrice) {
		this.inputPrice = inputPrice;
	}
	
	public Auction getAuction() {
		return auction;
	}
	
	public boolean isNewAuction() {
		return newAuction;
	}

//	public Date getSelectDate() {
//		return selectDate;
//	}

	@Override
	public String toString() {
		return "AuctionForm [auction=" + auction + ", inputPrice=" + inputPrice
				+ ", newAuction=" + newAuction + "]";
	}
	

}
