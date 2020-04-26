package dongduk.cs.ssd.domain;

import java.util.Date;

public class Notication {
	int notiId;
	int userId;
	int groupBuyId;
	int auctionId;
	String title;
	String content;
	Date notiDate;
	
	public Notication() {
	}
	
	public int getNotiId() {
		return notiId;
	}

	public void setNotiId(int notiId) {
		this.notiId = notiId;
	}

	public int getGroupBuyId() {
		return groupBuyId;
	}

	public void setGroupBuyId(int groupBuyId) {
		this.groupBuyId = groupBuyId;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getNotiDate() {
		return notiDate;
	}
	
	public void setNotiDate(Date notiDate) {
		this.notiDate = notiDate;
	}
	
}
