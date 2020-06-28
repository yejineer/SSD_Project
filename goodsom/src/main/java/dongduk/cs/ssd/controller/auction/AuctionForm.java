package dongduk.cs.ssd.controller.auction;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import dongduk.cs.ssd.domain.Auction;

/**
 * @author Hyekyung Kim | Yejin Lee
 * @since 2020.05.08	| 2020.06.13
 */

@SuppressWarnings("serial")
public class AuctionForm implements Serializable{
	
	@Valid
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
	
//	public String getInputPrice() {
//		return inputPrice;
//	}


	public boolean isNewAuction() {
		return newAuction;
	}

	@Override
	public String toString() {
		return "AuctionForm [auction=" + auction + ", newAuction=" + newAuction + "]";
	}

//	public Date getSelectDate() {
//		return selectDate;
//	}

}
