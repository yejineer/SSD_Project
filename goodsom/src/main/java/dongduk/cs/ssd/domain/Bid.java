package dongduk.cs.ssd.domain;

import java.util.Date;

public class Bid {
	int bidId;
	int userId;
	int auctionId;
	int bidPrice;
	Date bidDate;
	User user = new User();
	
	public Bid() {
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBidId() {
		return bidId;
	}
	
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getAuctionId() {
		return auctionId;
	}
	
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	
	public int getBidPrice() {
		return bidPrice;
	}
	
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	public Date getBidDate() {
		return bidDate;
	}
	
	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}
	
}
